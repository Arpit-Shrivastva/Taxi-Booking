package com.example.Taxi_Booking.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Taxi_Booking.Models.Admin;
import com.example.Taxi_Booking.Repository.AdminRepository;

@Service
public class AdminCredentialServiceImpl implements AdminCredentialService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminCredentialServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String checkAdminCredentials(String oldusername, String oldpassword) {
        Optional<Admin> byUserName = adminRepository.findByUsername(oldusername);

        if (byUserName.isPresent()) {
            Admin admin = byUserName.get();
            Boolean matches = passwordEncoder.matches(oldpassword, admin.getPassword());

            if (matches) {
                return "Success";
            } else {
                return "wrong old credentials";
            }
        } else {
            return "wrong old credentials";
        }
    }

    @Override
    public String updateAdminCredentials(String newusername, String newpassword, String oldusername) {
       
        int updateCre = adminRepository.updateCredentials(newusername, passwordEncoder.encode(newpassword), oldusername);
       
        if (updateCre == 1) {
            return "Credentials Updated Succesfully";
        }else{
            return "Failed to Update";
        }
    }

}
