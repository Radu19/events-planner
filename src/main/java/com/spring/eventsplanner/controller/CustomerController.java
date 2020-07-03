package com.spring.eventsplanner.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.eventsplanner.model.Customer;
import com.spring.eventsplanner.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String showCustomerList(Model theModel) {
		
		List<Customer> customers = customerService.findAll();
		theModel.addAttribute("customers", customers);
		
		return "/customers/customers-list";
	}
	
	@RolesAllowed("ROLE_ADMIN")
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int customerId) {
		
		customerService.deleteById(customerId);
		
		return "redirect:/customer/list";
	}
}
