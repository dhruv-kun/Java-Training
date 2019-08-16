package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Repository
public class BookingDaoJpaImpl implements BookingDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Hotel> findHotels(String criteria) {
		return em.createQuery("select h from Hotel h where h.city like :criteria", Hotel.class).setParameter("criteria", "%" + criteria + "%")
				.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		return em.find(Hotel.class, id);
	}

	@Override
	public User getUser(String email, String password) {
		return em.createQuery("select u from User u where u.email=:email and u.password=:password", User.class)
				.setParameter("email", email).setParameter("password", password).getSingleResult();
	}

	@Override
	public long createBooking(Booking booking) {
		return 0;
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		return em.createQuery("select b from Booking b where b.user=:user", Booking.class).setParameter("user", user)
				.getResultList();
	}

}
