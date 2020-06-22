package com.spring.eventsplanner.service;

import java.util.List;

import com.spring.eventsplanner.model.InfoRequest;

public interface InfoRequestService {

	public List<InfoRequest> findAll();
	
	public InfoRequest findById(int theId);
	
	public void save(InfoRequest theRequestInfo);
	
	public void deleteById(int theId);
}
