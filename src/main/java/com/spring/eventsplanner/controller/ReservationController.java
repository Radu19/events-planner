package com.spring.eventsplanner.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.eventsplanner.model.Customer;
import com.spring.eventsplanner.model.Location;
import com.spring.eventsplanner.model.Reservation;
import com.spring.eventsplanner.model.User;
import com.spring.eventsplanner.service.CustomerService;
import com.spring.eventsplanner.service.LocationService;
import com.spring.eventsplanner.service.ReservationService;
import com.spring.eventsplanner.service.UserService;


@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LocationService locationService;

	@GetMapping("/list")
	public String showReservationList(Model theModel) {
		
		List<Reservation> reservations = reservationService.findAll();
		theModel.addAttribute("reservations", reservations);
		
		return "/reservations/reservations-list";
	}
	
	@GetMapping("/add")
	public String addReservation(@RequestParam("locationId") int locationId, Model theModel) {
		
		Reservation theReservation = new Reservation();
		
		Location theLocation = locationService.findById(locationId);
		theModel.addAttribute("location", theLocation);
		
		String[] ceremonyTypes = theLocation.getCeremonyTypes().split(",");
		theModel.addAttribute("ceremonyTypes", ceremonyTypes);
		
		String[] cuisine = theLocation.getCuisine().split(",");
		theModel.addAttribute("cuisines", cuisine);
		
		String[] paymentMethods = theLocation.getPaymentMethod().split(",");
		theModel.addAttribute("paymentMethods", paymentMethods);
		
		List<Customer> customers = customerService.findAll();
		theModel.addAttribute("customers", customers);
		
		LocalDate reservationDate = LocalDate.now().plusMonths(1);
		theReservation.setReservationDate(reservationDate);
		
		theReservation.setLocation(theLocation);
		theModel.addAttribute("reservation", theReservation);
		
		return "/reservations/reservation-form";
	}
	
	@PostMapping("/save")
	public String saveReservation(@ModelAttribute("reservation") Reservation theReservation) {
		
		User organizer = userService.findById((long)3);
		theReservation.setUser(organizer);
		theReservation.setPaymentStatus("Pending");
		
		reservationService.save(theReservation);
		
		return "redirect:/reservation/list";
	}
	
	@GetMapping("/delete")
	public String deleteReservation(@RequestParam("reservationId") int theId) {
		
		reservationService.deleteById(theId);
		
		return "redirect:/reservation/list";
	}
	
	@GetMapping("/update")
	public String updateReservation(@RequestParam("reservationId") int theId, Model theModel) {
		
		Reservation theReservation = reservationService.findById(theId);
		theModel.addAttribute("reservation", theReservation);
		
		return "/reservations/reservation-form";
	}
	
}
