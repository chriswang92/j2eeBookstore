<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.proxy.*,bean.User,bean.Order,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>order management</title>
</head>
<body>
<%
	OrderDAOProxy orderproxy = new OrderDAOProxy();
	UserDAOProxy userproxy = new UserDAOProxy();
	List<User> userlist = userproxy.getAllUser();
	List<Order> orderlist = new ArrayList<Order>();
	List<Order> currentUserOrderlist = null;
	User currentUser = ((User)request.getSession().getAttribute("user"));
	String currentLogin = ((User)request.getSession().getAttribute("user")).getName();
	if(currentLogin.equals("admin")){
		currentUserOrderlist = orderproxy.getAllUsersOrderInfos();
	}else{
		currentUserOrderlist = orderproxy.getOrderInfos(currentLogin);
	}
	for(Order o : currentUserOrderlist){
		orderlist.add(o);
	}
	Boolean finishResult = null;
	OrderDAOProxy orderproxy2 = new OrderDAOProxy();
	List<Order> finishedOrderList = orderproxy2.getFinishedOrders();
	for(Order o : finishedOrderList){
		System.out.println(o.toString());
	}
%>
<table  align="center" width="100%" border="1px">
    <tr style="font-size:200%">
    	
        <th>id</th>
        <th>userName</th>
        <th>clientName</th>
        <th>address</th>
        <th>books</th>
        <th>totalprice</th>
    <% if(currentLogin.equals("admin")){ %>
    	<th>order manage options</th>
    <%}else{ %>
    	<th>order status</th>
    	<%} %>
    </tr>
    <%
        for(Order o:orderlist){    
        	request.getSession().setAttribute("order", o);
        	//List<String> l = (List<String>)request.getSession().getAttribute("finishlist");
        	
    %>
    <tr align="center">
        <td><%=String.valueOf(o.getId()) %></td>
        <td><%=o.getUsername() %></a></td>
        <td><%=o.getClientName() %></td>
        <td><%=o.getAddress() %></td>
        <td><%=o.getBooks() %></td>
        <td><%=o.getTotalprice() %></td>
         <% 
        	 	boolean isFinished = false;
        	 	for(Order oo : finishedOrderList){
        	 		if(oo.getId() == o.getId()){
        	 			isFinished = true;
        	 		}
        	 	}
        	 	if(isFinished){%>
        	 		<td style="color:#00ff00"><b>order is finished</b><br>
         			<%if(currentLogin.equals("admin")){  %>
         				<a href="doOrder.jsp?finish=0&id=<%=o.getId()%>">unfinish order</a>
		   		 	<%}
         		}else{ %>
		   		 	<td style="color:red"><b>order is not finished</b><br>
		   		 <%if(currentLogin.equals("admin")){  %>
		   		 	<a href="doOrder.jsp?finish=1&id=<%=o.getId()%>">finish order</a>
		   		 <%} 
         		}%>
         		</td>
         
    </tr>
    <%} %>
</table>

<botton>
<div style="font-size:200%">
<% if(!currentLogin.equals("admin")){ %>
    	<a href="welcome.jsp" >back</a>
    <%}else{ %>
    	<a href="admin.jsp">back to admin page</a>
    	<%} %>
 </div>
</botton>
</body>
</html>