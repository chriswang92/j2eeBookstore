package dao;

import java.util.List;

import bean.User;  
public interface UserDAO {  
/** 
 * 用户登录验证 
 * @param user传入vo对象 
 * @return 验证的操作结果  
 * @throws Exception 
 */  
public boolean findLogin(User user) throws Exception;  
public void insertUser(User user) throws Exception;  
public void changePassword(String userName, String newPassword) throws Exception;
public List<User> getAllUser() throws Exception;
public boolean deleteUserById(String id);
} 
