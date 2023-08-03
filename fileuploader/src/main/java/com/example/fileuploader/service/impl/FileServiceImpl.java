package com.example.fileuploader.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileuploader.config.IntegrationConfig;
import com.example.fileuploader.entity.FileInfo;
import com.example.fileuploader.exception.AppError;
import com.example.fileuploader.exception.AppException;
import com.example.fileuploader.repository.FileRepository;
import com.example.fileuploader.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

	@Autowired
	private FileRepository fileRepo;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private IntegrationConfig.CustomGateway sftpGateway;

	@Value("${application.kafka.topic.name}")
	private String kakfaTopic;
	
	@Autowired
	private CustomUserRepositoryImpl customUserRepositoryImpl;

	@Override
	public FileInfo uploadFile(MultipartFile multiPartFile) {

		this.validateFile(multiPartFile);

		File compressedFile = null;

		String compressedFileName = null;

		long compressedFileSize = 0;

		FileInfo fileInfo = null;
		try {
			compressedFile = this.convertMultiPartToGzipFile(multiPartFile);
			compressedFileName = compressedFile.getName();
			compressedFileSize = compressedFile.length();

			logger.info("Size of File:{} Before Compression: {}", multiPartFile.getOriginalFilename(),
					multiPartFile.getSize());

			logger.info("Size of File:{} After Compression: {}", multiPartFile.getOriginalFilename(),
					compressedFileSize);

			sftpGateway.sendToSftp(compressedFile);
			fileInfo = this.CreateFileInfo(multiPartFile, compressedFileName, compressedFileSize);
			this.publishMsgInKafka(compressedFileName);
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Error Occure While Uploading File, {}", e.getMessage());
			throw new AppException(AppError.FILE_UPLOAD_FAILED);
		} finally {
			compressedFile.delete();
		}
		return fileInfo;
	}

	private void validateFile(MultipartFile file) {
		logger.info("validating Mulitpart File");
		if (file.isEmpty()) {
			throw new AppException(AppError.FILE_NOT_FOUND);
		}
	}

	private void publishMsgInKafka(String fileName) {
		try {
			logger.info("Publishing Message to Kafka Topic: " + kakfaTopic);
			kafkaTemplate.send(kakfaTopic, fileName);
		} catch (Exception e) {
			logger.error("Error Occurred while pulishing message to Kafka Topic: {}, {}", kakfaTopic, e.getMessage());
			throw new AppException(AppError.KAFKA_MSG_PUBLISH_FAILED);
		}
	}

	private FileInfo CreateFileInfo(MultipartFile multipartFile, String compressedFileName, long compressedFileSize) {

		
		FileInfo fileInfoOptional1 = customUserRepositoryImpl.customFindMethod(compressedFileName);
		
		//FileInfo fileInfoOptional1 = fileRepo.customFindMethod(compressedFileName);
		
//		Optional<FileInfo> fileInfoOptional = fileRepo.findById(compressedFileName);
//		FileInfo fileInfo = null;
//
//		if (fileInfoOptional.isPresent()) {
//			logger.info("Updating the FileInfo Record: {} into Db", compressedFileName);
//
//			try {
//				fileInfo = fileInfoOptional.get();
//				fileInfo.setStatus(FileStatus.UPLOADED.name());
//				fileInfo.setOriginalFileSize(multipartFile.getSize());
//				fileInfo.setCompressedFileSize(compressedFileSize);
//				fileInfo = fileRepo.save(fileInfo);
//			} catch (Exception e) {
//				logger.error("Error Occurred while updating FileInfo, {}", e.getMessage());
//				throw new AppException(AppError.FILE_INFO_UPDATION_FAILED);
//			}
//		} else {
//			fileInfo = new FileInfo();
//			try {
//				logger.info("Inserting a FileInfo Record: {} into Db", compressedFileName);
//				fileInfo.setId(compressedFileName);
//				fileInfo.setFileDescription(compressedFileName);
//				fileInfo.setFileName(compressedFileName);
//				fileInfo.setStatus(FileStatus.UPLOADED.name());
//				fileInfo.setOriginalFileSize(multipartFile.getSize());
//				fileInfo.setCompressedFileSize(compressedFileSize);
//				fileInfo.setContentType(multipartFile.getContentType());
//				fileInfo = fileRepo.save(fileInfo);
//			} catch (Exception e) {
//				logger.error("Error Occurred while saving FileInfo, {}", e.getMessage());
//				throw new AppException(AppError.FILE_INFO_INSERTION_FAILED);
//			}
//		}
		return new FileInfo();
	}

	private File convertMultiPartToGzipFile(MultipartFile file) {
		String gzipFile = file.getOriginalFilename() + ".gz";

		try (InputStream fis = file.getInputStream();
				FileOutputStream fos = new FileOutputStream(gzipFile);
				GZIPOutputStream gzipOS = new GZIPOutputStream(fos)) {

			byte[] buffer = new byte[1024];
			int len;
			while ((len = fis.read(buffer)) != -1) {
				gzipOS.write(buffer, 0, len);
			}
		} catch (IOException e) {
			logger.error("Error occurred while converting Multipart to Gzip File: {}", e.getMessage());
			throw new AppException(AppError.MULTIPART_TO_GZIP_FILE_CONVERSION_FAILED, e.getMessage());
		}

		return new File(gzipFile);
	}

	public File convertMultiPartToFile(MultipartFile multipartFile) throws IOException {
		try {
			File convFile = new File(multipartFile.getOriginalFilename());
			convFile.createNewFile();

			try (FileOutputStream fos = new FileOutputStream(convFile)) {
				fos.write(multipartFile.getBytes());
			}

			return convFile;
		} catch (IOException e) {
			logger.error("Error occurred while converting Multipart to File: {}", e.getMessage());
			throw new AppException(AppError.MULTIPART_TO_FILE_CONVERSION_FAILED, e.getMessage());
		}
	}

}
