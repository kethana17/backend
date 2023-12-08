package com.hexaware.movieticketbooking.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hexaware.movieticketbooking.entity.Admin;
import com.hexaware.movieticketbooking.entity.User;
import com.hexaware.movieticketbooking.repository.AdminRepository;
import com.hexaware.movieticketbooking.repository.UserRepository;

/*
 * author:Kethana,
 * lastmodified:19/11/23,
 * Description:Service class for UserInfoUserDetailsService
 * 
*/ 

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    
	@Autowired 
	AdminRepository adminRepository;
	@Autowired 
	UserRepository userRepository;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Admin> adminInfo = adminRepository.findByAdminName(username);

	    if (adminInfo.isPresent()) {
	        return adminInfo.map(AdminInfoUserDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("Admin not found: " + username));
	    }
	    else {
	        Optional<User> userInfo = userRepository.findByUsername(username);

	        if (userInfo.isPresent()) {
	            return userInfo.map(UserInfoUserDetails::new)
	                    .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
	        } 
	        else {
	                throw new UsernameNotFoundException("User not found: " + username);
	            }
	        }
	    }
	}