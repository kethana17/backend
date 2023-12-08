package com.hexaware.movieticketbooking.service;

import java.util.List;
import com.hexaware.movieticketbooking.dto.TheatreDTO;

public interface ITheatreService {

	 TheatreDTO addTheatre(TheatreDTO theatreDTO);

	    List<TheatreDTO> getAllTheatres();

	    void removeTheatreById(int id);

	    void removeTheatreByName(String name);
}