package com.example.fileuploader.repository;

import com.example.fileuploader.entity.FileInfo;

public interface CustomFileRepository {
	
	FileInfo customFindMethod(String id);

}
