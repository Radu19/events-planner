package com.spring.eventsplanner.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.eventsplanner.model.Customer;
import com.spring.eventsplanner.model.Location;
import com.spring.eventsplanner.model.Meeting;
import com.spring.eventsplanner.model.User;
import com.spring.eventsplanner.service.CustomerService;
import com.spring.eventsplanner.service.LocationService;
import com.spring.eventsplanner.service.MeetingService;
import com.spring.eventsplanner.service.UserService;

@Controller
@RequestMapping("/meeting")
public class MeetingController {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private MeetingService meetingService;
	
	@Autowired
	private UserService userService;

	@PostMapping("/process-customer")
	public String processCustomer(@RequestParam("locationId") int locationId,@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult, RedirectAttributes attributes) {
		
		if(theBindingResult.hasErrors()) {
			attributes.addFlashAttribute("org.springframework.validation.BindingResult.customer", theBindingResult);
			attributes.addFlashAttribute("customer", theCustomer);
			return "redirect:/catalog/details?locationId="+locationId;
		}
		
		if(customerService.isNew(theCustomer)) {
			customerService.save(theCustomer);
		}
		theCustomer = customerService.findByEmail(theCustomer.getEmail());
		int customerId = theCustomer.getId();
		
		attributes.addFlashAttribute("customerId", customerId);
		
		return "redirect:/meeting/book?locationId=" + locationId;
	}
	
	@GetMapping("/book")
	public String bookMeeting(@RequestParam("locationId") int theId, Model theModel) {
		
		Location theLocation = locationService.findById(theId);
		theModel.addAttribute("location", theLocation);
		
		//set meeting's location
		LocalDateTime dateNow = LocalDateTime.now().plusDays(5);
		Meeting theMeeting = new Meeting();
		theMeeting.setDateTime(dateNow);
		theMeeting.setLocation(theLocation);
		theMeeting.setLocationName(theLocation.getName());
		
		//set meeting's customer
		int customerId = (int) theModel.asMap().get("customerId");
		Customer theCustomer = customerService.findById(customerId);
		theMeeting.setCustomer(theCustomer);
		
		theModel.addAttribute("meeting", theMeeting);
	
		return "/meetings/book-meeting";
	}
	
	@PostMapping("/book")
	public String bookMeeting(@ModelAttribute("meeting") Meeting theMeeting) {
		//set meeting's organizer as admin user
		User adminUser = userService.findById((long)3);
		theMeeting.setUser(adminUser);
		
		//save meeting
		meetingService.save(theMeeting);
		return "redirect:/thank-you";
	}
	
	@GetMapping("/list")
	public String showMeetings(Model theModel) {
		
		List<Meeting> meetings = meetingService.findAll();
		theModel.addAttribute("meetings", meetings);
		
		return "/meetings/meetings-list";
	}
	
	@RolesAllowed("ROLE_ADMIN")
	@GetMapping("/delete")
	public String deleteMeeting(@RequestParam("meetingId") int meetingId) {
		
		meetingService.deleteById(meetingId);
		
		return "redirect:/meeting/list";
	}
	
}
