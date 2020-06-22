package com.spring.eventsplanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.eventsplanner.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

}
