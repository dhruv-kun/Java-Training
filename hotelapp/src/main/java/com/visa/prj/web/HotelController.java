package com.visa.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.service.BookingService;

@Controller
public class HotelController {

	@Autowired
	private BookingService bs;
	
	@RequestMapping("search.do")
	public ModelAndView getHotels() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showHotel.jsp");
		mav.addObject("hotel", bs.getHotelById(1));
		return mav;
		
	}
	
}
