package com.example.Taxi_Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Taxi_Booking.Models.BookingForm;


@Repository
public interface BookingFormRepository extends JpaRepository<BookingForm, Integer>{

}
