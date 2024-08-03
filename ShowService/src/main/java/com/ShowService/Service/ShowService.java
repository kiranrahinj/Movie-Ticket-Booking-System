package com.ShowService.Service;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ShowService.Model.Show;

@Service
public interface ShowService {
	
	public Show createShow(Show show);
	
	public Show getShow(int id);

	public Show getShowByMovieNameAndShowName(String movieName,String showName);
	
	public List<Show> findByMovieName(String name); 
	
	public List<Show>getAllShow();

	public String deleteSeats();
	

}
