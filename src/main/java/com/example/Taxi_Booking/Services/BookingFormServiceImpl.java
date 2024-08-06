package com.example.Taxi_Booking.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Taxi_Booking.Models.BookingForm;
import com.example.Taxi_Booking.Repository.BookingFormRepository;

@Service
public class BookingFormServiceImpl implements BookingFromService {

    private final BookingFormRepository bookingFormRepository;

    @Autowired
    public BookingFormServiceImpl(BookingFormRepository bookingFormRepository) {
        this.bookingFormRepository = bookingFormRepository;
    }

    @Override
    public BookingForm saveBookingForm(BookingForm bookingForm) {
        return bookingFormRepository.save(bookingForm);
    }

    @Override
    public List<BookingForm> getAllBooking() {
        return bookingFormRepository.findAll();
    }

    @Override
    public void deleteBooking(int id) {
        bookingFormRepository.deleteById(id);
    }

}
