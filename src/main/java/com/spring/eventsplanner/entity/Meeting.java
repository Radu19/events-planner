package com.spring.eventsplanner.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="meeting")
public class Meeting {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="location_name")
	private String locationName;
	
	@Column(name="date_time", columnDefinition = "TIMESTAMP")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime dateTime;
	
	public Meeting() {}

	public Meeting(String locationName, LocalDateTime dateTime) {
		super();
		this.locationName = locationName;
		this.dateTime = dateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", locationName=" + locationName + ", dateTime=" + dateTime + "]";
	}
	
	
}
