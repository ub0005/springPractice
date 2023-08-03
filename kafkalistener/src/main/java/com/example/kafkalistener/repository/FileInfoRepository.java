package com.example.kafkalistener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kafkalistener.entity.FileInfo;

public interface FileInfoRepository extends JpaRepository<FileInfo, String>{
}
