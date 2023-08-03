package com.example.kafkalistener.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import org.apache.sshd.sftp.client.SftpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.messaging.MessageHandler;

@Configuration
public class IntegrationConfig {

	Logger logger = LoggerFactory.getLogger(IntegrationConfig.class);

	@Value("${application.files.download.path}")
	private String filedownloadPath;

	@Value("${application.files.deletion.enable}")
	private boolean isFileDeletionEnable;

	@Bean
	public SessionFactory<SftpClient.DirEntry> sftpSessionFactory(SftpConfiguration configuration) {
		DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
		factory.setHost(configuration.getHost());
		factory.setPort(configuration.getPort());
		factory.setUser(configuration.getUser());
		factory.setPassword(configuration.getPassword());
		factory.setAllowUnknownKeys(true);
		return new CachingSessionFactory<SftpClient.DirEntry>(factory);
	}

	@MessagingGateway
	public interface CustomGateway {
		@Gateway(requestChannel = "fromSftpChannel")
		File downloadFromSftp(String filename);
	}

	@Bean
	@ServiceActivator(inputChannel = "fromSftpChannel")
	public MessageHandler downloadHandler(SftpConfiguration configuration) {
		return message -> {

			String fileName = (String) message.getPayload();

			String remoteFilePath = configuration.getDirectory() + "/" + fileName;

			String localFilePath = filedownloadPath + fileName;

			downloadFile(remoteFilePath, localFilePath, configuration);
			if (isFileDeletionEnable)
				this.deleteFileFromSFTPserver(remoteFilePath, configuration);

		};
	}

	private void deleteFileFromSFTPserver(String remoteFilePath, SftpConfiguration configuration) {

		logger.info("Deleting File: {} from SFTP server", remoteFilePath);

		try (SftpClient sftpClient = (SftpClient) sftpSessionFactory(configuration).getSession().getClientInstance()) {
			sftpClient.remove(remoteFilePath);
			logger.info("Successfully Deleted File: {} from SFTP server", remoteFilePath);
		} catch (Exception e) {
			logger.error("Error occurred while deleting file: {} from SFTP server: {}", remoteFilePath, e.getMessage());
		}
	}

	private void downloadFile(String remoteFilePath, String localFilePath, SftpConfiguration configuration) {

		logger.info("Downloading File: {} from SFTP server", remoteFilePath);

		if (localFilePath.contains(".")) {
			localFilePath = localFilePath.substring(0, localFilePath.lastIndexOf('.'));
		}

		try (SftpClient sftpClient = (SftpClient) sftpSessionFactory(configuration).getSession().getClientInstance();
				InputStream inputStream = sftpClient.read(remoteFilePath);
				GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
				FileOutputStream outputStream = new FileOutputStream(localFilePath)) {

			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = gzipInputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			logger.info("Successfully Downloaded File: {} from SFTP server", remoteFilePath);
		} catch (Exception e) {
			logger.error("An Error Occured While Downloading file: {} from SFTP Server: {} ",remoteFilePath, e.getMessage());
		}
	}
}
