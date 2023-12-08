package com.hexaware.movieticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.movieticketbooking.dto.BookingDTO;
import com.hexaware.movieticketbooking.entity.Booking;
import com.hexaware.movieticketbooking.entity.Show;
import com.hexaware.movieticketbooking.entity.User;
import com.hexaware.movieticketbooking.repository.BookingRepository;
import com.hexaware.movieticketbooking.repository.ShowRepository;
import com.hexaware.movieticketbooking.repository.UserRepository;

@Service
public class BookingServiceImp implements IBookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;  // Autowire UserRepository

    @Override
    public void bookSeat(BookingDTO bookingDTO) {
        // Fetch the Show entity by ID from the repository
        Show show = showRepository.findById(bookingDTO.getShowId())
                .orElseThrow(() -> new RuntimeException("Show not found"));

        // Fetch the User entity by ID from the repository
        User user = userRepository.findById(bookingDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the seats are available (you can implement your own logic here)

        // Convert the list of seat numbers to a comma-separated string
        String seatNumbers = String.join(",", bookingDTO.getSeatNumbers());

        // Create a new Booking entity with the comma-separated string of seat numbers
        Booking booking = new Booking();
        booking.setShow(show);
        booking.setUser(user);
        booking.setSeatNumbers(seatNumbers);

        // Save the booking entity to the database
        bookingRepository.save(booking);
    }
    

    // Implement other methods for updating and retrieving bookings
}