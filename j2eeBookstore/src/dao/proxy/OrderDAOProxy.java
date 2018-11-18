package dao.proxy;

import java.util.List;

import bean.Order;
import dao.BookDAO;
import dao.BookDAOImpl;
import dao.OrderDAO;
import dao.OrderDAOImpl;
import dbc.DatabaseConnection;

public class OrderDAOProxy implements OrderDAO{
	 private DatabaseConnection dbc=null;//定义数据库连接  
	    private OrderDAO dao=null;//定义DAO接口  
	    public OrderDAOProxy(){  
	        try {  
	            dbc=new DatabaseConnection();//实例化数据库连接  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        dao=new OrderDAOImpl(dbc.getConnection());  
	          
	    }  
	@Override
	public boolean addOrder(Order order) {
		try	{
			return dao.addOrder(order);
		} catch(Exception e){
			throw e;
		} finally{
			dbc.close();
		}
	}
	@Override
	public List<Order> getOrderInfos(String username) {
		try	{
			return dao.getOrderInfos(username);
		} catch(Exception e){
			throw e;
		} finally{
			dbc.close();
		}
	}
	@Override
	public List<Order> getAllUsersOrderInfos() {
		try	{
			return dao.getAllUsersOrderInfos();
		} catch(Exception e){
			throw e;
		} finally{
			dbc.close();
		}
	}
	@Override
	public boolean finishOrder(String orderid) {
		try{
			return dao.finishOrder(orderid);
		} catch(Exception e){
			throw e;
		} finally{
			dbc.close();
		}
	}
	@Override
	public boolean unfinishOrder(String orderid) {
		try{
			return dao.unfinishOrder(orderid);
		} catch(Exception e){
			throw e;
		} finally{
			dbc.close();
		}
	}
	@Override
	public List<Order> getFinishedOrders() {
		try	{
			return dao.getFinishedOrders();
		} catch(Exception e){
			throw e;
		} finally{
			dbc.close();
		}
	}
	

}
