package com.spring.eventsplanner.service;

import java.util.List;

import com.spring.eventsplanner.model.Reservation;

public interface ReservationService {

	public List<Reservation> findAll();
	
	public Reservation findById(int theId);
	
	public void save(Reservation theReservation);
	
	public void deleteById(int theId);
}
