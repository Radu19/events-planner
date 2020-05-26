package com.spring.eventsplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.eventsplanner.entity.Location;
import com.spring.eventsplanner.service.LocationService;

@Controller
@RequestMapping("/locations")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/list")
	public String listLocations(Model theModel) {
		
		List<Location> locations = locationService.findAll();
		
		theModel.addAttribute("locations", locations);
		
		return "/locations/locations-list";
	}
	
	@GetMapping("/add")
	public String addLocation(Model theModel) {
		
		String img = (String) theModel.asMap().get("locationName");
		
		Location theLocation = new Location();
		if(img!=null) {
			theLocation.setImg(img);
		}
		theModel.addAttribute("location", theLocation);
		
		return "/locations/location-form";
	}
	
	@GetMapping("/update")
	public String updateLocation(@RequestParam("locationId") int theId, Model theModel) {
		
		Location theLocation = locationService.findById(theId);
		theModel.addAttribute("location", theLocation);
		
		return "/locations/location-form";
	}
	
	@PostMapping("/save")
	public String saveLocation(@ModelAttribute("location") Location theLocation) {
		
		locationService.save(theLocation);
		
		return "redirect:/locations/list";
	}
	
	@GetMapping("/delete")
	public String deleteLocation(@RequestParam("locationId") int theId) {
		
		locationService.deleteById(theId);
		
		return "redirect:/locations/list";
	}
	
	
	
	
	
}
