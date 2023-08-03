package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Movie;

public interface MovieService {
	
	public List<Movie> getMovies();
	public Movie addMovie(Movie movie);

}
