package com.example.fileuploader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fileuploader.entity.FileInfo;

@Repository
public interface FileRepository extends JpaRepository<FileInfo, String>, CustomFileRepository {

}
