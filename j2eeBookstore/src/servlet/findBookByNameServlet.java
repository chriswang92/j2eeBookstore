package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.proxy.BookDAOProxy;

/**
 * Servlet implementation class findBookByNameServlet
 */
@WebServlet("/findBookByNameServlet")
public class findBookByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findBookByNameServlet() {
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
		
		String name = request.getParameter("bookName");
		String idS = request.getParameter("id");
		Integer id = null;
		if(idS!=""){
			 id = Integer.valueOf(idS);
		}
		System.out.println(name);
		BookDAOProxy proxy = new BookDAOProxy();
		Book book = null;
		try {
			if(name==""){
				book = proxy.findBookByID(id);
			}
			else{
				book = proxy.findBook(name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String adminInfo=null;
		if(book!=null){
			System.out.println("find ok");
			adminInfo= "Book found: [ id:"+book.getId()+", bookname: "+ book.getName()+" ,author: " + book.getAuthor()+", price: "+book.getPrice()+", desc: "+book.getDescription()+" ]";
		}else{
			System.out.println("find failed");
			adminInfo="find failed";
		}
		 
		request.setAttribute("adminInfo", adminInfo);
		request.getRequestDispatcher("bookManage.jsp").forward(request, response);
	}

}
