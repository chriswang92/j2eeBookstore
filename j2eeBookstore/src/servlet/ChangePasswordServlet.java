package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.proxy.UserDAOProxy;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newPassword = request.getParameter("newPassword");
		 //userName = request.getParameter("userName");
		User user = (User) request.getSession().getAttribute("user");
		String userName = user.getName();
		UserDAOProxy proxy = new UserDAOProxy();
		if(newPassword!="" && newPassword!=null){
			try {
				proxy.changePassword(userName, newPassword);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("password changed success");
		String infoString = "User，["+userName+"] password has changed, please sign in again！";
    	request.setAttribute("infoString", infoString);
		request.getRequestDispatcher("Login.jsp").forward(request,
				 response);
		}else{
			String infoString = "newpassword can not be empty!";
	    	request.setAttribute("infoString", infoString);
			request.getRequestDispatcher("changePassword.jsp").forward(request,
					 response);
		}
		
	}

}
