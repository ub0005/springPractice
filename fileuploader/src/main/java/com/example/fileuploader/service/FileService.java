package com.example.fileuploader.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.fileuploader.entity.FileInfo;

public interface FileService {
	
	public FileInfo uploadFile(MultipartFile file);
	
}
