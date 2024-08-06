package com.example.Taxi_Booking.Services;

import java.util.List;

import com.example.Taxi_Booking.Models.ContactForm;

public interface ContactFormService {

    public ContactForm saveContactFrom(ContactForm contactForm);
    public List<ContactForm> getAllContacts();
    public void deleteContact(Long id);

}
