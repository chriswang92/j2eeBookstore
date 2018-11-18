<%@page import="bean.CartItem"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Cart</title>
</head>
<body>
<table width="100%" align="center" border="1px">
    <tr>
        <th>Book id</th>
        <th>Book Cover</th>
        <th>Book name</th>
        <th>Unit price</th>
        <th>Quantity</th>
        <th>Subtotal</th>
    </tr>
    <%
    	List<String> bookInfos = new ArrayList<String>();
        //1:将添加到购物车里面的物品显示出来
         Map<Integer,CartItem> map=(Map<Integer,CartItem>)session.getAttribute("cart");
    
        //2:将购物车里面的内容遍历出来
        double count=0;//显示出总价格
        if(map != null){
        for(Map.Entry<Integer,CartItem> entry : map.entrySet()){
            //计算出每一样的书籍一共花了多少钱
            double price=entry.getValue().getBook().getPrice() * entry.getValue().getNumber();    
            //计算出一共花了多少钱
            count=count+price;
            bookInfos.add("book id: "+entry.getValue().getBook().getId()+",book name: "+entry.getValue().getBook().getName()
            		+" ,book author: "+entry.getValue().getBook().getAuthor()+" ,book price: "+entry.getValue().getBook().getPrice());
    %>
    <tr align="center">    
        <td><%=entry.getKey() %></td>
        <td><img style="width:200px;height:260px" src="<%=entry.getValue().getBook().getDescription() %>"></td>
        <td><%=entry.getValue().getBook().getName() %></td>
        <td><%=entry.getValue().getBook().getPrice() %></td>
        <td><%=entry.getValue().getNumber() %></td>
        <td><%=entry.getValue().getBook().getPrice() * entry.getValue().getNumber()%></td>
        
    </tr>
    <%}}%>
    <tr>
        <td colspan="5" align="right">Total</td>
        <td><%=count %></td>
    </tr>
</table>

<%
    	
	session.setAttribute("total", count);
	session.setAttribute("bookInfos", bookInfos);
    	
%>
<div style="text-align:center;font-size:36px;">
    <a href="book.jsp">booklist</a></br>
    <a href="checkout.jsp">checkout</a>
</div>    
</body>
</html>