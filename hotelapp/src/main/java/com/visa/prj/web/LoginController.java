package com.visa.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	private BookingService bs;

	@RequestMapping("login.do")
	public ModelAndView doLogin(@RequestParam("user.email") String email, @RequestParam("user.password") String pwd,
			Model m) {

		User user = bs.getUser(email, pwd);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		mav.addObject("booking", new Booking());
		if (user != null) {
			m.addAttribute("user", user);
		}
		return mav;
	}
}
