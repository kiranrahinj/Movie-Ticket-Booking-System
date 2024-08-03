package com.MovieService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MovieService.Model.Movie;
import com.MovieService.Service.MovieServices;
import com.MovieService.feignInterface.ShowDetails;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	private MovieServices movieServices;
	
	
	private ShowDetails showDetails;

	public MovieController(MovieServices movieServices,ShowDetails showDetails) {
		this.movieServices = movieServices;
		this.showDetails=showDetails;
	}
	
	@PostMapping
	public ResponseEntity<Movie>createMovie(@RequestBody Movie movie){
		return ResponseEntity.ok(movieServices.createMovie(movie));
	} 
	
	@GetMapping
	public ResponseEntity<List<Movie>>getAll(){
		return ResponseEntity.ok(movieServices.getAllMovie());
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Movie>getMovie(@PathVariable("name")String name){
		Movie movie=movieServices.getMovie(name);
		movie.setShows(showDetails.show(name));
		
		return ResponseEntity.ok(movie);
	}
	
	
}
