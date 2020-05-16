package com.spring.eventsplanner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.eventsplanner.dao.ReservationRepository;
import com.spring.eventsplanner.entity.Reservation;

public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation findById(int theId) {
		
		Optional<Reservation> result = reservationRepository.findById(theId);
		
		Reservation theReservation = null;
		if (result.isPresent()) {
			theReservation = result.get();
		} else {
			throw new RuntimeException("Did not find Reservation id - " + theId);
		}
		return theReservation;
	}

	@Override
	public void save(Reservation theReservation) {
		reservationRepository.save(theReservation);
	}

	@Override
	public void deleteById(int theId) {
		reservationRepository.deleteById(theId);
	}

}
