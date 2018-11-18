package dao.proxy;

import dao.BookDAO;  
import dao.BookDAOImpl;
import dbc.DatabaseConnection;

import java.util.List;

import bean.Book;
import bean.User;  

public class BookDAOProxy implements BookDAO{  
    private DatabaseConnection dbc=null;//定义数据库连接  
    private BookDAO dao=null;//定义DAO接口  
    public BookDAOProxy(){  
        try {  
            dbc=new DatabaseConnection();//实例化数据库连接  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        dao=new BookDAOImpl(dbc.getConnection());  
          
    }  
   
	@Override
	public List<Book> getAll() throws Exception {
		List<Book> books = null;
		 try {  
	            books=dao.getAll();//调用真实主题  
	        } catch (Exception e) {  
	            throw e;  
	        }finally{  
	            dbc.close();  
	        }  
		return books;
	}
	@Override
	public Book findBook(String name) throws Exception {
		Book book = null;
		try	{
			book = dao.findBook(name);
		} catch(Exception e){
			throw e;
		} finally{
			dbc.close();
		}
		return book;
	}

	@Override
	public Book findBookByID(Integer id) throws Exception {
		Book book = null;
		try	{
			book = dao.findBookByID(id);
		} catch(Exception e){
			throw e;
		} finally{
			dbc.close();
		}
		return book;
	}

	@Override
	public boolean addBook(Book book) {
		try	{
			return dao.addBook(book);
		} catch(Exception e){
			throw e;
		} finally{
			dbc.close();
		}
	}

	@Override
	public boolean changeBookPrice(String bookName, double price) {
		try	{
			return dao.changeBookPrice(bookName, price);
		} catch(Exception e){
			throw e;
		} finally{
			dbc.close();
		}
	}

	@Override
	public boolean deleteBookById(String id) {
		try{
			return dao.deleteBookById(id);
		}catch(Exception e){
			throw e;
		}finally{
			dbc.close();
		}
	}

	@Override
	public boolean stopSellBookStatusById(String id) {
		try{
			return dao.stopSellBookStatusById(id);
		}catch(Exception e){
			throw e;
		}finally{
			dbc.close();
		}
	}

	@Override
	public boolean restartSellBookStatusById(String id) {
		try{
			return dao.restartSellBookStatusById(id);
		}catch(Exception e){
			throw e;
		}finally{
			dbc.close();
		}
	}

	@Override
	public boolean changeBookPicture(String coverAddr, String id) {
		try{
			return dao.changeBookPicture(coverAddr, id);
		}catch(Exception e){
			throw e;
		}finally{
			dbc.close();
		}
	} 
  
}  
