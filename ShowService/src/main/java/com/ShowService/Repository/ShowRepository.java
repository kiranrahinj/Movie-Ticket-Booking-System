package com.ShowService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ShowService.Model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShowRepository extends JpaRepository<Show,Integer> {
	
	public List<Show> findByMovieName(String name);

	@Query("SELECT s FROM Show s WHERE s.movieName = :movieName AND s.name = :showName")
	public Show findShowByMovieNameAndShowName(@Param("movieName") String movieName, @Param("showName") String showName);


}
