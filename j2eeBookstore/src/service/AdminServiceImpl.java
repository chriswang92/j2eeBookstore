package service;

import java.util.List;

import bean.User;
import dao.proxy.UserDAOProxy;

public class AdminServiceImpl implements AdminService {

	UserDAOProxy userProxy = new UserDAOProxy();
	
	@Override
	public List<User> getAllUser()  {
		
			try {
				return userProxy.getAllUser();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}

}
