package com.MovieService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MovieService.Model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
	
	public Movie findByName(String name);
	
}
