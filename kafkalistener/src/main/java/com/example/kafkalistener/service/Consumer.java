package com.example.kafkalistener.service;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafkalistener.config.IntegrationConfig;
import com.example.kafkalistener.entity.FileInfo;
import com.example.kafkalistener.repository.FileInfoRepository;

@Service
public class Consumer {

	Logger logger = LoggerFactory.getLogger(Consumer.class);

	@Autowired
	private FileInfoRepository fileInfoRepo;

	@Autowired
	private IntegrationConfig.CustomGateway gateway;

	@Value("${application.kafka.topic.name}")
	private String kakfaTopic;

	@Value("${application.files.deletion.enable}")
	private boolean isFileDeletionEnable;

	@KafkaListener(topics = "file-events", groupId = "file-events-group")
	public void listenToTopic(String recievedMsg) throws IOException {

		logger.info("Recieved a message: {} from kafka topic: {}", recievedMsg, kakfaTopic);

		gateway.downloadFromSftp(recievedMsg);
		if (isFileDeletionEnable)
			this.updateFileInfo(recievedMsg);
	}

	private FileInfo updateFileInfo(String fileName) {

		logger.info("Updating File Info of file: " + fileName + " Status as Deleted");
		FileInfo fileInfo = null;

		try {
			Optional<FileInfo> fileInfoOptional = fileInfoRepo.findById(fileName);

			if (fileInfoOptional.isPresent()) {
				fileInfo = fileInfoOptional.get();
				fileInfo.setStatus("DELETED");
				fileInfo = fileInfoRepo.save(fileInfo);
				logger.info("Sucessfully Updated File Info Status as Deleted");
			} else {
				logger.error("No File Info Record Found in Database for Filename: {}", fileName);
			}
		} catch (Exception e) {
			logger.error("An Error Occurred While Updating File Info: {}", e.getMessage());
		}

		return fileInfo;
	}
}
