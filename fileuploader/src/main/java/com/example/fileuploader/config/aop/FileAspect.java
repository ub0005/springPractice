package com.example.fileuploader.config.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FileAspect {
	
	Logger logger = LoggerFactory.getLogger(FileAspect.class);
	
	@Before(value = "execution(* com.example.fileuploader.controller.FileController.*(..))")
	public void beforeAdvice(JoinPoint jointPoint) {
		
		logger.info("Request to " + jointPoint.getSignature() + "started at "+ new Date());
	}
	
	@After(value = "execution(* com.example.fileuploader.controller.FileController.*(..))")
	public void afterAdvice(JoinPoint jointPoint) {
		
		logger.info("Request to " + jointPoint.getSignature() + " ended at "+ new Date());
	}
	
	@Before(value = "execution(* com.example.fileuploader.service.impl.FileServiceImpl.*(..))")
	public void beforeAdviceForService(JoinPoint jointPoint) {
		
		logger.info("Request to " + jointPoint.getSignature() + "started at "+ new Date());
	}
	
	@After(value = "execution(* com.example.fileuploader.service.impl.FileServiceImpl.*(..))")
	public void afterAdviceForServices(JoinPoint jointPoint) {
		
		logger.info("Request to " + jointPoint.getSignature() + " ended at "+ new Date());
	}

}
