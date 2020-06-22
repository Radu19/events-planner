package com.spring.eventsplanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.eventsplanner.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
