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
	
	@GetMapping("/list")
	public String showInfoRequestsList(Model theModel) {
		
		List<InfoRequest> infoRequests = infoRequestService.findAll();
		theModel.addAttribute("infoRequests", infoRequests);
		
		return "/info-requests/info-requests-list";
	}
	
	@GetMapping("/delete")
	public String deleteInfoRequest(@RequestParam("infoRequestId") int infoRequestId) {
		
		infoRequestService.deleteById(infoRequestId);
		
		return "redirect:/meeting/list";
	}
	
	
}
