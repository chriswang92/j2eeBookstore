package bean;

public class t {
	public static void main(String[] args){
		String price = "11.99";
		System.out.println(Double.valueOf(price));
		Book book = new Book(1,"a","a",11,"a");
		String sql = "insert into book(id,name,author,price,description,display) values (null,'"+book.getName()+"','"+book.getAuthor()+"',"+book.getPrice()+",'"+book.getDescription()+"',1);";
		System.out.println(sql);
	}
}
