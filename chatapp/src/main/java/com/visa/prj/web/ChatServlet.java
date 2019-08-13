package com.visa.prj.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession(false);
		String user = "";
		if (ses != null && ses.getAttribute("user") != null) {
			user = (String) ses.getAttribute("user");
		}
		String m = request.getParameter("msg"); // read message from chat.jsp

		ServletContext ctx = request.getServletContext();
		if (ctx.getAttribute("messages") == null) {
			ctx.setAttribute("messages", new ArrayList<String>());
		}
		ArrayList<String> chatMessages = (ArrayList<String>) ctx.getAttribute("messages");
		chatMessages.add(user + ":" + m);
		response.sendRedirect("chat.jsp");
	}
}
