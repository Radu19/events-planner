package com.spring.eventsplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
	
	@GetMapping("/list")
	public String locationsList(Model theModel) {
		
		return null;
	}
}
