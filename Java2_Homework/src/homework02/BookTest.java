package homework02;


class Book {
	private String bookName;
	private int bookPrice;
	private double bookDiscountRate;

	public Book() {
	}

	public Book(String bookName, int bookPrice, double bookDiscountRate) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDiscountRate = bookDiscountRate;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public double getBookDiscountRate() {
		return bookDiscountRate;
	}

	public void setBookDiscountRate(double bookDiscountRate) {
		this.bookDiscountRate = bookDiscountRate;
	}
	
	public double getDiscountBookPrice(){
		return this.bookDiscountRate*this.bookPrice;
	}
}

public class BookTest {
	public static void main(String[] args) {
		Book[] ob = new Book[]{
					new Book("SQL Plus", 50000,5.0),
					new Book("Java 2.0", 40000,3.0),
					new Book("JSP Servlet", 60000,6.0)
		};
		
		System.out.println("책이름\t\t 가격\t 할인률\t 할인된 가격");
		for(Book m:ob){ // foreach문은 클래스 임의의 면수명 : 객체
			System.out.println(m.getBookName()+"\t"+m.getBookPrice()+"\t"+m.getBookDiscountRate()+"%\t"+m.getDiscountBookPrice()+"원");
		}
	}
}
