package com.spring.eventsplanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.eventsplanner.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
