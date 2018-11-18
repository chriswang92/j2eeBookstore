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
 * Servlet implementation class changeBookInfoServlet
 */
@WebServlet("/changeBookInfoServlet")
public class changeBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeBookInfoServlet() {
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
		String bookName = request.getParameter("bookName");
		String id = request.getParameter("id");
		String newprice = request.getParameter("price");
		Double newpricen = null;
		if(newprice!=null){
			newpricen = Double.valueOf(newprice);
		}
		String coverAddr = request.getParameter("cover");
		BookDAOProxy proxy = new BookDAOProxy();
		boolean priceChangeResult = false;
		if(bookName !=null && newprice!= null){
			try {
				priceChangeResult = proxy.changeBookPrice(bookName, newpricen);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		boolean pictureChangeResult = false;
		if(coverAddr != null && id!=null){
			try {
				pictureChangeResult = proxy.changeBookPicture(coverAddr, id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String adminInfo = null;
		if(priceChangeResult){
			System.out.println("change book price success");
			adminInfo = "Book:[ "+bookName+" ]'s price has been changed  successfully";
		}
		if(!priceChangeResult){
			System.out.println("change book price failed");
			adminInfo = "change book price failed";
		}
		if(pictureChangeResult){
			System.out.println("change book cover success");
			adminInfo = "Book id:[ "+id+" ]'s cover has been changed  successfully";
		}
		if(!pictureChangeResult){
			System.out.println("change book cover failed");
			adminInfo = "change book cover failed";
		}
	    request.setAttribute("adminInfo", adminInfo);
		request.getRequestDispatcher("bookManage.jsp").forward(request,
					 response);
	}

}
