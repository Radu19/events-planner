package com.spring.eventsplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/administration")
	public String showMyLoginPage() {
		
		return "login-page";
		
	}
	
	// add request mapping for /access-denied
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
}









