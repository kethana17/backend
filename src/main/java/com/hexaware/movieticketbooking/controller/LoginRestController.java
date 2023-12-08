package com.hexaware.movieticketbooking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.movieticketbooking.dto.AuthRequest;
import com.hexaware.movieticketbooking.service.IUserService;
import com.hexaware.movieticketbooking.service.JwtService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/login")
public class LoginRestController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	Logger logger = LoggerFactory.getLogger(LoginRestController.class);

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/adminlogin")
	public String adminLogin(@RequestBody AuthRequest authRequest) {
        logger.info("Received request for admin login for username: {}", authRequest.getUsername());

		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		String token = null;
		
		if (authenticate.isAuthenticated()) {

			token = jwtService.generateToken(authRequest.getUsername());
            logger.info("Admin login successful for username: {}", authRequest.getUsername());

		}

		else {
            logger.warn("Invalid admin login request for username: {}", authRequest.getUsername());

			throw  new UsernameNotFoundException("Invalid Username or Password / Invalid request");
		}
        logger.info("Generated token: {}", token);
		return token;
	}
	
	@PostMapping("/userlogin")
	public String userLogin(@RequestBody AuthRequest authRequest) {
        logger.info("Received request for user login for username: {}", authRequest.getUsername());

		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		String token = null;
		
		if (authenticate.isAuthenticated()) {

			token = jwtService.generateToken(authRequest.getUsername());
            logger.info("User login successful for username: {}", authRequest.getUsername());

		}

		else {
            logger.warn("Invalid user login request for username: {}", authRequest.getUsername());

			throw  new UsernameNotFoundException("Invalid Username or Password / Invalid request");
		}
        logger.debug("Generated token: {}", token);
		return token;
	}
}
