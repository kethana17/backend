package com.hexaware.movieticketbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AdminNotFoundException extends ResponseStatusException{
	
	public AdminNotFoundException(HttpStatus status,String msg) {
		super(status,msg); }

}
