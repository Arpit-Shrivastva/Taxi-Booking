package com.example.Taxi_Booking.Models;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "bookingForm")
public class BookingForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name cant be empty")
    @NotBlank(message = "Name cant be blank")
    @Size(min = 2, max = 30, message = "Invalid name length")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name must contains only alphabet")
    @Column(length = 30)
    private String name;

    @NotNull(message = "Phone Number Cant be empty")
    @Min(value = 1000000000, message = "Phone Number must be at least 10 digit")
    @Max(value = 9999999999L, message = "Phone Number must be at least 10 digit")
    @Column(length = 10)
    private Long phone;

    @NotEmpty(message = "Source cant be empty")
    @NotBlank(message = "Source cant be blank")
    @Size(min = 2, max = 50, message = "Invalid source length")
    @Column(length = 50)
    private String source;

    @NotEmpty(message = "Destination cant be empty")
    @NotBlank(message = "Destination cant be blank")
    @Size(min = 2, max = 50, message = "Invalid destinaion length")
    @Column(length = 50)
    private String destination;

    @NotEmpty(message = "Email cant be empty")
    @NotBlank(message = "Email cant be blank")
    @Size(min = 2, max = 50, message = "Invalid email length")
    @Column(length = 20)
    private String email;

    @NotNull(message = "Time cant be empty")
    private LocalTime time;

    @NotNull(message = "Date cant be empty")
    private LocalDate date;

    @NotEmpty(message = "Comfort cant be empty")
    @Size(min = 2, max = 20, message = "Invalid comfort length")
    @Column(length = 20)
    private String comfort;

    @Min(value = 1, message = "Adult can be at least 1")
    @Max(value = 4, message = "Adult can be at most 4")
    private int adult;

    @Max(value = 3, message = "Children can be at most 3")
    private int children;

    @NotEmpty(message = "Message cant be empty")
    @NotBlank(message = "Message cant be blank")
    @Size(min = 2, max = 500, message = "Invalid message length")
    @Column(length = 500)
    private String message;

}
