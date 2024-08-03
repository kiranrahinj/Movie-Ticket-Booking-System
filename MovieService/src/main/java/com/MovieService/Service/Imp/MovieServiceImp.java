package com.MovieService.Service.Imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MovieService.Model.Movie;
import com.MovieService.Repository.MovieRepository;
import com.MovieService.Service.MovieServices;

@Service
public class MovieServiceImp implements MovieServices {
	
	private MovieRepository movieRepo;
	
	
	public MovieServiceImp(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}

	@Override
	public Movie createMovie(Movie movie) {
		return movieRepo.save(movie);
	}

	@Override
	public List<Movie> getAllMovie() {
		return movieRepo.findAll();
	}

	@Override
	public Movie getMovie(String name) {
		return movieRepo.findByName(name);
	}

}
