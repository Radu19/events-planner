package com.spring.eventsplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.eventsplanner.model.InfoRequest;

@Controller
@RequestMapping("/info-request")
public class InfoRequestController {

	@PostMapping("/process-request")
	public String processInfoRequest(@ModelAttribute("infoRequest") InfoRequest theInfoRequest) {
		
		return null;
	}
}
