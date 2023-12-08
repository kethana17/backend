package com.hexaware.movieticketbooking.service;

import java.util.List;
import com.hexaware.movieticketbooking.dto.AdminDTO;
import com.hexaware.movieticketbooking.entity.Admin;
import com.hexaware.movieticketbooking.exception.AdminNotFoundException;

public interface IAdminService {

	List<Admin> viewAllAdmin() throws AdminNotFoundException;

	Admin getAdminProfileById(int adminId) throws AdminNotFoundException;

	void deleteAdminAccount(int adminId);

	AdminDTO editAdminProfile(AdminDTO adminDto);

	AdminDTO addAdmin(AdminDTO adminDto);
	

}
