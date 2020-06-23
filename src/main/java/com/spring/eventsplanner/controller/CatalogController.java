package com.spring.eventsplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.eventsplanner.model.Customer;
import com.spring.eventsplanner.model.Location;
import com.spring.eventsplanner.service.LocationService;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/list")
	public String locationsList(Model theModel) {
		
		List<Location> locations = locationService.findAll();
		theModel.addAttribute("locations", locations);
		
		return "/catalog/catalog-list";
	}
	
	@GetMapping("/details")
	public String locationDetails(@RequestParam("locationId") int theId, Model theModel) {
		
		Location theLocation = locationService.findById(theId);
		int locationId = theLocation.getId();
		theModel.addAttribute("location", theLocation);
		theModel.addAttribute("locationId", locationId);
		theModel.addAttribute("customer", new Customer());
		
		return "/catalog/location-details";
	}
	
}
