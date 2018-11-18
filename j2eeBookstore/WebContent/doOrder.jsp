<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.proxy.*,bean.Order,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>prosessing...</p>
<% 
	Order order = new Order();
	String orderid = request.getParameter("id");
	Integer finished = Integer.valueOf(request.getParameter("finish"));
	OrderDAOProxy proxy = new OrderDAOProxy();
	if(finished==1){
	
		boolean finish = proxy.finishOrder(orderid);
	}else{
		proxy.unfinishOrder(orderid);
	}
	//request.getRequestDispatcher("orderManage.jsp").forward(request, response);
	response.sendRedirect("orderManage.jsp");
%>

	
</body>
</html>