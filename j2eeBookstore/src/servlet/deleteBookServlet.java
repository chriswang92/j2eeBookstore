package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.proxy.BookDAOProxy;

/**
 * Servlet implementation class deleteBookServlet
 */
@WebServlet("/deleteBookServlet")
public class deleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =   request.getParameter("id");
		System.out.println(id);
		BookDAOProxy proxy = new BookDAOProxy();
		boolean result = proxy.deleteBookById(id);
		if(result){
			request.setAttribute("adminInfo", "book is successfully deleted");
		}else{
			request.setAttribute("adminInfo", "delete failed");
		}
		request.getRequestDispatcher("bookManage.jsp").forward(request, response);
	}

}
