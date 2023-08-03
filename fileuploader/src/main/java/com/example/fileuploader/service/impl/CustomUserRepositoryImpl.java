package com.example.fileuploader.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.fileuploader.entity.FileInfo;
import com.example.fileuploader.repository.CustomFileRepository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class CustomUserRepositoryImpl implements CustomFileRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public FileInfo customFindMethod(String id) {
		return (FileInfo) entityManager.createQuery("FROM file_info u WHERE u.id = :id").setParameter("id", id)
				.getSingleResult();
	}
	
	@PostConstruct
    public void postConstruct() {
        Objects.requireNonNull(entityManager);
    }
}
