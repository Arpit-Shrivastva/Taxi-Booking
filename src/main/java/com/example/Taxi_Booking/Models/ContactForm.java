package com.example.Taxi_Booking.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ContactForm")
public class ContactForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name Cannot be empty")
    @Size(min = 2, max = 30, message = "Invalid Name Size")
    @Column(length = 30)
    private String name;

    @NotEmpty(message = "Email Cannot be empty")
    @Size(min = 5, max = 50, message = "Invalid Email Size")
    @Column(length = 50)
    private String email;

    @NotNull(message = "Phone Number Cant be empty")
    @Min(value = 1000000000, message = "Phone Number must be at least 10 digit")
    @Max(value = 9999999999L, message = "Phone Number must be at least 10 digit")
    @Column(length = 10)
    private Long phone;

    @NotEmpty(message = "Message Cannot be empty")
    @Size(min = 5, max = 300, message = "Invalid Message Size")
    @Column(length = 300)
    private String message;
}
