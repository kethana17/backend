package com.hexaware.movieticketbooking.service;

import java.util.List;
import com.hexaware.movieticketbooking.dto.ShowDTO;

public interface IShowService {
	 ShowDTO addShow(ShowDTO showDTO);

	    List<ShowDTO> getAllShows();

	    void removeShowById(int id);
}