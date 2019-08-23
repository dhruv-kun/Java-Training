package com.visa.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {

	@RequestMapping("login.do")
	public String doLogin(@RequestParam("email") String email, @RequestParam("pwd") String pwd, Model m) {
		m.addAttribute("user", email);
		return "listproducts.do"; // server side redirection
	}
	 
	@RequestMapping("signout.do")
	public String doLogin(HttpServletRequest req) {
		HttpSession ses = req.getSession(false);
		ses.removeAttribute("user");
		ses.invalidate();
		return "redirect:login.html";
	}
	 
}
