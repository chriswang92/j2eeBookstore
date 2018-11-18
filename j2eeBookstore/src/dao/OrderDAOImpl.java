package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Book;
import bean.Order;
import dbc.DatabaseConnection;

public class OrderDAOImpl implements OrderDAO {
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库操作对象
	private ResultSet resultSet = null;

	public OrderDAOImpl(Connection conn) { // 设置数据库连接
		this.conn = conn;
	}

	private java.sql.Statement sta = null;

	@Override
	public boolean addOrder(Order order) {
		boolean result = false;
		try {
			sta = conn.createStatement();
			String sql = "insert into Orders(id,username,clientName,address,totalprice,books,display) values (null,'"
					+ order.getUsername() +"','"+order.getClientName() + "','" + order.getAddress() + "'," + order.getTotalprice() + ",'"
					+ order.getBooks() + "',1);";
			sta.executeUpdate(sql);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sta != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public List<Order> getOrderInfos(String username) {
		List<Order> l = new ArrayList<Order>();
		try {
			String sql = "SELECT * FROM example.Orders where username=?";
			pstmt = conn.prepareStatement(sql);// 实例化操作
			pstmt.setString(1, username);
			resultSet = pstmt.executeQuery();// 取得结果
			while (resultSet.next()) {
				Order order = new Order();
				order.setId(resultSet.getInt("id"));
				order.setUsername(resultSet.getString("username"));
				order.setClientName(resultSet.getString("clientName"));
				order.setAddress(resultSet.getString("address"));
				order.setBooks(resultSet.getString("books"));
				order.setTotalprice(resultSet.getDouble("totalprice"));
				order.setDisplay(resultSet.getInt("display"));
				l.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(conn, pstmt, resultSet);
		}
		return l;
	}

	@Override
	public List<Order> getAllUsersOrderInfos() {
		List<Order> l = new ArrayList<Order>();
		try {
			String sql = "SELECT * FROM example.Orders";
			pstmt = conn.prepareStatement(sql);// 实例化操作
			resultSet = pstmt.executeQuery();// 取得结果
			while (resultSet.next()) {
				Order order = new Order();
				order.setId(resultSet.getInt("id"));
				order.setUsername(resultSet.getString("username"));
				order.setClientName(resultSet.getString("clientName"));
				order.setAddress(resultSet.getString("address"));
				order.setBooks(resultSet.getString("books"));
				order.setTotalprice(resultSet.getDouble("totalprice"));
				order.setDisplay(resultSet.getInt("display"));
				l.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(conn, pstmt, resultSet);
		}
		return l;
	}
	
	@Override
	public boolean finishOrder(String orderid) {
		boolean result = false;
		try {
			sta = conn.createStatement();
			String sql = "update Orders set display=0 where id="+orderid;
			sta.executeUpdate(sql);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sta != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public boolean unfinishOrder(String orderid) {
		boolean result = false;
		try {
			sta = conn.createStatement();
			String sql = "update Orders set display=1 where id="+orderid;
			sta.executeUpdate(sql);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sta != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	@Override
	public List<Order> getFinishedOrders() {
		List<Order> l = new ArrayList<Order>();
		try {
			String sql = "SELECT * FROM example.Orders where display=?";
			pstmt = conn.prepareStatement(sql);// 实例化操作
			pstmt.setInt(1, 0);
			resultSet = pstmt.executeQuery();// 取得结果
			while (resultSet.next()) {
				Order order = new Order();
				order.setId(resultSet.getInt("id"));
				order.setUsername(resultSet.getString("username"));
				order.setClientName(resultSet.getString("clientName"));
				order.setAddress(resultSet.getString("address"));
				order.setBooks(resultSet.getString("books"));
				order.setTotalprice(resultSet.getDouble("totalprice"));
				l.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(conn, pstmt, resultSet);
		}
		return l;
	}

	

}
