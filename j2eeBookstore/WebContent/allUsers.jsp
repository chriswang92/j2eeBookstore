<%@page import="java.util.List"%>
<%@page import="service.AdminServiceImpl"%>
<%@page import="bean.Book"%>
<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表的页面</title>
</head>
<body>
<%
    //图书的业务逻辑层层
    AdminServiceImpl service=new AdminServiceImpl();
    List<User> list=service.getAllUser();
    
    String backPage = null;
    if(((User) session.getAttribute("user")).getName().equals("admin"))
		backPage="userManage.jsp"; 
    else 
		 backPage="welcome.jsp";
%>
<div style="text-align:center;font-size:36px;">
    <a href="<%= backPage%>">Back</a>
</div>
<table align="center" width="100%" border="1px">
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Password</th>
        <th>delete user</th>
    </tr>
    <%
        for(User u:list){    
        	request.setAttribute("id", String.valueOf(u.getUserid()));
    %>
    <tr align="center">
        <td><%=String.valueOf(u.getUserid()) %></td>
        <td><%=u.getName() %></td>
        <td><%=u.getPassword() %></td>
        <td><a href="editUser.jsp?id=<%=u.getUserid() %>" >delete</a></td>
    </tr>
    <%} %>
</table>

</body>
</html>