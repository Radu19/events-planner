package com.spring.eventsplanner.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.eventsplanner.model.Contact;
import com.spring.eventsplanner.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@PostMapping("/process-request")
	public String processContact(@ModelAttribute("contact") Contact theContact) {
		
		contactService.save(theContact);
		
		return "redirect:/thank-you";
	}
	
	@GetMapping("/list")
	public String showContactList(Model theModel) {
		
		List<Contact> contacts = contactService.findAll();
		theModel.addAttribute("contacts", contacts);
		
		return "/contacts/contacts-list";
	}
	
	@RolesAllowed("ROLE_ADMIN")
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("contactId") int contactId) {
		
		contactService.deleteById(contactId);
		
		return "redirect:/contact/list";
	}
}
