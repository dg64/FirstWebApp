package com.firstwebapp.beans;

import java.io.Serializable;

public class UserBeanRegistry extends Object implements Serializable {
	
	public UserBeanRegistry() {
		super();
	}

	public UserBean authenticate(String strUserName, String strPassword) {
		UserBean userBean = new UserBean();
		userBean.setId("UserBean");
		userBean.setValidUser(true);
		userBean.setStrUsername(strUserName);
		userBean.setStrPassword(strPassword);
		return userBean;
	}
}
