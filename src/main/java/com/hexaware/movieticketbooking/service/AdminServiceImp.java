package com.hexaware.movieticketbooking.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hexaware.movieticketbooking.dto.AdminDTO;
import com.hexaware.movieticketbooking.entity.Admin;
import com.hexaware.movieticketbooking.exception.AdminNotFoundException;
import com.hexaware.movieticketbooking.repository.AdminRepository;



@Service
public class AdminServiceImp implements IAdminService {
     private PasswordEncoder passwordEncoder;
	 private AdminRepository adminRepository;
	public AdminServiceImp(PasswordEncoder passwordEncoder, AdminRepository adminRepository) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.adminRepository = adminRepository;
	}
	Logger logger = LoggerFactory.getLogger(AdminServiceImp.class);
	@Override
	public AdminDTO addAdmin(AdminDTO adminDto) {

		Admin admin=new Admin();
		
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminPassword(passwordEncoder.encode(adminDto.getAdminPassword()));
		
		Admin adminTemp=adminRepository.save(admin);
		logger.info("Admin Service Implementation -added Admin data into database successfully ");
		return new AdminDTO(adminTemp.getAdminId(),adminTemp.getAdminName(),adminTemp.getAdminPassword());
	}

	@Override
	public AdminDTO editAdminProfile(AdminDTO adminDto) {
		Admin admin=new Admin();
		admin.setAdminId(adminDto.getAdminId());
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminPassword(passwordEncoder.encode(adminDto.getAdminPassword()));
		
		Admin adminTemp=adminRepository.save(admin);
		logger.info("Admin Service Implementation -Updated the Admin data in existing record in  database successfully ");
		return new AdminDTO(adminTemp.getAdminId(),adminTemp.getAdminName(),adminTemp.getAdminPassword());
	}

	@Override
	public void deleteAdminAccount(int adminId) {
		logger.info("Admin Data with ID :{} deleted successfully in the Admin Service Implementation ",adminId);
		adminRepository.deleteById(adminId);
	}

	@Override
	public Admin getAdminProfileById(int adminId) throws AdminNotFoundException {
		logger.info("Admin Service Implementation-Fetching admin with ID :{}",adminId);
		return adminRepository.findById(adminId).orElse(new Admin());
		
	}

	@Override
	public List<Admin> viewAllAdmin() throws AdminNotFoundException {
		logger.info("Admin Service Implementation- Fetching all admins ");
		return adminRepository.findAll();
	}
	
}