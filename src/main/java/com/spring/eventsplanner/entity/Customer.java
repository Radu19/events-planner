package com.spring.eventsplanner.entity;

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

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone_nr")
	private String phoneNr;
	
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="customer",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<InfoRequest> infoRequests;
	
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
	
	public void add(InfoRequest tempInfoRequest) {
		
		if(infoRequests == null) {
			infoRequests = new ArrayList<>();
		}
		
		infoRequests.add(tempInfoRequest);
		tempInfoRequest.setCustomer(this);
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
		this.infoRequests = infoRequests;
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

	public List<InfoRequest> getInfoRequests() {
		return infoRequests;
	}

	public void setInfoRequests(List<InfoRequest> infoRequests) {
		this.infoRequests = infoRequests;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNr=" + phoneNr
				+ ", email=" + email + ", address=" + address + ", meetings=" + meetings + ", reservations="
				+ reservations + ", infoRequests=" + infoRequests + "]";
	}
	
	
}
