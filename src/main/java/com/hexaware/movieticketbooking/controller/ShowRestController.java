package com.hexaware.movieticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.movieticketbooking.dto.ShowDTO;
import com.hexaware.movieticketbooking.service.ShowServiceImp;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowRestController {

   @Autowired
   ShowServiceImp showService;

    @PostMapping
    public ResponseEntity<ShowDTO> addShow(@RequestBody ShowDTO showDTO) {
        ShowDTO addedShow = showService.addShow(showDTO);
        return new ResponseEntity<>(addedShow, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ShowDTO>> getAllShows() {
        List<ShowDTO> shows = showService.getAllShows();
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeShowById(@PathVariable int id) {
        showService.removeShowById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Other methods for updating shows, retrieving shows by ID, etc.
}