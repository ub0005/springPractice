package com.example.kafkalistener.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "file_info")
public class FileInfo {

	public FileInfo() {
		super();
	}
	@Id
    @Column(name = "id")
    private String id;

	@Column(name = "filename")
	private String fileName;

	@Column(name = "filedescription")
	private String fileDescription;

	@Column(name = "status")
	private String status;

	@Column(name = "originalfilesize")
	private long originalFileSize;
	
	@Column(name = "compressedfilesize")
	private long compressedFileSize;

	@Column(name = "contenttype")
	private String contentType;
	
	@CreationTimestamp
	@Column(name = "created_at")
    private Instant createdAt;
	
	
	@UpdateTimestamp
	@Column(name= "updated_at")
    private Instant lastUpdatedOn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDescription() {
		return fileDescription;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getOriginalFileSize() {
		return originalFileSize;
	}

	public void setOriginalFileSize(long originalFileSize) {
		this.originalFileSize = originalFileSize;
	}

	public long getCompressedFileSize() {
		return compressedFileSize;
	}

	public void setCompressedFileSize(long compressedFileSize) {
		this.compressedFileSize = compressedFileSize;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Instant lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
}
