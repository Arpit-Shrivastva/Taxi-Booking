package com.example.Taxi_Booking.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Taxi_Booking.Models.ContactForm;
import com.example.Taxi_Booking.Repository.ContactFromRepository;

@Service
public class ContactFromServiceImpl implements ContactFormService {

    private final ContactFromRepository contactFromRepository;

    @Autowired
    public ContactFromServiceImpl(ContactFromRepository contactFromRepository) {
        this.contactFromRepository = contactFromRepository;
    }

    @Override
    public ContactForm saveContactFrom(ContactForm contactForm) {
        return contactFromRepository.save(contactForm);
    }

    @Override
    public List<ContactForm> getAllContacts() {
        return contactFromRepository.findAll();
    }

    @Override
    public void deleteContact(Long id) {
        contactFromRepository.deleteById(id);
    }

}
