package frankel.uriel.gae;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;

public class MyListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ObjectifyService.register(UserInfo.class);
		
	}
	}