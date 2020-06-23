package com.spring.eventsplanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.eventsplanner.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query(value = "SELECT * FROM Customer c WHERE c.email = ?1", nativeQuery = true)
	public Customer findByEmail(String email);
	
}
