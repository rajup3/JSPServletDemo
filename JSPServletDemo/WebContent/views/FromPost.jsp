<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>From Get method</title>
</head>
<body>
	<h1>POST:</h1>
	<h2><%= request.getAttribute("MESSAGE")+" "+request.getAttribute("USER_ID") %></h2>
</body>
</html>