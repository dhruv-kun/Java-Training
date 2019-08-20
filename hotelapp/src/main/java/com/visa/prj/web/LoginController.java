package com.visa.prj.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Booking;

@Controller
@SessionAttributes("user")
public class LoginController {

	@RequestMapping("login.do")
	public ModelAndView doLogin(@RequestParam("user.email") String email,
			@RequestParam("user.password") String pwd, Model m) {
		// TODO
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		mav.addObject("booking", new Booking());
		m.addAttribute("user", email);
		return mav;
	}
}
