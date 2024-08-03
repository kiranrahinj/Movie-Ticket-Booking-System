package com.ShowService.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ShowService.Service.ServiceImp.ShowImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShowService.Model.Show;
import com.ShowService.Service.ShowService;

@RestController
@RequestMapping("/show")
public class ShowController {
	@Autowired
	private ShowService showImp;

	@PostMapping
	public ResponseEntity<Show>createShow(@RequestBody Show show){
		return ResponseEntity.status(HttpStatus.CREATED).body(showImp.createShow(show));
	}
	
	@GetMapping("/getShow/{id}")
	public ResponseEntity<Show>getShow(@PathVariable("id") int id){
		return ResponseEntity.status(HttpStatus.CREATED).body(showImp.getShow(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Show>>createShow(){
		return ResponseEntity.status(HttpStatus.OK).body(showImp.getAllShow());
	}
	
	@GetMapping("/{movieName}")
	public ResponseEntity<List<Show>>createShow(@PathVariable("movieName")String name){
		return ResponseEntity.status(HttpStatus.OK).body(showImp.findByMovieName(name));
	}
	
	@GetMapping("/availableSeat/{movieName}/{show}")
	public ResponseEntity<Map<Integer,String>>availabeSeats(@PathVariable("movieName")String movieName,@PathVariable("show")String showName){
		Show show=showImp.getShowByMovieNameAndShowName(movieName,showName);
		
		Map<Integer,String>ans=new HashMap<>();
		boolean []seats=show.getSeats();
		
		for(int i=0;i<seats.length;i++) {
			if(seats[i]==false)ans.put(i+1,"Available");
			else ans.put(i+1,"Not available");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ans);
	}
	
	
	@PutMapping("/book/{movieName}/{show}/{id}")
	public ResponseEntity<String> bookSeat(@PathVariable("movieName")String movieName,@PathVariable("id")int seatNum,@PathVariable("show")String showName){
		Show show=showImp.getShowByMovieNameAndShowName(movieName,showName);

		boolean []seats=show.getSeats();
		if(seats[seatNum-1]==true) return ResponseEntity.ok("Seat is already booked");
		seats[seatNum-1]=true;

		showImp.createShow(show);
		return ResponseEntity.ok("Seat Number "+String.valueOf(seatNum)+" is booked Successfully");
	}

	
}
