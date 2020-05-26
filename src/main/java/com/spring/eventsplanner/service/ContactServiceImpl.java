package com.spring.eventsplanner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.eventsplanner.dao.ContactRepository;
import com.spring.eventsplanner.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	@Override
	public Contact findById(int theId) {
		
		Optional<Contact> result = contactRepository.findById(theId);
		
		Contact theContact = null;
		if (result.isPresent()) {
			theContact = result.get();
		} else {
			throw new RuntimeException("Did not find Contact id - " + theId);
		}
		return theContact;
	}

	@Override
	public void save(Contact theContact) {
		contactRepository.save(theContact);
	}

	@Override
	public void deleteById(int theId) {
		contactRepository.deleteById(theId);
	}

}
