package com.spring.eventsplanner.service;

import java.util.List;

import com.spring.eventsplanner.model.Location;


public interface LocationService {

	public List<Location> findAll();
	
	public Location findById(int theId);
	
	public void save(Location theLocation);
	
	public void deleteById(int theId);
}
