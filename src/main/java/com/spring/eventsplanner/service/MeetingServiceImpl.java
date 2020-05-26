package com.spring.eventsplanner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.eventsplanner.dao.MeetingRepository;
import com.spring.eventsplanner.entity.Meeting;

@Service
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	private MeetingRepository meetingRepository;
	
	@Override
	public List<Meeting> findAll() {
		return meetingRepository.findAll();
	}

	@Override
	public Meeting findById(int theId) {
		Optional<Meeting> result = meetingRepository.findById(theId);
		
		Meeting theMeeting = null;
		if (result.isPresent()) {
			theMeeting = result.get();
		} else {
			throw new RuntimeException("Did not find Meeting id - " + theId);
		}
		return theMeeting;
	}

	@Override
	public void save(Meeting theMeeting) {
		meetingRepository.save(theMeeting);

	}

	@Override
	public void deleteById(int theId) {
		meetingRepository.deleteById(theId);
	}

}
