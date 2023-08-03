package com.example.fileuploader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class FileuploaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileuploaderApplication.class, args);
	}

}
