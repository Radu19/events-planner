package com.spring.eventsplanner.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="location_id")
	private Location location;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	public Meeting() {}

	public Meeting(String locationName, LocalDateTime dateTime) {
		super();
		this.locationName = locationName;
		this.dateTime = dateTime;
	}
	
	public Meeting(String locationName, LocalDateTime dateTime, User user, Location location, Customer customer) {
		super();
		this.locationName = locationName;
		this.dateTime = dateTime;
		this.user = user;
		this.location = location;
		this.customer = customer;
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", locationName=" + locationName + ", dateTime=" + dateTime + ", user=" + user
				+ ", location=" + location + ", customer=" + customer + "]";
	}

}
