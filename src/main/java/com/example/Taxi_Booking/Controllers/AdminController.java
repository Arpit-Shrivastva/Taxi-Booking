package com.example.Taxi_Booking.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Taxi_Booking.Services.AdminCredentialService;
import com.example.Taxi_Booking.Services.BookingFromService;
import com.example.Taxi_Booking.Services.ContactFormService;

@Controller
@RequestMapping("admin")
public class AdminController {
    private final ContactFormService contactFormService;
    private final AdminCredentialService adminCredentialService;
    private final BookingFromService bookingFromService;

    @Autowired
    public AdminController(ContactFormService contactFormService, AdminCredentialService adminCredentialService,
            BookingFromService bookingFromService) {
        this.contactFormService = contactFormService;
        this.adminCredentialService = adminCredentialService;
        this.bookingFromService = bookingFromService;
    }

    @GetMapping("dashboard")
    public String AdminDashboard() {
        return "admin/dashboard";
    }

    // get all contacts
    @GetMapping("readAllContacts")
    public String readAllContactsView(Model model) {
        model.addAttribute("allcontacts", contactFormService.getAllContacts());
        return "admin/readallcontacts";
    }

    @GetMapping("deleteContact/{id}")
    public String deleteContact(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        contactFormService.deleteContact(id);
        redirectAttributes.addFlashAttribute("message", "Contact deleted successfully");
        return "redirect:/admin/readAllContacts";
    }

    @GetMapping("changeCredential")
    public String changeCredentialsView() {
        return "admin/changecredentials";
    }

    @PostMapping("changeCredential")
    public String changeCreentials(
            @RequestParam("oldusername") String oldusername,
            @RequestParam("oldpassword") String oldpassword,
            @RequestParam("newusername") String newusername,
            @RequestParam("newpassword") String newpassword,
            RedirectAttributes attributes) {

        String result = adminCredentialService.checkAdminCredentials(oldusername, oldpassword);
        if (result.equals("Success")) {
            result = adminCredentialService.updateAdminCredentials(newusername, newpassword, oldusername);
            attributes.addFlashAttribute("message", result);
        } else {
            attributes.addFlashAttribute("message", result);
        }

        return "redirect:/admin/dashboard";
    }

    @GetMapping("readAllBookings")
    public String readAllBookingView(Model model) {
        model.addAttribute("allBookings", bookingFromService.getAllBooking());
        return "admin/readallbookings";
    }

    @GetMapping("deleteBooking/{id}")
    public String deleteContact(@PathVariable int id, RedirectAttributes redirectAttributes) {
        bookingFromService.deleteBooking(id);
        redirectAttributes.addFlashAttribute("message", "Booking deleted successfully");
        return "redirect:/admin/readAllBookings";
    }

}
