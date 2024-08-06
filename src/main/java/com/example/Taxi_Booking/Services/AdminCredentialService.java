package com.example.Taxi_Booking.Services;



public interface AdminCredentialService {
    public String checkAdminCredentials(String oldusername, String oldpassword);
    public String updateAdminCredentials(String newusername, String newpassword, String oldusername);
}
