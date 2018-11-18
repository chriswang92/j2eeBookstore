package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import bean.Book;
import bean.User;
import dbc.DatabaseConnection;  
public class UserDAOImpI implements UserDAO{  
    private Connection conn=null;//定义数据库连接对象   
    private PreparedStatement pstmt=null;//定义数据库操作对象  
    public UserDAOImpI(Connection conn){ //设置数据库连接  
        this.conn=conn;  
    }  
    @Override  
    public boolean findLogin(User user) throws Exception {  
        boolean flag=false;  
        try {  
            String sql="select name from user where name=? and password=?";  
            pstmt=conn.prepareStatement(sql);//实例化操作  
            pstmt.setString(1,user.getName());  
            pstmt.setString(2, user.getPassword());  
            ResultSet rSet=pstmt.executeQuery();//取得结果   
            if(rSet.next()){  
                user.setName(rSet.getString(1));//取得用户名  
                flag=true;        
            }  
  
        } catch (Exception e) {  
            throw e;  
        }finally{  
            //关闭操作  
            if(pstmt!=null){  
                try {  
                    pstmt.close();  
                } catch (Exception e) {  
                    throw e;                  
                }         
            }  
              
        }  
        return flag;  
    }
    private java.sql.Statement sta = null;
	@Override
	public void insertUser(User user) throws Exception {
		try{
			sta = conn.createStatement();
			String sql = "insert into user(userid,name,password) values (null,'"+user.getName()+"','"+user.getPassword()+"');";
			sta.executeUpdate(sql);
		} catch(SQLException e){
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
		
	}
	
	@Override
	public void changePassword(String userName, String newPassword) throws Exception {
		try{
			 sta = conn.createStatement();
			 String sql="update user set password='"+newPassword+"' where name='"+userName+"'";  
			 sta.executeUpdate(sql);  
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
		
	}  
	
	private ResultSet resultSet = null;
	@Override
	public List<User> getAllUser() throws Exception  {
		List<User> users = new ArrayList<User>();
		try{
			String sql = "select * from user";
			pstmt = conn.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				User user = new User();
				user.setUserid(resultSet.getInt("userid"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
	            users.add(user);
			}
		
		} catch (Exception e) {
			throw e;
		} finally {
			DatabaseConnection.close(conn, pstmt, resultSet);
		}
		return users;
	}
	@Override
	public boolean deleteUserById(String id) {
		boolean result=false;
		try{
			sta = conn.createStatement();
			String sql = "delete from user where userid="+id;
			sta.executeUpdate(sql);
			result = true;
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
