package com.spring.eventsplanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.eventsplanner.entity.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Integer>{

}
