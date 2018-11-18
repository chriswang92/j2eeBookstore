<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.proxy.UserDAOProxy" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id=request.getParameter("id");
		UserDAOProxy proxy = new UserDAOProxy();
		boolean result = proxy.deleteUserById(id);
		if(result){
			request.setAttribute("adminInfo", "user delete succeed");
		}else{
			request.setAttribute("adminInfo", "user delete failed");
		}
		request.getRequestDispatcher("userManage.jsp").forward(request, response);
	%>
	processing...
</body>
</html>