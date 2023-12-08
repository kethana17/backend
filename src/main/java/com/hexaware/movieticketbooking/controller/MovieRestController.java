package com.hexaware.movieticketbooking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.movieticketbooking.dto.MovieDTO;
import com.hexaware.movieticketbooking.service.IMovieService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    @Autowired
    private IMovieService movieService;

    // Add a new movie
    @PostMapping("/addMovie")
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO) {

        MovieDTO createdMovie = movieService.addMovie(movieDTO);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    // Get all movies
    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // Remove a movie by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeMovie(@PathVariable int id) {
        movieService.removeMovie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // Remove a movie by name
    @DeleteMapping("/removeByName/{name}")
    public ResponseEntity<Void> removeMovieByName(@PathVariable String name) {
        movieService.removeMovieByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}