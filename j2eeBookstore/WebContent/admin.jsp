<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>  
<%@page import="java.util.List"%> 
<%@page import="bean.User" %>
<%@page import="service.AdminServiceImpl" %>
<%@page import="java.util.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>admin page</title>

</head>
<body style="background-color:gray">
<center>
	<h1>This is admin page</h1>
<div class="w3-container">
<p><span class="w3-tag w3-blue">
<% if(request.getAttribute("adminInfo")!=null){
%>
<%=request.getAttribute("adminInfo") %>
<%
}
%>
</span></p>
</div>
	
	<form action="bookManage.jsp" method="get">
	 <button class="w3-button w3-aqua" type=submit>Book Management</button>
	</form>
	<form action="userManage.jsp" method="get">
	 <button class="w3-button w3-aqua" type=submit>User Management</button>
	</form>
	<form action="orderManage.jsp" method="get">
	 <button class="w3-button w3-aqua" type=submit>Order Management</button>
	</form>
	<form action="LoginOutServlet" method="get">
	 <button class="w3-button w3-aqua" type=submit>log out</button>
	</form>
	
</center>
</body>
</html>