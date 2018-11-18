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
<title>Insert title here</title>
</head>
<body style="background-color:gray;margin:50px 50px 50px 50px">
<center>
<span class="w3-tag w3-xlarge w3-padding w3-red" style="transform:rotate(-5deg);margin-top:50px;margin-bottom:50px">
BOOK MANAGEMENT
</span>
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
<div style="margin-bottom:20px">
	
	<form action="admin.jsp" method="get">
		 <button class="w3-button w3-cyan" type=submit>back</button>
	</form>
	
	<form action="book.jsp" method="get">
       <button class="w3-button w3-light-blue" type=submit>see all book</button>
      </form>
 </div>     
      <p>find book by input name or id here:</p>
      <form action="findBookByNameServlet" method="post">
       Book name <input type=text name="bookName">
       Book id <input type=text name="id">
       <button class="w3-button w3-blue" type=submit>find</button>
      </form>
      
      
      <p>add new book here:</p>
      <form action="addNewBookServlet" method="post">
      Book name <input type=text name="bookName">
      author <input type=text name="author">
       price <input type=text name="price">
      cover(file addr) <input type=text name="desc">
      <button class="w3-button w3-blue" type=submit>add</button>
      </form>
      
       <p>delete a book by input book id here:</p>
      <form action="deleteBookServlet" method="post">
      Book id <input type=text name="id">
      <button class="w3-button w3-blue" type=submit>delete</button>
      </form>
      
       <p>Stop /recover selling a book by input book id here:</p>
      <form action="stopSellBookStatusServlet" method="post">
      Book id <input type=text name="id">
      <button class="w3-button w3-blue" type=submit>stop</button>
      </form>
      <form action="restartSellBookStatusServlet" method="post">
      Book id <input type=text name="id">
      <button class="w3-button w3-blue" type=submit>restart</button>
      </form>
      
       <p>change book price here:</p>
      <form action="changeBookInfoServlet" method="post">
      Book name <input type=text name="bookName">
      new price <input type=text name="price">
     <button class="w3-button w3-blue" type=submit>change</button>
      </form>
      
       <p>change book cover here:</p>
      <form action="changeBookInfoServlet" method="post">
      book id <input type=text name="id">
      cover addr <input type=text name="cover">
     <button class="w3-button w3-blue" type=submit>change</button>
      </form>
      
	<%  	
List<User> users2=(List<User>)request.getAttribute("usersInfo");  
if(users2!=null){  
    Iterator<User> iter=users2.iterator();  
    while(iter.hasNext()){  
%>  
<h4><%=iter.next()%></h4>  
<%   
}  
}  
%> 

 <%  
List<String> booksInfo=(List<String>)request.getAttribute("booksInfo");  
if(booksInfo!=null){  
    Iterator<String> iter=booksInfo.iterator();  
    while(iter.hasNext()){  
%>  
<h4><%=iter.next()%></h4>  
<%   
}  
}  
%> 
</center>
</body>
</html>