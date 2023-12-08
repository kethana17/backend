package com.hexaware.movieticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.movieticketbooking.dto.BookingDTO;
import com.hexaware.movieticketbooking.service.IBookingService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/bookings")
public class BookingRestController {

    @Autowired
    private IBookingService bookingService;

    @PostMapping
    public ResponseEntity<Void> bookSeat(@RequestBody BookingDTO bookingDTO) {
        bookingService.bookSeat(bookingDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Other methods for updating bookings, retrieving bookings by ID, etc.
}