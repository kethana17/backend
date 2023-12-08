package com.hexaware.movieticketbooking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hexaware.movieticketbooking.entity.User;
import com.hexaware.movieticketbooking.dto.UserDTO;
import com.hexaware.movieticketbooking.repository.UserRepository;

@Service
public class UserServiceImp implements IUserService {
	
	private  PasswordEncoder passwordEncoder;	

    @Autowired
    private UserRepository userRepository;
    
    public UserServiceImp(PasswordEncoder passwordEncoder, UserRepository userRepository) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;

	}
	 private final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

	 @Override
	    public UserDTO createUser(UserDTO userDTO) {
	        User newUser = new User();
	        newUser.setUsername(userDTO.getUsername());
	        newUser.setEmail(userDTO.getEmail());
	        newUser.setPassword(userDTO.getPassword());

	        User savedUser = userRepository.save(newUser);

	        return new UserDTO( savedUser.getUsername(), savedUser.getEmail(),savedUser.getPassword());
	    }

	    @Override
	    public UserDTO getUserById(int userId) {
	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        return new UserDTO( user.getUsername(), user.getEmail(),user.getPassword());
	    }

  
}