package com.spring.eventsplanner.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.spring.eventsplanner.validation.ValidEmail;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message = "First name is required")
	@Size(min = 1, message = "First name is required")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull(message = "Last name is required")
	@Size(min = 1, message = "Last name is required")
	@Column(name="last_name")
	private String lastName;
	
	@Pattern(regexp="^(\\+4|)?(07[0-8]{1}[0-9]{1}|02[0-9]{2}|03[0-9]{2}){1}?(\\s|\\.|\\-)?([0-9]{3}(\\s|\\.|\\-|)){2}$", 
			message="Invalid phone number")
	@Column(name="phone_nr")
	private String phoneNr;
	
	@ValidEmail
	@NotNull(message = "Email is required")
	@Size(min = 1, message = "Email is required")
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="customer",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Meeting> meetings;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="customer",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Reservation> reservations;
	
	public void add(Reservation tempReservation) {
		
		if(reservations == null) {
			reservations = new ArrayList<>();
		}
		
		reservations.add(tempReservation);
		tempReservation.setCustomer(this);
	}

	public void add(Meeting tempMeeting) {
			
			if(meetings == null) {
				meetings = new ArrayList<>();
			}
			
			meetings.add(tempMeeting);
			tempMeeting.setCustomer(this);
	}

	public Customer() {}

	public Customer(String firstName, String lastName, String phoneNr, String email, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNr = phoneNr;
		this.email = email;
		this.address = address;
	}
	
	public Customer(String firstName, String lastName, String phoneNr, String email, String address,
			List<Meeting> meetings, List<Reservation> reservations, List<InfoRequest> infoRequests) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNr = phoneNr;
		this.email = email;
		this.address = address;
		this.meetings = meetings;
		this.reservations = reservations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNr=" + phoneNr
				+ ", email=" + email + ", address=" + address+ "]";
	}
	
	
}
