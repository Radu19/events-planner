package com.spring.eventsplanner.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.eventsplanner.model.Contact;
import com.spring.eventsplanner.model.Customer;
import com.spring.eventsplanner.model.InfoRequest;
import com.spring.eventsplanner.model.Location;
import com.spring.eventsplanner.model.Meeting;
import com.spring.eventsplanner.model.Reservation;
import com.spring.eventsplanner.service.ContactService;
import com.spring.eventsplanner.service.CustomerService;
import com.spring.eventsplanner.service.InfoRequestService;
import com.spring.eventsplanner.service.LocationService;
import com.spring.eventsplanner.service.MeetingService;
import com.spring.eventsplanner.service.ReservationService;

@Controller
public class BaseController {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private InfoRequestService infoRequestService;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private MeetingService meetingService;
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String showIndex(Model theModel) {
		
		//set date for contact
		LocalDate eventDate = LocalDate.now().plusMonths(1);
		Contact contact = new Contact();
		contact.setEventDate(eventDate);
		theModel.addAttribute("contact", contact);
		return "index";
	}

	@GetMapping("/administration-dashboard")
	public String showHome(Model theModel) {
		
		List<Meeting> meetings = meetingService.findAll();
		List<Location> locations = locationService.findAll();
		List<Contact> contacts = contactService.findAll();
		List<Reservation> reservations = reservationService.findAll();
		List<InfoRequest> infoRequests = infoRequestService.findAll();
		List<Customer> customers = customerService.findAll();
		
		theModel.addAttribute("meetings", meetings.size());
		theModel.addAttribute("locations", locations.size());
		theModel.addAttribute("contacts", contacts.size());
		theModel.addAttribute("reservations", reservations.size());
		theModel.addAttribute("infoRequests", infoRequests.size());
		theModel.addAttribute("customers", customers.size());
				
		return "administration-page";
	}

	@GetMapping("/thank-you")
	public String thankYouPage() {
		return "/thank-you";
	}
}
