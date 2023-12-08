package com.hexaware.movieticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hexaware.movieticketbooking.entity.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

    Theatre findByName(String name);

    // You can add custom query methods here if needed
}