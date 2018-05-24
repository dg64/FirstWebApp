package com.firstwebapp.actions;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.firstwebapp.beans.ApplicationBean;
import com.firstwebapp.beans.UserBean;
import com.firstwebapp.beans.UserBeanRegistry;
import com.opensymphony.xwork2.ActionSupport;

public class AuthenticateAction extends ActionSupport {
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext context = ServletActionContext.getServletContext();

		UserBeanRegistry userBeanRegistry = (UserBeanRegistry)context.getAttribute("userBeanRegistry");
		String strUsername = request.getParameter("txtUsername");
		String strPassword = request.getParameter("txtPassword");
		UserBean userBean = userBeanRegistry.authenticate(strUsername, strPassword);
		ApplicationBean appBean = (ApplicationBean)context.getAttribute("appBean");
		
		HttpSession session = request.getSession();
		session.setAttribute("user", strUsername);
		session.setAttribute("userBean", userBean);
		
		String comingFrom = request.getHeader("referer");
		
		context.log(">>> FirstWebApp - Struts2 authenticate action for " +
				userBean.getStrUsername());
		context.log(">>> FirstWebApp - Struts2 authenticate action coming from " +
				comingFrom);
		
		appBean.getLogger().debug("==> FirstWebApp - Struts2 authenticate action for " +
				userBean.getStrUsername());
		appBean.getLogger().debug("==> FirstWebApp - Struts2 authenticate action coming from " +
				comingFrom);

		return "SUCCESS";
	}

}
