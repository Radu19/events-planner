package com.spring.eventsplanner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.eventsplanner.dao.CustomerRepository;
import com.spring.eventsplanner.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(int theId) {
		Optional<Customer> result = customerRepository.findById(theId);
		
		Customer theCustomer = null;
		if (result.isPresent()) {
			theCustomer = result.get();
		} else {
			throw new RuntimeException("Did not find Customer id - " + theId);
		}
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		customerRepository.save(theCustomer);

	}

	@Override
	public void deleteById(int theId) {
		customerRepository.deleteById(theId);
	}

}
