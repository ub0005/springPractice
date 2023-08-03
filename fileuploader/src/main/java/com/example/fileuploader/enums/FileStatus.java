package com.example.fileuploader.enums;

public enum FileStatus {
	
	UPLOADED("uploaded"),
	FAILED("failed"),
	DELETED("deleted");
	
	private String status;

	FileStatus(String status) {
        this.status = status;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
