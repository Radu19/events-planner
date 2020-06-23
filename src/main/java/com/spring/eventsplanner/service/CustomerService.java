package com.spring.eventsplanner.service;

import java.util.List;

import com.spring.eventsplanner.model.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);
	
	public boolean isNew(Customer theCustomer);
	
	public Customer findByEmail(String email);
}
