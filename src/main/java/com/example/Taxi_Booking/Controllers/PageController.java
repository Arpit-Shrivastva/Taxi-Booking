package com.example.Taxi_Booking.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Taxi_Booking.Models.BookingForm;
import com.example.Taxi_Booking.Models.ContactForm;
import com.example.Taxi_Booking.Services.BookingFromService;
import com.example.Taxi_Booking.Services.ContactFormService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class PageController {

    private final ContactFormService contactFormService;
    private final BookingFromService bookingFromService;

    @Autowired
    public PageController(ContactFormService contactFormService, BookingFromService bookingFromService) {
        this.contactFormService = contactFormService;
        this.bookingFromService = bookingFromService;
    }

    @RequestMapping(path = { "/", "/home", "/index", "/welcome" })
    public String homeView(HttpServletRequest request, Model model) {
        System.out.println("Home Load");
        String req = request.getRequestURI();
        model.addAttribute("myCurrentPage", req);
        model.addAttribute("bookingForm", new BookingForm());
        return "index"; // index.html
    }

    @RequestMapping("/about")
    public String aboutView(HttpServletRequest request, Model model) {
        String req = request.getRequestURI();
        model.addAttribute("myCurrentPage", req);
        System.out.println("About Load");
        return "about"; // about.html
    }

    @RequestMapping("/cars")
    public String carView(HttpServletRequest request, Model model) {
        String req = request.getRequestURI();
        model.addAttribute("myCurrentPage", req);
        System.out.println("Car Load");
        return "cars"; // cars.html
    }

    @RequestMapping("/services")
    public String servicesView(HttpServletRequest request, Model model) {
        String req = request.getRequestURI();
        model.addAttribute("myCurrentPage", req);
        System.out.println("Service Load");
        return "services"; // services.html
    }

    @RequestMapping("/contacts")
    public String contactView(HttpServletRequest request, Model model) {
        String req = request.getRequestURI();
        model.addAttribute("myCurrentPage", req);
        model.addAttribute("contactForm", new ContactForm());
        System.out.println("Contact Load");
        return "contacts"; // contacts.html
    }

    @RequestMapping("/login")
    public String adminLoginView(HttpServletRequest request, Model model) {

        ServletContext servletContext = request.getServletContext();
        Object object = servletContext.getAttribute("logout");
        if (object instanceof Boolean) {
            model.addAttribute("logout", object);
            servletContext.removeAttribute("logout");
        }

        return "adminlogin";
    }


    // Contact Form
    @PostMapping("contactform")
    public String contactForm(@Valid @ModelAttribute ContactForm contactForm, BindingResult bindingResult,
            Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "contacts";
        }

        ContactForm contactForm1 = contactFormService.saveContactFrom(contactForm);
        if (contactForm1 != null) {
            redirectAttributes.addFlashAttribute("message", "Message Sent Successfully");
        } else {
            redirectAttributes.addFlashAttribute("message", "Something Went Wrong");
        }
        return "redirect:/contacts";
    }



    // Booking Form
    @PostMapping("bookingform")
    public String bookingForm(@Valid @ModelAttribute BookingForm bookingForm, BindingResult bindingResult,
            Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "index";
        } else if (bookingForm.getAdult() + bookingForm.getChildren() > 4) {
            model.addAttribute("message", "The total no of adults and childrens cannot exceed 4");
            return "index";
        }

        BookingForm bookingForm1 = bookingFromService.saveBookingForm(bookingForm);
        if (bookingForm1 != null) {
            redirectAttributes.addFlashAttribute("message", "Booking Successfully");
        } else {
            redirectAttributes.addFlashAttribute("message", "Something Went Wrong");
        }
        return "redirect:/index";
    }

}
