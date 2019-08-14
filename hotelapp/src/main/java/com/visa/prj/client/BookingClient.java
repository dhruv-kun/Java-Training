package com.visa.prj.client;

import java.util.List;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Hotel;
import com.visa.prj.service.BookingService;

public class BookingClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		BookingService bs = ctx.getBean("bookingService", BookingService.class);
		
		List<Hotel> list = bs.findHotels("NY");

		for (Hotel htl: list)
			System.out.println(htl);

		User user = bs.getUser("d@visa.com", "visa123");
		System.out.println(user);

		List<Booking> bookingList = bs.getAllBookingsByUser(user);
		for (Booking b: bookingList)
			System.out.println(b.getDescription());
	}

}
