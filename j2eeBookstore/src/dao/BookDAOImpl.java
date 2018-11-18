package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Book;
import dbc.DatabaseConnection;

public class BookDAOImpl implements BookDAO {
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库操作对象
	private ResultSet resultSet = null;

	public BookDAOImpl(Connection conn) { // 设置数据库连接
		this.conn = conn;
	}

	@Override
	public List<Book> getAll() throws Exception {
		List<Book> books = new ArrayList<Book>();
		try{
			String sql = "select id,name,author,price,description from book where display=1";
			pstmt = conn.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				Book b = new Book();
				b.setId(resultSet.getInt("id"));
	            b.setName(resultSet.getString("name"));
	            b.setAuthor(resultSet.getString("author"));
	            b.setPrice(resultSet.getDouble("price"));
	            b.setDescription(resultSet.getString("description"));
	            books.add(b);
			}
		
		return books;
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseConnection.close(conn, pstmt, resultSet);
		}
	}

	@Override
	public Book findBook(String name) throws Exception {
		try {
			String sql = "select * from book where name=?";
			pstmt = conn.prepareStatement(sql);// 实例化操作
			pstmt.setString(1, name);
			resultSet = pstmt.executeQuery();// 取得结果
			if (resultSet.next()) {
				Book b = new Book();
				b.setId(resultSet.getInt("id"));
				b.setName(resultSet.getString("name"));
				b.setAuthor(resultSet.getString("author"));
				b.setPrice(resultSet.getDouble("price"));
				b.setDescription(resultSet.getString("description"));
				return b;
			}
			return null;

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseConnection.close(conn, pstmt, resultSet);
		}
	}

	@Override
	public Book findBookByID(Integer id) throws Exception {
		try {
			String sql = "select * from book where id=?";
			pstmt = conn.prepareStatement(sql);// 实例化操作
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();// 取得结果
			if (resultSet.next()) {
				Book b = new Book();
				b.setId(resultSet.getInt("id"));
				b.setName(resultSet.getString("name"));
				b.setAuthor(resultSet.getString("author"));
				b.setPrice(resultSet.getDouble("price"));
				b.setDescription(resultSet.getString("description"));
				return b;
			}
			return null;

		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseConnection.close(conn, pstmt, resultSet);
		}
	}
	private java.sql.Statement sta = null;
	@Override
	public boolean addBook(Book book) {
		boolean result = false;
		try {
			sta = conn.createStatement();
			String sql = "insert into book(id,name,author,price,description,display) values (null,'"+book.getName()+"','"+book.getAuthor()+"',"+book.getPrice()+",'"+book.getDescription()+"',1);";
			sta.executeUpdate(sql);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(sta != null){
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
	public boolean changeBookPrice(String bookName,double price) {
		boolean result = false;
		try{
			 sta = conn.createStatement();
			 String sql="update book set price='"+price+"' where name='"+bookName+"';";  
			
			 sta.executeUpdate(sql);  
			 result=true;
		} catch(SQLException e){
			e.printStackTrace();
		} finally{  
           //关闭操作  
           if(sta!=null){  
               try {  
                   conn.close();  
               } catch (Exception e) {  
                   e.printStackTrace();                
               }         
           }  
             
       }  
		return result;
	}

	@Override
	public boolean deleteBookById(String id) {
		boolean result = false;
		try{
			sta = conn.createStatement();
			System.out.println(id);
			
			String sql = "delete from book where id="+ id;
			System.out.println(sql);
			sta.executeUpdate(sql);
			result=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sta!=null){
				try{
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public boolean stopSellBookStatusById(String id) {
		boolean result = false;
		try{
			sta = conn.createStatement();
			String sql = "update book set display=0 where id="+id;
			sta.executeUpdate(sql);
			result=true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sta!=null){
				try{
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public boolean restartSellBookStatusById(String id) {
		boolean result = false;
		try{
			sta = conn.createStatement();
			String sql = "update book set display=1 where id="+id;
			sta.executeUpdate(sql);
			result=true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sta!=null){
				try{
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public boolean changeBookPicture(String coverAddr, String id) {
		boolean result = false;
		try{
			sta = conn.createStatement();
			String sql="update book set description='"+coverAddr+"' where id="+id;
			sta.executeUpdate(sql);
			result=true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sta!=null){
				try{
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
