package com.spring.eventsplanner.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="request_info")
public class InfoRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_nr")
	private int phoneNr;
	
	@Column(name="event_date", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate eventDate;
	
	@Column(name="nr_guests")
	private int nrGuests;
	
	@Column(name="message")
	private String message;
	
	public InfoRequest() {}

	public InfoRequest(String name, String email, int phoneNr, LocalDate eventDate, int nrGuests, String message) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNr = phoneNr;
		this.eventDate = eventDate;
		this.nrGuests = nrGuests;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(int phoneNr) {
		this.phoneNr = phoneNr;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public int getNrGuests() {
		return nrGuests;
	}

	public void setNrGuests(int nrGuests) {
		this.nrGuests = nrGuests;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "InfoRequest [id=" + id + ", name=" + name + ", email=" + email + ", phoneNr=" + phoneNr + ", eventDate="
				+ eventDate + ", nrGuests=" + nrGuests + ", message=" + message + "]";
	}
	
	
}
