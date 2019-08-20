/**
 * 
 */
package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

/**
 * @author visa
 *
 */
public interface BookingDao {
	/**
	 * 
	 * @param criteria
	 * @return all hotels matching search criteria
	 */
	public List<Hotel> findHotels(String criteria);
	/**
	 * 
	 * @param id
	 * @return Hotel 
	 */
	public Hotel findHotelById(long id);
	/**
	 * 
	 * @param email
	 * @param password
	 * @return user
	 */
	public User getUser(String email, String password);
	/**
	 * 
	 * @param booking
	 * @return bookingId [ confirmation ]
	 */
	public long createBooking(Booking booking);
	/**
	 * 
	 * @param user
	 * @return all bookings of the login user
	 */
	public List<Booking> getAllBookingsOfUser(User user);
}
