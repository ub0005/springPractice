package com.example.fileuploader.exception;

import org.springframework.http.HttpStatus;

public enum AppError {

	FILE_UPLOAD_FAILED("FILE_UPLOAD_001", "Error While Uploading File", HttpStatus.INTERNAL_SERVER_ERROR.value()),
	KAFKA_MSG_PUBLISH_FAILED("FILE_UPLOAD_002", "Error While Publishing Message to Kafka", HttpStatus.INTERNAL_SERVER_ERROR.value()),
	FILE_INFO_INSERTION_FAILED("FILE_UPLOAD_003", "Error While Inserting File Info", HttpStatus.INTERNAL_SERVER_ERROR.value()), 
	MULTIPART_TO_FILE_CONVERSION_FAILED("FILE_UPLOAD_004", "Error While converting Multipart File to File", HttpStatus.INTERNAL_SERVER_ERROR.value()),
	FILE_NOT_FOUND("FILE_UPLOAD_005", "Multipart File Missing in the request", HttpStatus.BAD_REQUEST.value()), 
	FILE_SIZE_LIMIT_EXCEEDED("FILE_UPLOAD_006", "Max File Size Limit Exceeded", HttpStatus.BAD_REQUEST.value()), 
	MULTIPART_TO_GZIP_FILE_CONVERSION_FAILED("FILE_UPLOAD_007", "Error While converting Multipart to Gzip File", HttpStatus.INTERNAL_SERVER_ERROR.value()),
	FILE_INFO_UPDATION_FAILED("FILE_UPLOAD_008", "Error While Updating File Info", HttpStatus.INTERNAL_SERVER_ERROR.value());

	private final String code;
	private final String userMessage;
	private final int httpStatusCode;

	private AppError(String code, String userMessage, int httpStatusCode) {
		this.code = code;
		this.userMessage = userMessage;
		this.httpStatusCode = httpStatusCode;
	}

	public String getCode() {
		return code;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

}
