package com.example.fileuploader.config;

import java.io.File;

import org.apache.sshd.sftp.client.SftpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.common.LiteralExpression;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.outbound.SftpMessageHandler;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.messaging.MessageHandler;

@Configuration
public class IntegrationConfig {
	
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

    @Bean
    @ServiceActivator(inputChannel = "toSftpChannel")
    public MessageHandler handler(SftpConfiguration configuration) {
        SftpMessageHandler handler = new SftpMessageHandler(sftpSessionFactory(configuration));
        handler.setRemoteDirectoryExpression(new LiteralExpression(configuration.getDirectory()));
        handler.setLoggingEnabled(true);
        handler.setFileNameGenerator(message -> {
            if (message.getPayload() instanceof File) {
                return ((File) message.getPayload()).getName();
            } else {
                throw new IllegalArgumentException("File expected in message payload");
            }
        });
        return handler;
    }

    @MessagingGateway
    public interface CustomGateway {
        @Gateway(requestChannel = "toSftpChannel")
        void sendToSftp(File file);
    }
}
