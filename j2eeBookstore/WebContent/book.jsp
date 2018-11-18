<%@page import="java.util.List"%>
<%@page import="service.BookServiceImpl"%>
<%@page import="bean.Book"%>
<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All book list</title>
</head>
<body>

<% if(session.getAttribute("cartString")!=null){
%>
<%=session.getAttribute("cartString") %>
<%
}
%>
<%
    
    BookServiceImpl service=new BookServiceImpl();
    List<Book> list=service.getAll();
    String backPage = null;
    if(((User) session.getAttribute("user")) == null)
    	backPage="index.jsp";
    else{ 
   
	    if(((User) session.getAttribute("user")).getName().equals("admin"))
			backPage="bookManage.jsp"; 
	    else 
			backPage="welcome.jsp";
    }
    	
%>
<div style="text-align:center;font-size:36px;">
    <a href="<%=backPage%>">back</a>
    <a href="docart.jsp">My cart</a>
</div>
<table align="center" width="100%" border="1px">
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Author</th>
        <th>picture</th>
    </tr>
    <%
        for(Book b:list){    
    %>
    <tr align="center">
        <td><%=String.valueOf(b.getId()) %></td>
        <td><a href="dobook.jsp?id=<%=b.getId()%>"><%=b.getName() %></a></td>
        <td><%=b.getPrice() %></td>
        <td><%=b.getAuthor() %></td>
        <td><img style="width:200px;height:260px" src="<%=b.getDescription() %>"></td>
    </tr>
    <%} %>
</table>

</body>
</html>