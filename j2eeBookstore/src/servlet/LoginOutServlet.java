package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

/**
 * Servlet implementation class LoginOutServlet 退出登录的Servlet,注销
 */
@WebServlet("/LoginOutServlet")
public class LoginOutServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;  
	  
	    public void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {
	    	 
	        User user = (User) request.getSession().getAttribute("user");
	        String infoString = "User ["+user.getName()+"] logged out！";
        	request.setAttribute("infoString", infoString);
	        
	        HttpSession session = request.getSession(false);//防止创建Session  
	        if(session == null){  
	            response.sendRedirect("index.jsp");  
	            return;  
	        } 
	        session.removeAttribute("user");
	        session.removeAttribute("cartString");
	        request.getRequestDispatcher("index.jsp").forward(request, response);
	        //response.sendRedirect("index.jsp");
	    }  
	  
	    public void doPost(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	  
	    }  
	  
	}  
