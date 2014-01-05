package de.jbiblio.serstapa.restapi.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RestApiContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println(sce.getServletContext().getContextPath()
				+ " destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(sce.getServletContext().getContextPath()
				+ " initialized");
	}

}
