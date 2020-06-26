package com.spring.eventsplanner.controller;


import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.eventsplanner.model.Contact;

@Controller
public class BaseController {

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
	public String showHome() {
		return "administration-page";
	}

	@GetMapping("/thank-you")
	public String thankYouPage() {
		return "/thank-you";
	}
}
