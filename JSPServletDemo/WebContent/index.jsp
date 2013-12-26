<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Servlet Demo</title>
</head>
<body>
	<form action="login">
		<h2>Get</h2>
		<input type="text" name="USER_ID">
		<input type="text" name="USER_NAME"><br>
		<br><input type="submit" value="Submit"><br>
		----------------------------------------------------------------------------
	</form>
	<form action="login" method="post">
		<h2>Post</h2>
		<input type="text" name="USER_ID">
		<input type="text" name="USER_NAME"><br>
		<h4>Radio test</h4>
		<input type="radio" name="dispatch_type_radio" value="RequestForward">RequestForward
		<input type="radio" name="dispatch_type_radio" value="SendRedirect">SendRedirect
		<h4>Checkbox test</h4>
		<input type="checkbox" name="dispatch_type_checkbox" value="RequestForward">RequestForward
		<input type="checkbox" name="dispatch_type_checkbox" value="SendRedirect">SendRedirect<br>
		<br><input type="submit" value="Submit"><br>
		----------------------------------------------------------------------------
	</form>
</body>
</html>