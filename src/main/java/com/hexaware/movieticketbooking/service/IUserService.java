package com.hexaware.movieticketbooking.service;

import com.hexaware.movieticketbooking.dto.UserDTO;

public interface IUserService {
	 UserDTO createUser(UserDTO userDTO);

	    UserDTO getUserById(int userId);
}