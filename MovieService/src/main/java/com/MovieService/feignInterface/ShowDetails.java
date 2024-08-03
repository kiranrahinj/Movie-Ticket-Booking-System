package com.MovieService.feignInterface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.MovieService.Model.Show;

@FeignClient("ShowService")
public interface ShowDetails {
	
	@GetMapping("/show/{movieName}")
	public List<Show> show(@PathVariable("movieName")String name);
}
