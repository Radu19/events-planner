package com.spring.eventsplanner.service;

import java.util.List;

import com.spring.eventsplanner.model.Meeting;


public interface MeetingService {

	public List<Meeting> findAll();
	
	public Meeting findById(int theId);
	
	public void save(Meeting theMeeting);
	
	public void deleteById(int theId);
}
