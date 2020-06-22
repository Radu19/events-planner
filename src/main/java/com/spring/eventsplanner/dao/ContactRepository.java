package com.spring.eventsplanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.eventsplanner.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
