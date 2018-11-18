package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import dao.proxy.OrderDAOProxy;

/**
 * Servlet implementation class finishOrderServlet
 */
@WebServlet("/finishOrderServlet")
public class finishOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public finishOrderServlet() {
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
		Order o = (Order)request.getSession().getAttribute("order");
		String orderid = String.valueOf(o.getId());
		OrderDAOProxy proxy = new OrderDAOProxy();
		boolean finishResult = proxy.finishOrder(orderid);
		request.getSession().setAttribute("finishResult", finishResult);
		//request.getRequestDispatcher("orderManage.jsp").forward(request, response);
		response.sendRedirect("orderManage.jsp");
	}

}
