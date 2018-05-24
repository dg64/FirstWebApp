<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>First WebApp</title>
</head>
<body>
	<h1>Home page of FirstWebApp</h1>
	
	<form action="AuthenticateAction" method="post">
		<label for="txtInput">User:</label>
		<input type="text" id="txtUsername" name="txtUsername" size="40"/>
		<label for="txtPassword">Password:</label>
		<input type="password" id="txtPassword" name="txtPassword" size="40"/>
		<input type="submit" value="invia"/>
	</form>

</body>
</html>