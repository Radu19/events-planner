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

	@GetMapping("/events")
	public String showHome() {
		return "home";
	}

}
