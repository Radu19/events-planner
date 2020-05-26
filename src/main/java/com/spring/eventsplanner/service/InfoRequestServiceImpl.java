package com.spring.eventsplanner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.eventsplanner.dao.InfoRequestRepository;
import com.spring.eventsplanner.entity.InfoRequest;

@Service
public class InfoRequestServiceImpl implements InfoRequestService {

	@Autowired 
	private InfoRequestRepository infoRequestRepository;
	
	@Override
	public List<InfoRequest> findAll() {
		return infoRequestRepository.findAll();
	}

	@Override
	public InfoRequest findById(int theId) {
		
		Optional<InfoRequest> result = infoRequestRepository.findById(theId);
		
		InfoRequest theInfoRequest = null;
		if (result.isPresent()) {
			theInfoRequest = result.get();
		} else {
			throw new RuntimeException("Did not find InfoRequest id - " + theId);
		}
		return theInfoRequest;
	}

	@Override
	public void save(InfoRequest theInfoRequest) {
		infoRequestRepository.save(theInfoRequest);
	}

	@Override
	public void deleteById(int theId) {
		infoRequestRepository.deleteById(theId);
	}

}
