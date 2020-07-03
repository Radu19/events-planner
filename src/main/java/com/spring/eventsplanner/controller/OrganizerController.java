package com.spring.eventsplanner.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.eventsplanner.model.User;
import com.spring.eventsplanner.service.UserService;


@Controller 
@RequestMapping("/organizer")
public class OrganizerController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String showOrganizersList(Model theModel) {
		
		List<User> organizers = userService.findAll();
		theModel.addAttribute("organizers", organizers);
		
		return "/organizers/organizers-list";
	}
	
	@RolesAllowed("ROLE_ADMIN")
	@GetMapping("/delete")
	public String deleteOrganizer(@RequestParam("organizerId") int organizerId) {
		
		userService.deleteById((long)organizerId);
		
		return "redirect:/organizer/list";
	}
	
}
