package com.spring.eventsplanner.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_nr")
	private String phoneNr;
	
	@Column(name="event_type")
	private String eventType;
	
	@Column(name="event_date", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate eventDate;
	
	@Column(name="message")
	private String message;
	
	public Contact() {}

	public Contact(String name, String email, String phoneNr, String eventType, LocalDate eventDate, String message) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNr = phoneNr;
		this.eventType = eventType;
		this.eventDate = eventDate;
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

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", phoneNr=" + phoneNr + ", eventType="
				+ eventType + ", eventDate=" + eventDate + ", message=" + message + "]";
	}
	
	
}
