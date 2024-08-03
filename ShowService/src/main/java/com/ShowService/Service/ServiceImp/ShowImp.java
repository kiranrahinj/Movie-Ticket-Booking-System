package com.ShowService.Service.ServiceImp;

import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ShowService.Model.Show;
import com.ShowService.Repository.ShowRepository;
import com.ShowService.Service.ShowService;

@Service
public class ShowImp implements ShowService {

	private ShowRepository showRepo;

	public ShowImp(ShowRepository showRepo) {
		this.showRepo = showRepo;
	}

	@Override
	public Show getShow(int id) {
		return showRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("This Show is not present please create it"));
	}

	@Override
	public Show getShowByMovieNameAndShowName(String movieName, String showName) {
		return showRepo.findShowByMovieNameAndShowName(movieName,showName);
	}


	@Override
	public Show createShow(Show show) {
		return showRepo.save(show);
	}

	@Override
	public List<Show> getAllShow() {
		return showRepo.findAll();
	}

	@Override
	@Scheduled(cron="0 18 1 * * ?")
	public String deleteSeats() {
		int showCount=getAllShow().size();
		boolean flag=false;
		for(int i=1;i<showCount;i++){
			Show show=getShow(i);
			boolean []seats=new boolean[20];
			show.setSeats(seats);
			createShow(show);
			flag=true;
		}
		return flag==true ? "Seates are renew" : "No shows are there to renew shows";
	}

	@Override
	public List<Show> findByMovieName(String name) {
		return showRepo.findByMovieName(name);
	}



}
