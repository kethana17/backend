package com.hexaware.movieticketbooking.repository;

import com.hexaware.movieticketbooking.entity.Booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByShowId(int showId);
}
