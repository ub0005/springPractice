package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Movie;
import com.example.demo.service.MovieService;

@RestController
@RequestMapping(value = "movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	
	@GetMapping
	public List<Movie> getMovies() {
		return movieService.getMovies();
	}
	
	@PostMapping
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}

}
