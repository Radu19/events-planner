package com.spring.eventsplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.eventsplanner.model.InfoRequest;
import com.spring.eventsplanner.service.InfoRequestService;

@Controller
@RequestMapping("/info-request")
public class InfoRequestController {
	
	@Autowired
	private InfoRequestService infoRequestService;

	@PostMapping("/process-request")
	public String processInfoRequest(@ModelAttribute("infoRequest") InfoRequest theInfoRequest) {
		
		infoRequestService.save(theInfoRequest);
		return "redirect:/thank-you";
	}
	
}
