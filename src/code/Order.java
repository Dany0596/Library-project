package code;
import java.util.Date;

public class Order {

	private int code;
	private Date order_day;
	private String books;
	private String email;
	private double bill;
	private String payment_metod;
	private String address;
	private String orderState;
	private int points;

	public Order(int code,Date order_day,String books,String email,double bill,String payment_metod,String address,String orderState, int points) {
		this.code=code;
		this.order_day=order_day;
		this.books=books;
		this.email=email;
		this.bill=bill;
		this.payment_metod=payment_metod;
		this.address=address;
		this.orderState=orderState;
		this.points=points;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getOrder_day() {
		return order_day;
	}

	public void setOrder_day(Date order_day) {
		this.order_day = order_day;
	}

	public String getBooks() {
		return books;
	}

	public void setBooks(String books) {
		this.books = books;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	public String getPayment_metod() {
		return payment_metod;
	}

	public void setPayment_metod(String payment_metod) {
		this.payment_metod = payment_metod;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}