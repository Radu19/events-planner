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

@Entity
@Table(name="location")
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="max_guests")
	private int maxGuests;

	@Column(name="min_guests")
	private int minGuests;
	
	@Column(name="price_per_guest")
	private double pricePerGuest;
	
	@Column(name="own_kitchen")
	private String ownKitchen;
	
	@Column(name="own_music")
	private String ownMusic;
	
	@Column(name="ceremony_types")
	private String ceremonyTypes;
	
	@Column(name="cuisine")
	private String cuisine;
	
	@Column(name="modify_menu")
	private String modifyMenu;
	
	@Column(name="special_menu")
	private String specialMenu;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	@Column(name="description")
	private String description;
	
	@Column(name="img")
	private String img;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="location",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Reservation> reservations;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="location",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Meeting> meetings;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="location",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<InfoRequest> infoRequests;
	
	public void add(Reservation tempReservation) {
		
		if(reservations == null) {
			reservations = new ArrayList<>();
		}
		
		reservations.add(tempReservation);
		tempReservation.setLocation(this);
	}

	public void add(Meeting tempMeeting) {
			
			if(meetings == null) {
				meetings = new ArrayList<>();
			}
			
			meetings.add(tempMeeting);
			tempMeeting.setLocation(this);
	}
	
	public void add(InfoRequest tempInfoRequest) {
		
		if(infoRequests == null) {
			infoRequests = new ArrayList<>();
		}
		
		infoRequests.add(tempInfoRequest);
		tempInfoRequest.setLocation(this);
	}
	
	public Location() {}

	public Location(String name, String address, int maxGuests, int minGuests, double pricePerGuest, String ownKitchen,
			String ownMusic, String ceremonyTypes, String cuisine, String modifyMenu, String specialMenu,
			String paymentMethod, String description, String img) {
		super();
		this.name = name;
		this.address = address;
		this.maxGuests = maxGuests;
		this.minGuests = minGuests;
		this.pricePerGuest = pricePerGuest;
		this.ownKitchen = ownKitchen;
		this.ownMusic = ownMusic;
		this.ceremonyTypes = ceremonyTypes;
		this.cuisine = cuisine;
		this.modifyMenu = modifyMenu;
		this.specialMenu = specialMenu;
		this.paymentMethod = paymentMethod;
		this.description = description;
		this.img = img;
	}
	
	public Location(String name, String address, int maxGuests, int minGuests, double pricePerGuest, String ownKitchen,
			String ownMusic, String ceremonyTypes, String cuisine, String modifyMenu, String specialMenu,
			String paymentMethod, String description, String img, List<Reservation> reservations, List<Meeting> meetings,
			List<InfoRequest> infoRequests) {
		super();
		this.name = name;
		this.address = address;
		this.maxGuests = maxGuests;
		this.minGuests = minGuests;
		this.pricePerGuest = pricePerGuest;
		this.ownKitchen = ownKitchen;
		this.ownMusic = ownMusic;
		this.ceremonyTypes = ceremonyTypes;
		this.cuisine = cuisine;
		this.modifyMenu = modifyMenu;
		this.specialMenu = specialMenu;
		this.paymentMethod = paymentMethod;
		this.description = description;
		this.img = img;
		this.reservations = reservations;
		this.meetings = meetings;
		this.infoRequests = infoRequests;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMaxGuests() {
		return maxGuests;
	}

	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}

	public int getMinGuests() {
		return minGuests;
	}

	public void setMinGuests(int minGuests) {
		this.minGuests = minGuests;
	}

	public double getPricePerGuest() {
		return pricePerGuest;
	}

	public void setPricePerGuest(double pricePerGuest) {
		this.pricePerGuest = pricePerGuest;
	}

	public String getOwnKitchen() {
		return ownKitchen;
	}

	public void setOwnKitchen(String ownKitchen) {
		this.ownKitchen = ownKitchen;
	}

	public String getOwnMusic() {
		return ownMusic;
	}

	public void setOwnMusic(String ownMusic) {
		this.ownMusic = ownMusic;
	}

	public String getCeremonyTypes() {
		return ceremonyTypes;
	}

	public void setCeremonyTypes(String ceremonyTypes) {
		this.ceremonyTypes = ceremonyTypes;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getModifyMenu() {
		return modifyMenu;
	}

	public void setModifyMenu(String modifyMenu) {
		this.modifyMenu = modifyMenu;
	}

	public String getSpecialMenu() {
		return specialMenu;
	}

	public void setSpecialMenu(String specialMenu) {
		this.specialMenu = specialMenu;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

	public List<InfoRequest> getInfoRequests() {
		return infoRequests;
	}

	public void setInfoRequests(List<InfoRequest> infoRequests) {
		this.infoRequests = infoRequests;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", address=" + address + ", maxGuests=" + maxGuests
				+ ", minGuests=" + minGuests + ", pricePerGuest=" + pricePerGuest + ", ownKitchen=" + ownKitchen
				+ ", ownMusic=" + ownMusic + ", ceremonyTypes=" + ceremonyTypes + ", cuisine=" + cuisine
				+ ", modifyMenu=" + modifyMenu + ", specialMenu=" + specialMenu + ", paymentMethod=" + paymentMethod
				+", img=" + img + "]";
	}

	

	
}
