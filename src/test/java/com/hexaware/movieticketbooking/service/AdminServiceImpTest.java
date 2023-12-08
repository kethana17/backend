package com.hexaware.movieticketbooking.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hexaware.movieticketbooking.dto.AdminDTO;
import com.hexaware.movieticketbooking.entity.Admin;
import com.hexaware.movieticketbooking.exception.AdminNotFoundException;
import com.hexaware.movieticketbooking.repository.AdminRepository;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdminServiceImpTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminServiceImp adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // You can set up additional mock behaviors if needed
    }

    @Test
    void testAddAdmin() {
        // Arrange
    	 AdminDTO adminDto = new AdminDTO(1, "adminName", "adminPassword");

         // Assume that the password encoder returns a specific value
         when(passwordEncoder.encode(adminDto.getAdminPassword())).thenReturn("encodedPassword");

         // Assume that the repository saves the admin and returns it
         Admin savedAdmin = new Admin(1, "adminName", "encodedPassword");
         when(adminRepository.save(any(Admin.class))).thenReturn(savedAdmin);

         // Act
         AdminDTO result = adminService.addAdmin(adminDto);

         // Assert
         assertEquals("adminName", result.getAdminName());
         // Add more assertions if needed
         assertEquals("encodedPassword", result.getAdminPassword());
         assertEquals(1, result.getAdminId());  // Assuming your AdminDTO has an adminId property
         verify(adminRepository, times(1)).save(any(Admin.class));
     }
    

    @Test
    void testEditAdminProfile() {
        // Arrange
        AdminDTO adminDto = new AdminDTO(1, "adminName", "adminPassword");

        when(passwordEncoder.encode(adminDto.getAdminPassword())).thenReturn("encodedPassword");

        Admin savedAdmin = new Admin(1, "adminName", "encodedPassword");
        when(adminRepository.save(any(Admin.class))).thenReturn(savedAdmin);

        // Act
        AdminDTO result = adminService.editAdminProfile(adminDto);

        // Assert
        assertEquals(1, result.getAdminId());
        assertEquals("adminName", result.getAdminName());
        assertEquals("encodedPassword", result.getAdminPassword());
        verify(adminRepository, times(1)).save(any(Admin.class));
    }

    @Test
    void testDeleteAdminAccount() {
        // Arrange
        int adminId = 1;

        // Act
        adminService.deleteAdminAccount(adminId);

        // Assert
        verify(adminRepository, times(1)).deleteById(adminId);
    }

    @Test
    void testGetAdminProfileById() throws AdminNotFoundException {
        // Arrange
        int adminId = 1;
        Admin expectedAdmin = new Admin(1, "adminName", "encodedPassword");

        when(adminRepository.findById(adminId)).thenReturn(java.util.Optional.of(expectedAdmin));

        // Act
        Admin result = adminService.getAdminProfileById(adminId);

        // Assert
        assertEquals(expectedAdmin, result);
    }

    @Test
    void testViewAllAdmin() throws AdminNotFoundException {
        // Arrange
        List<Admin> expectedAdmins = new ArrayList<>();
        expectedAdmins.add(new Admin(1, "admin1", "encodedPassword1"));
        expectedAdmins.add(new Admin(2, "admin2", "encodedPassword2"));

        when(adminRepository.findAll()).thenReturn(expectedAdmins);

        // Act
        List<Admin> result = adminService.viewAllAdmin();

        // Assert
        assertEquals(expectedAdmins, result);
    }
}
