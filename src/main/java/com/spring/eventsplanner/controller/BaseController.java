package com.spring.eventsplanner.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

	@GetMapping("/")
	public String showIndex(Model theModel) {
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
