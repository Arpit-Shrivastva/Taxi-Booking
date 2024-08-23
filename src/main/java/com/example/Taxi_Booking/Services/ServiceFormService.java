package com.example.Taxi_Booking.Services;

import org.springframework.web.multipart.MultipartFile;

import com.example.Taxi_Booking.Models.ServiceForm;

public interface ServiceFormService {

    public ServiceForm addService(ServiceForm serviceForm, MultipartFile multipartFile);

}
