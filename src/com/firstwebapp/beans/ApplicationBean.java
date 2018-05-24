package com.firstwebapp.beans;

import java.io.Serializable;

import org.apache.logging.log4j.Logger;

public class ApplicationBean extends Object implements Serializable {

	private String id;
	private String customParam;
	private Logger logger;
	

	public String getCustomParam() {
		return customParam;
	}

	public void setCustomParam(String customParam) {
		this.customParam = customParam;
	}

	public ApplicationBean() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	
	
}
