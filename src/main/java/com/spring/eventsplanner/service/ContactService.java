package com.spring.eventsplanner.service;

import java.util.List;

import com.spring.eventsplanner.entity.Contact;


public interface ContactService {

	public List<Contact> findAll();
	
	public Contact findById(int theId);
	
	public void save(Contact theContact);
	
	public void deleteById(int theId);
}
