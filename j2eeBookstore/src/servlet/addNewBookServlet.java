package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.User;
import dao.proxy.BookDAOProxy;
import dao.proxy.UserDAOProxy;

/**
 * Servlet implementation class addNewBookServlet
 */
@WebServlet("/addNewBookServlet")
public class addNewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNewBookServlet() {
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
		// TODO Auto-generated method stub
		
				String bookName = request.getParameter("bookName");
				String author = request.getParameter("author");
				String price = request.getParameter("price");
				double pricen = Double.valueOf(price);
				String desc = request.getParameter("desc");
				Book book = new Book();
				book.setName(bookName);
				book.setAuthor(author);
				book.setPrice(pricen);
				book.setDescription(desc);
				BookDAOProxy proxy = new BookDAOProxy();
				boolean result = false;
				//注册步骤
				try {
					 result = proxy.addBook(book);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String adminInfo = null;
				if(result){
					System.out.println("add book success");
					adminInfo = "Book:[ "+book.getName()+" ] has been added  successfully";
				}else{
					System.out.println("add book failed");
					adminInfo = "add book failed";
				}
			    request.setAttribute("adminInfo", adminInfo);
				request.getRequestDispatcher("bookManage.jsp").forward(request,
							 response);
	}

}
