package rp3.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class EmailListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println(" Email Listener init ..  ");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println(" Email Listener destroy ..  ");
	}
}
