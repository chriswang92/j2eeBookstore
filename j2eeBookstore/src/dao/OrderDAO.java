package dao;

import java.util.List;

import bean.Order;

public interface OrderDAO {
	public boolean addOrder(Order order);
	public List<Order> getOrderInfos(String username);
	public List<Order> getAllUsersOrderInfos();
	public boolean finishOrder(String orderid);
	public boolean unfinishOrder(String orderid);
	public List<Order> getFinishedOrders();
}
