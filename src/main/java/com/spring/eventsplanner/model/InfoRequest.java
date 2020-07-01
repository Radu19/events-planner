package com.spring.eventsplanner.model;

import java.time.LocalDate;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring.eventsplanner.validation.ValidEmail;

@Entity
@Table(name="request_info")
public class InfoRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ValidEmail
	@NotNull(message = "Email is required")
	@Size(min = 1, message = "Email is required")
	@Column(name="email")
	private String email;
	
	@Pattern(regexp="^(\\+4|)?(07[0-8]{1}[0-9]{1}|02[0-9]{2}|03[0-9]{2}){1}?(\\s|\\.|\\-)?([0-9]{3}(\\s|\\.|\\-|)){2}$", 
			message="Invalid phone number")
	@NotNull(message = "Phone number is required")
	@Size(min = 1, message = "Phone number is required")
	@Column(name="phone_nr")
	private String phoneNr;
	
	@NotNull(message = "Event date is required")
	@Column(name="event_date", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate eventDate;
	
	@NotNull(message = "Number of guests is required")
	@Column(name="nr_guests")
	private int nrGuests;
	
	@NotNull(message = "Message is required")
	@Size(min = 1, message = "Message is required")
	@Column(name="message")
	private String message;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="location_id")
	private Location location;
	
	public InfoRequest() {}

	public InfoRequest(String email, String phoneNr, LocalDate eventDate, int nrGuests, String message) {
		super();
		this.email = email;
		this.phoneNr = phoneNr;
		this.eventDate = eventDate;
		this.nrGuests = nrGuests;
		this.message = message;
	}
	
	public InfoRequest(String email, String phoneNr, LocalDate eventDate, int nrGuests, String message,
			Location location) {
		super();
		this.email = email;
		this.phoneNr = phoneNr;
		this.eventDate = eventDate;
		this.nrGuests = nrGuests;
		this.message = message;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "InfoRequest [id=" + id + ", email=" + email + ", phoneNr=" + phoneNr + ", eventDate="
				+ eventDate + ", nrGuests=" + nrGuests + ", message=" + message + "]";
	}

}
