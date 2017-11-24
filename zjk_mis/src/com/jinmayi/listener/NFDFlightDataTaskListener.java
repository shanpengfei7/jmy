package com.jinmayi.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class NFDFlightDataTaskListener implements ServletContextListener {
	 @Override
	public void contextInitialized(ServletContextEvent event) {
	  new TimerManager();
	 } 
	 @Override
	public void contextDestroyed(ServletContextEvent event) {
	 }
	 
	}
