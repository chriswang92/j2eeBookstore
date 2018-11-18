package dao;

import java.util.List;

import bean.Book;
import bean.User;

public interface BookDAO {

public List<Book> getAll() throws Exception;  
public Book findBook(String name) throws Exception;  
public Book findBookByID(Integer id) throws Exception;  
public boolean addBook(Book book);
public boolean changeBookPrice(String bookName,double price);
public boolean deleteBookById(String id);
public boolean stopSellBookStatusById(String id);
public boolean restartSellBookStatusById(String id);
public boolean changeBookPicture(String coverAddr, String id);
}
