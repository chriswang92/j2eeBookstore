<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>  
<%@page import="java.util.List"%> 
<%@page import="java.util.ArrayList"%>
<%@page import="service.BookServiceImpl"%> 
<%@page import="bean.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bookstore</title>
<style>
body {
	background-image: url("Images/paper.jpg");
}
</style>

</head>
<body> 
<center>
<% if(request.getAttribute("infoString")!=null){
%>
<%=request.getAttribute("infoString") %>
<%
}
%>
</center>
<center>

	<h1>Welcome to chris wang's bookstore!</h1>
	<marquee><h2 style="font-color='red'">Enjoy your journey here!</h2></marquee>
	<!--  <img src="Images/bookstore.jpg"  alt="bookstore" /> -->
	<p><a href="Login.jsp">Sign in</a></p>
	<p><a href="Register.jsp">Sign up</a></p>
	
<%
BookServiceImpl service=new BookServiceImpl();
List<Book> list=service.getAll();
List<Book> l1 = new ArrayList<Book>();
List<Book> l2 = new ArrayList<Book>();
%>
<%
for(int i=0;i<6;i++){
	if(list.get(i)!=null){
		l1.add(list.get(i));
	}
}

for(int j=6;j<7;j++){
	if(list.get(j)!=null){
		l2.add(list.get(j));
	}
}

%>	
<table border="1" style="table-layout：fixed">
<tr>
<%
int n = 0;
for(Book b:list){  
	
	if(n%5!=0){
		%>
	
<td><a href="dobook.jsp?id=<%=b.getId()%>"><img style="width:200px;height:260px" src="<%=b.getDescription() %>" alt="<%=b.getName() %>" /></a></td>
<% }else{
%>
	</tr>
	<tr>
	<td><a href="dobook.jsp?id=<%=b.getId()%>"><img style="width:200px;height:260px" src="<%=b.getDescription() %>" alt="<%=b.getName() %>" /></a></td>

<% }
	n++; 
 	}	%>
</tr>
</table>

</center>
</body>
</html>