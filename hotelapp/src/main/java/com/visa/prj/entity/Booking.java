package com.visa.prj.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * A Hotel Booking made by a User.
 */
@Entity
@Table(name="bookings")
public class Booking implements Serializable {
 
	private static final long serialVersionUID = -899456379957352658L;

	private static DateFormat dateFormat = DateFormat
			.getDateInstance(DateFormat.MEDIUM);
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="booking_id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	private Hotel hotel;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkinDate;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkoutDate;

	private boolean smoking;

	@Column(nullable = false)
	private int beds;

	public Booking() {
		Calendar calendar = Calendar.getInstance();
		setCheckinDate(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		setCheckoutDate(calendar.getTime());
	}

	public Booking(Hotel hotel, User user) {
		this();
		this.hotel = hotel;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date datetime) {
		this.checkinDate = datetime;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}


	public String getDescription() {

		return hotel == null ? null : hotel.getName() + ", "
				+ dateFormat.format(getCheckinDate()) + " to "
				+ dateFormat.format(getCheckoutDate());
	}

	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}



	@Override
	public String toString() {
		return "Booking(" + user + "," + hotel + "; from "
				+ dateFormat.format(getCheckinDate()) + " to "
				+ dateFormat.format(getCheckoutDate()) + ")";
	}
}
