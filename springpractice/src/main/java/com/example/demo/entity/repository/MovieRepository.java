package com.example.demo.entity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{
	
	List<Movie> findAll();

}
