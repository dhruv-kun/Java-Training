package com.visa.prj.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.SearchCriteria;
import com.visa.prj.service.BookingService;

@Controller
public class HotelController {

	@Autowired
	private BookingService bs;
	
	@RequestMapping("search.do")
	public ModelAndView searchHotel() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchForm.jsp");
		mav.addObject("searchCriteria", new SearchCriteria());
		return mav;
	}
	
	@RequestMapping("hotels.do")
	public ModelAndView getHotels(SearchCriteria sc) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchResults.jsp");
		// TODO reduce no of results to pageSize
		List<Hotel> hotelList = bs.findHotels(sc.getSearchString());
		mav.addObject("hotelList", hotelList);
		return mav;
	}
	
	@RequestMapping("viewHotel.do")
	public ModelAndView viewHotel(Hotel h) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showHotel.jsp");
		Hotel hotel = bs.getHotelById(h.getId());
		mav.addObject("hotel", hotel);
		return mav;
	}
	
	@RequestMapping("bookingForm.do")
	public ModelAndView bookingForm(Hotel h) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bookingForm.jsp");
		Booking b = new Booking();
		Hotel hotel = bs.getHotelById(h.getId());
		b.setHotel(hotel);
		mav.addObject("booking", b);
		return mav;
	}
	
	@RequestMapping("placeReservation.do")
	public ModelAndView placeReservation(Booking b) {
		// TODO
		System.out.println(b);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		return mav;
	}
}
