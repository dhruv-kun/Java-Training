package com.visa.prj.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ChatListener
 *
 */
@WebListener
public class ChatListener implements ServletContextListener {

	public ChatListener() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		System.out.println("Adding data into servlet context!!!!");
		ctx.setAttribute("Company", "VISA");
	}

}
