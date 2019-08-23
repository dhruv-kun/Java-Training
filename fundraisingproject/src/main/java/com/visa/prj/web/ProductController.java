package com.visa.prj.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@Controller
public class ProductController {

	@Autowired
	private OrderService os;

	@Autowired
	private ProductValidator validator;

	@RequestMapping("listproducts.do")
	public ModelAndView getProducts() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list.jsp");
		mav.addObject("products", os.fetchProducts());
		return mav;
	}

	@RequestMapping("productsform.do")
	public ModelAndView getProductForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form.jsp");
		mav.addObject("product", new Product());
		return mav;
	}

	@RequestMapping("addproduct.do")
	public String addProduct(@ModelAttribute("product") Product p, Model m, BindingResult errors) {
		validator.validate(p, errors);

		if (errors.hasErrors())
			return "form.jsp";
		else {
			os.insertProduct(p);
			m.addAttribute("msg", "Product added successfully!!!");
			return "index.jsp";
		}
	}

	@RequestMapping("cart.do")
	public String addToCart(HttpServletRequest req) {
		String user = (String) req.getSession().getAttribute("user");
		os.placeOrder(req.getParameterValues("prds"), user);

		System.out.println(user);
		return "index.jsp";
	}
}
