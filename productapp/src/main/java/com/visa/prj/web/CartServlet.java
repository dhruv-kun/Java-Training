package com.visa.prj.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJdbcImpl;
import com.visa.prj.entity.Product;
 
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ses = request.getSession(false);
        if(ses == null || ses.getAttribute("user") == null) {
            response.sendRedirect("login.html");
        } else {
            String[] elems = request.getParameterValues("prds");
            if(ses.getAttribute("cart") == null) {
                ses.setAttribute("cart", new ArrayList<Product>());
            } 
            List<Product> list = (List<Product>)ses.getAttribute("cart");
            ProductDao productDao = new ProductDaoJdbcImpl();
            try {
                List<Product> products = productDao.getProducts();
                for(String e : elems) {
                    Product p = 
                            products.stream().filter(prd -> prd.getId() == Integer.parseInt(e))
                            .findFirst().get();
                    list.add(p);
                }
            } catch (FetchException e) {
                e.printStackTrace();
            } 
            ses.setAttribute("cart", list);
            response.sendRedirect("cart.jsp");
        }
    }

}
