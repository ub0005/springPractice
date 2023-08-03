package com.example.fileuploader.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.example.fileuploader.exception.AppError;
import com.example.fileuploader.exception.AppErrorResponseDTO;
import com.example.fileuploader.exception.AppException;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = { AppException.class })
	public ResponseEntity<AppErrorResponseDTO> wrapperException(final AppException e) {

		logError(e);
		AppError error = e.getError();
		AppErrorResponseDTO err = new AppErrorResponseDTO(error.getCode(), error.name(),
				StringUtils.isEmpty(e.getErrorMessage()) ? error.getUserMessage() : e.getErrorMessage());
		return error(err, error.getHttpStatusCode());
	}
	
    @ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<AppErrorResponseDTO> handleMaxSizeException(MaxUploadSizeExceededException e) {
		
    	AppError error = AppError.FILE_SIZE_LIMIT_EXCEEDED;
		AppErrorResponseDTO err = new AppErrorResponseDTO(error.getCode(), error.name(), error.getUserMessage());
		return error(err, error.getHttpStatusCode());
	}

	private ResponseEntity<AppErrorResponseDTO> error(final AppErrorResponseDTO err, final int httpStatusCode) {
		return new ResponseEntity<AppErrorResponseDTO>(err,
				org.springframework.http.HttpStatus.valueOf(httpStatusCode));
	}

	private void logError(AppException e) {
		String errorMessage = StringUtils.isEmpty(e.getErrorMessage()) ? e.getError().getUserMessage()
				: e.getErrorMessage();
		System.out.println("An Exception Occurred. Please investigate:" + errorMessage.toString());
	}

}
