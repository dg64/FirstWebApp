package com.firstwebapp.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import com.opensymphony.xwork2.ActionSupport;

/*
 * by default struts2 will look under WEB-INF/content
 * to override this behavior, modify the path with the annotation @ResultPath
 * the @Namespace annotation specify under which directory look for the jsp pages 
 */
@Namespace("/protected")
@ResultPath(value="/") 
@Results({
   @Result(name = "SUCCESS", location = "/protected/ThirdPage.jsp"),
   @Result(name = "ERROR", location = "/Error.jsp")
})

public class SecondAction extends ActionSupport {
	@Action(value = "/SecondAction")
	public String execute() {
		String result = "SUCCESS";
		
		ServletContext context = ServletActionContext.getServletContext();	
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userBean") == null) {
			session.invalidate();
			result = "ERROR";
			context.log(">>> FirstWebApp - Second Action result error");
		} else {
			context.log(">>> FirstWebApp - Second Action result success");
		}
		
		return result;
	}

}
