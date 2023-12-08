package com.hexaware.movieticketbooking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hexaware.movieticketbooking.dto.MovieDTO;
import com.hexaware.movieticketbooking.entity.Movie;
import com.hexaware.movieticketbooking.repository.MovieRepository;

public class MovieServiceImpTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImp movieService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddMovie() {
        // Mock data
        MovieDTO movieDTO = new MovieDTO("Inception", "Sci-Fi", "Christopher Nolan", 150, 9.0);
        Movie savedMovie = new Movie("Inception", "Sci-Fi", "Christopher Nolan", 150, 9.0);

        // Mock repository behavior
        when(movieRepository.save(any())).thenReturn(savedMovie);

        // Perform the service method
        MovieDTO result = movieService.addMovie(movieDTO);

        // Verify repository method was called
        verify(movieRepository, times(1)).save(any());

        // Verify the result
        assertEquals(savedMovie.getTitle(), result.getTitle());
        assertEquals(savedMovie.getGenre(), result.getGenre());
        assertEquals(savedMovie.getDirector(), result.getDirector());
        assertEquals(savedMovie.getDuration(), result.getDuration());
        assertEquals(savedMovie.getRating(), result.getRating());
    }

    @Test
    public void testGetAllMovies() {
        // Mock data
        Movie movie1 = new Movie("Inception", "Sci-Fi", "Christopher Nolan", 150, 9.0);
        Movie movie2 = new Movie("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 8.6);
        List<Movie> movies = Arrays.asList(movie1, movie2);

        // Mock repository behavior
        when(movieRepository.findAll()).thenReturn(movies);

        // Perform the service method
        List<MovieDTO> result = movieService.getAllMovies();

        // Verify repository method was called
        verify(movieRepository, times(1)).findAll();

        // Verify the result
        assertEquals(movies.size(), result.size());
        // You can add more assertions based on your specific requirements
    }

    @Test
    public void testRemoveMovie() {
        // Mock data
        int movieIdToRemove = 1;

        // Perform the service method
        movieService.removeMovie(movieIdToRemove);

        // Verify repository method was called
        verify(movieRepository, times(1)).deleteById(movieIdToRemove);
    }

    
}
