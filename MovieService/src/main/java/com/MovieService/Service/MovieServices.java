package com.MovieService.Service;

import java.util.List;

import com.MovieService.Model.Movie;

public interface MovieServices {
	
	public Movie createMovie(Movie movie);
	
	public List<Movie>getAllMovie();
	
	public Movie getMovie(String name);
	
	
}
