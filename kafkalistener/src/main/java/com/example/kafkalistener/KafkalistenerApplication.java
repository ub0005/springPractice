package com.example.kafkalistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class KafkalistenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkalistenerApplication.class, args);
	}

}
