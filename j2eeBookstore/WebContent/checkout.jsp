<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="margin-top:100px">
<center>
	<form action="checkoutServlet" method=post>
	<table border=1px>
	<tr>
	<td>first name</td><td><input type=text name="firstname"></td>
	<td>last name</td><td><input type=text name="lastname"></td>
	
	</tr>
	<tr>
	<td>address</td><td><input type=text name="address"></td>
	<td>postal code</td><td><input type=text name="postalcode"></td>
	</tr>
	<tr>
	<td>phone number</td><td><input type=text name="phone"></td>
	<td>creditcard number</td><td><input type=text name="creditcard"></td>
	
	</tr>
	<tr>

	</tr>
	
	</table>
	
	<input type=submit value="checkout">	
	</form>
</center>
</body>
</html>