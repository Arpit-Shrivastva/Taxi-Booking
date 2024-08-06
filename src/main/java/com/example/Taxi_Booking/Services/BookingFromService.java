package com.example.Taxi_Booking.Services;

import java.util.List;

import com.example.Taxi_Booking.Models.BookingForm;

public interface BookingFromService {

    public BookingForm saveBookingForm(BookingForm bookingForm);
    public List<BookingForm> getAllBooking();
    public void deleteBooking(int id);

}
