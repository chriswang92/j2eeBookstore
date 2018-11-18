<%@page import="bean.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="bean.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
    Book book=(Book)session.getAttribute("book");
	String backPage=null; 
%>
<title>Book details: <%=book.getName() %></title>
</head>
<body>

<div style="text-align:right;font-size:36px;">

    <a href="docart.jsp">My Cart11</a>
</div>
<table width="100%" border="1px" align="center" cellpadding="20">
    <tr>
        <td>id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Author</td>
        <td>Cover</td>
    </tr>
    <tr>
        <td><%=String.valueOf(book.getId()) %></td>
        <td><%=book.getName() %></td>
        <td>$<%=book.getPrice() %></td>
        <td><%=book.getAuthor() %></td>
        <td><img src="<%=book.getDescription() %>"></td>
    </tr>
    <tr>
        <%  
        if(session.getAttribute("user") != null){
        	if(!((User)request.getSession().getAttribute("user")).getName().equals("admin")){
        		   %><%
        		backPage="index.jsp";
		         %>
		       <td colspan="3" align="right"><a href="cart.jsp">add to cart</a></td>
		       <%
       		}else{	backPage="bookManage.jsp";
       		}
        }
        else{  %>
       <td colspan="3" align="right"><a href="<%=backPage%>">back</a>
      <%} %>
       
        <td colspan="2"><a href="book.jsp">book list</a></td>
        
    </tr>
</table>
</body>
</html>