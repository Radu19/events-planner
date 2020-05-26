package com.spring.eventsplanner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.eventsplanner.dao.LocationRepository;
import com.spring.eventsplanner.entity.Location;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	@Override
	public Location findById(int theId) {
		Optional<Location> result = locationRepository.findById(theId);
		
		Location theLocation = null;
		if (result.isPresent()) {
			theLocation = result.get();
		} else {
			throw new RuntimeException("Did not find Location id - " + theId);
		}
		return theLocation;
	}

	@Override
	public void save(Location theLocation) {
		locationRepository.save(theLocation);
	}

	@Override
	public void deleteById(int theId) {
		locationRepository.deleteById(theId);
	}

}
