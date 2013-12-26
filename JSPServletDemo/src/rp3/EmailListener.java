package rp3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class EmailListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println(" EmailListener.init() ..  ");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println(" contextDestroyed.destroy() ..  ");
	}
}
