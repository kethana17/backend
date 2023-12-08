package com.hexaware.movieticketbooking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.movieticketbooking.dto.ShowDTO;
import com.hexaware.movieticketbooking.entity.Movie;
import com.hexaware.movieticketbooking.entity.Show;
import com.hexaware.movieticketbooking.entity.Theatre;
import com.hexaware.movieticketbooking.repository.MovieRepository;
import com.hexaware.movieticketbooking.repository.ShowRepository;
import com.hexaware.movieticketbooking.repository.TheatreRepository;


@Service
public class ShowServiceImp implements IShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public ShowDTO addShow(ShowDTO showDTO) {
        Show newShow = convertToEntity(showDTO);
        Show savedShow = showRepository.save(newShow);
        return convertToDTO(savedShow);
    }

    @Override
    public List<ShowDTO> getAllShows() {
        return showRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void removeShowById(int id) {
        showRepository.deleteById(id);
    }

    // Other methods for updating shows, retrieving shows by name, etc.

    private ShowDTO convertToDTO(Show show) {
        ShowDTO showDTO = new ShowDTO();
        showDTO.setId(show.getId());
        showDTO.setShowName(show.getShowName());
        showDTO.setShowDateTime(show.getShowDateTime());
        showDTO.setTheatreName(show.getTheatre().getName());
        showDTO.setMovieName(show.getMovie().getTitle());
        return showDTO;
    }

    private Show convertToEntity(ShowDTO showDTO) {
        Show show = new Show();
        show.setShowName(showDTO.getShowName());
        show.setShowDateTime(showDTO.getShowDateTime());

        // Fetch Theatre and Movie entities by name from their repositories
        Theatre theatre = theatreRepository.findByName(showDTO.getTheatreName());
        Movie movie = movieRepository.findByTitle(showDTO.getMovieName());

        show.setTheatre(theatre);
        show.setMovie(movie);
        return show;
    }
}