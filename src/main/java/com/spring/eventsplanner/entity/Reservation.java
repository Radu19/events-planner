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
@Table(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="reservation_date", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate reservationDate;
	
	@Column(name="ceremony_type")
	private String ceremonyType;
	
	@Column(name="nr_guests")
	private int nrGuests;
	
	@Column(name="music_included")
	private String musicIncluded;
	
	@Column(name="kitchen_included")
	private String kitchenIncluded;
	
	@Column(name="cuisine")
	private String cuisine;
	
	@Column(name="details")
	private String details;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	public Reservation() {}

	public Reservation(LocalDate reservationDate, String ceremonyType, int nrGuests, String musicIncluded,
			String kitchenIncluded, String cuisine, String details, String paymentMethod, String paymentStatus) {
		super();
		this.reservationDate = reservationDate;
		this.ceremonyType = ceremonyType;
		this.nrGuests = nrGuests;
		this.musicIncluded = musicIncluded;
		this.kitchenIncluded = kitchenIncluded;
		this.cuisine = cuisine;
		this.details = details;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getCeremonyType() {
		return ceremonyType;
	}

	public void setCeremonyType(String ceremonyType) {
		this.ceremonyType = ceremonyType;
	}

	public int getNrGuests() {
		return nrGuests;
	}

	public void setNrGuests(int nrGuests) {
		this.nrGuests = nrGuests;
	}

	public String getMusicIncluded() {
		return musicIncluded;
	}

	public void setMusicIncluded(String musicIncluded) {
		this.musicIncluded = musicIncluded;
	}

	public String getKitchenIncluded() {
		return kitchenIncluded;
	}

	public void setKitchenIncluded(String kitchenIncluded) {
		this.kitchenIncluded = kitchenIncluded;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", reservationDate=" + reservationDate + ", ceremonyType=" + ceremonyType
				+ ", nrGuests=" + nrGuests + ", musicIncluded=" + musicIncluded + ", kitchenIncluded=" + kitchenIncluded
				+ ", cuisine=" + cuisine + ", details=" + details + ", paymentMethod=" + paymentMethod
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	
	
	
}
