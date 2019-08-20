package com.visa.prj.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.SearchCriteria;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

@Controller
@SessionAttributes("hotel")
public class HotelController {

	@Autowired
	private BookingService bs;

	@RequestMapping("search.do")
	public ModelAndView searchHotel(HttpServletRequest req) {

		ModelAndView mav = new ModelAndView();
		System.out.println(req.getSession().getAttribute("user"));
		if (req.getSession().getAttribute("user") == null) {

			mav.setViewName("userLoginForm.jsp");
			mav.addObject("booking", new Booking());
		} else {
			mav.setViewName("searchForm.jsp");
			mav.addObject("searchCriteria", new SearchCriteria());
		}
		return mav;
	}

	@RequestMapping("hotels.do")
	public ModelAndView getHotels(SearchCriteria sc) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchResults.jsp");
		List<Hotel> hotelList = bs.findHotels(sc.getSearchString());
		if (hotelList.size() > sc.getPageSize())
			hotelList = hotelList.subList(0, sc.getPageSize());
		mav.addObject("hotelList", hotelList);
		return mav;
	}

	@RequestMapping("viewHotel.do")
	public ModelAndView viewHotel(@RequestParam("id") int hotel_id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showHotel.jsp");
		Hotel hotel = bs.getHotelById(hotel_id);
		mav.addObject("hotel", hotel);
		return mav;
	}

	@RequestMapping("bookingForm.do")
	public ModelAndView bookingForm(HttpServletRequest req, @RequestParam("id") int hotel_id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bookingForm.jsp");
		Booking b = new Booking();
		Hotel hotel = bs.getHotelById(hotel_id);
		User user = (User) req.getSession().getAttribute("user");
		System.out.println(user);
		b.setHotel(hotel);
		b.setUser(user);
		mav.addObject("booking", b);
		return mav;
	}

	@RequestMapping("placeReservation.do")
	public ModelAndView placeReservation(@ModelAttribute("hotel") Hotel hotel,
			@RequestParam("checkinDate") Date checkinDate, @RequestParam("checkoutDate") Date checkoutDate,
			@RequestParam("user.email") String email, HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("user");
		bs.makeBooking(user, hotel, checkinDate, checkoutDate, true, 3);
		List<Booking> bookingList = bs.getAllBookingsByUser(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showBookings.jsp");
		mav.addObject("bookingList", bookingList);
		return mav;
	}

	@InitBinder
	public void dataTypeBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
}
