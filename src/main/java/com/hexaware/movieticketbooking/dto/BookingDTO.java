package com.hexaware.movieticketbooking.dto;

import java.util.List;

public class BookingDTO {

    private int showId;
    private int userId;
    private List<String> seatNumbers;  // Represents multiple seat numbers for a booking

    public BookingDTO() {
        // Default constructor
    }

    public BookingDTO(int showId, int userId, List<String> seatNumbers) {
        this.showId = showId;
        this.userId = userId;
        this.seatNumbers = seatNumbers;
    }

    // Getters and setters for all fields

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }
}