package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import bean.User;
import dao.proxy.OrderDAOProxy;

/**
 * Servlet implementation class checkoutServlet
 */
@WebServlet("/checkoutServlet")
public class checkoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkoutServlet() {
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
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String clientName=firstname + " " + lastname;
		String address = request.getParameter("address") + 
							request.getParameter("postalcode");
		String phone = request.getParameter("phone");
		String creditcard = request.getParameter("creditcard");
		double totalprice = (double) request.getSession().getAttribute("total");
		List<String> infos = (List<String>) request.getSession().getAttribute("bookInfos");
		String books = "";
		for(String info:  infos){
			books += info;
			books += ";\n";
		}
		
		Order order = new Order();
		User user = (User) request.getSession().getAttribute("user");
		order.setUsername(user.getName());
		order.setClientName(clientName);
		order.setAddress(address);
		order.setTotalprice(totalprice);
		order.setBooks(books);
		
		OrderDAOProxy proxy = new OrderDAOProxy();
		boolean result = false;
		try {
			 result = proxy.addOrder(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String checkoutInfo = null;
		if(result){
			System.out.println("checkout success");
			checkoutInfo = "Congrats! Dear user: "+order.getUsername()+"your clientname in this order is: "
			+order.getClientName()
			+", have checkout successfully, books you bought:["+
					order.getBooks()+"] ,your total cost: "+order.getTotalprice();
		}else{
			System.out.println("checkout failed");
			checkoutInfo = "checkout failed";
		}
	    request.setAttribute("infoString", checkoutInfo);
	   
		request.getRequestDispatcher("welcome.jsp").forward(request,
					 response);
	}

}
