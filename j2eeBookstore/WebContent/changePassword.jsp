<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<b>change password</b></br>
	<% if(request.getAttribute("infoString")!=null){
%>
<%=request.getAttribute("infoString") %>
<%
}
%>
	<form action="ChangePasswordServlet" method="post">
	
	Enter new password： <input type="text" name="newPassword" ></br>
	<input type="submit" value="change password">
	</form>
	<a href="welcome.jsp"> back</a>
	</center>
</body>
</html>