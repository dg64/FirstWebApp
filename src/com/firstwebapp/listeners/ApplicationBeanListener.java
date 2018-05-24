package com.firstwebapp.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.firstwebapp.beans.ApplicationBean;
import com.firstwebapp.beans.UserBeanRegistry;

/**
 * Application Lifecycle Listener implementation class ApplicationBeanListener
 *
 */
@WebListener
public class ApplicationBeanListener implements ServletContextListener {
		private ServletContext application;

    /**
     * Default constructor. 
     */
    public ApplicationBeanListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	application = sce.getServletContext();
    	application.removeAttribute("userBeanRegistry");
    	application.removeAttribute("appBean");
    	
    	application.log(">>> FirstWebApp - Context destroyed");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	application = sce.getServletContext();
    	
    	Logger logger = LogManager.getLogger("com.firstwebapp");
    	logger.debug("==> FirstWebApp Logging set correctly!");
    	
    	ApplicationBean appBean = new ApplicationBean();
    	appBean.setId("AppBeanFirstWebApp");
    	appBean.setCustomParam(application.getInitParameter("customParam"));
    	appBean.setLogger(logger);
    	application.setAttribute("appBean", appBean);
    	
    	UserBeanRegistry userBeanRegistry = new UserBeanRegistry();
    	application.setAttribute("userBeanRegistry", userBeanRegistry);
    	
    	application.log(">>> FirstWebApp - Context intialized with param: " + appBean.getCustomParam());
    	application.log(">>> FirstWebApp - Log: " +  logger.getName() + " " +
    			logger.isDebugEnabled());
    	logger.debug("==> FirstWebApp - Context intialized with param: " + appBean.getCustomParam());

    }
	
}
