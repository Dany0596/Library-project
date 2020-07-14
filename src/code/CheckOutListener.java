package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

//Date, no istant, codice

import javax.swing.JButton;

public class CheckOutListener implements ActionListener{

	private CheckOutView cv;
	private ArrayList<Book> cart = new ArrayList<Book>();
	private ArrayList<Book> refreshedBookList = new ArrayList<Book>();
	
	public CheckOutListener(CheckOutView cv, ArrayList<Book> cart) {
		
		this.cv = cv;
		this.cart = cv.getCart();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		if(button.getText().equals("Modify Cart")) {

			CartPopUpFromOrder cp = new CartPopUpFromOrder(cv.getCart(), cv); //TODO
			cp.setVisible(true);
		}
		
		if(button.getText().equals("Return to Shop")) {
			ShopView sv = new ShopView(cv.getUser(), cv.getBookList());
			sv.setCart(cv.getCart());
			cv.dispose();
			sv.setVisible(true);
		}
		if(button.getText().contentEquals("CHECK OUT")) {
			
			if(cart.isEmpty()) {
				cv.setErrorMsg("No items in the cart!");
				return;
			}
			String titleRes="";
			String paymentMethod = cv.getPaymentMethod();
			
			Double bill = cv.totalPrice();
			if(paymentMethod.equals("Cachet"))
				bill += 5.00;
			
			int totalBP = cv.totalBPs();
			String address = cv.getDeliveryAddress();
			String email = cv.getUser().getEmail();
			
			long n = new Date().getTime();
			//long n = Instant.now().getEpochSecond();
			int code = Math.abs((int) n);
			
			final String updateCopiesQuery = "UPDATE BOOKS SET copies = ? WHERE BOOKS.ISBN = ?";
			final String addOrderQuery = "INSERT INTO ORDERS VALUES(?,?,?,?,?,?,?,?,?)";
			
			int userBps = totalBP + cv.getUser().getBookPoints();
			final String updateBPs = "UPDATE USERS SET bookPoints = ? WHERE USERS.email = ?";
			System.out.println(code);
			
			/*Connection con= DBController.getConnection();
			PreparedStatement pst2;
			//Order newOrder = new Order(code, new Date(), titleRes, email, bill, paymentMethod, address, "Processing", totalBP);
			try {
				pst2 = con.prepareStatement(addOrderQuery);
				pst2.setInt(1,code);
				pst2.setDate(2, null);
				pst2.setString(3, titleRes);
				pst2.setString(4,email);
				pst2.setDouble(5, bill);
				pst2.setString(6, paymentMethod);
				pst2.setString(7, address);
				pst2.setString(8,"processing");
				pst2.setInt(9,totalBP );
				pst2.execute();
				con.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				System.out.println("Adding order error");
				return;
			}
			
			for(Book x : cart) {
				
				titleRes +="["+ x.getTitle() + "]";
				int copies=x.getCopies();
				copies++;
				String isbn = x.getISBN();
				Connection con2 = DBController.getConnection();
				PreparedStatement pst ;
				try {
			        pst = con.prepareStatement(updateCopiesQuery);
			        pst.setInt(1, copies);
			        pst.setString(2,isbn);
			        pst.execute();
			        con2.close();
				}
				 catch (SQLException e1) {
					 System.out.println("Book sold Copies increment failed");
					 return;
				 }	
			}*/
			Connection con= DBController.getConnection();
			PreparedStatement pst;
			PreparedStatement pst2;
			PreparedStatement pst3;
			int copies=0;
			try {
				for(Book x : cart) {
					titleRes +="["+ x.getTitle() + "]";
					copies=x.getCopies();
					copies++;
					x.setCopies(copies);
					String isbn = x.getISBN();
				
			        pst = con.prepareStatement(updateCopiesQuery);
			        pst.setInt(1, copies);
			        pst.setString(2,isbn);
			        pst.execute();
				
				}
				//Order nOrder = new Order(code, new Date(), titleRes, email, bill, paymentMethod, address, "Processing", totalBP);
				pst2 = con.prepareStatement(addOrderQuery);
				pst2.setInt(1,code);
				pst2.setDate(2, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
				pst2.setString(3, titleRes);
				pst2.setString(4,email);
				pst2.setDouble(5, bill);
				pst2.setString(6, paymentMethod);
				pst2.setString(7, address);
				pst2.setString(8,"Processing");
				pst2.setInt(9,totalBP );
				pst2.execute();
					
				if(cv.getUser().getLibrocard()!=0) {
					pst3 = con.prepareStatement(updateBPs);
					pst3.setInt(1, userBps);
					pst3.setString(2, email);
					pst3.execute();
					cv.getUser().setBookPoints(userBps);
				}
				con.close();
			}
			 catch (SQLException e1) {
				 System.out.println( e1 + "Book sold Copies increment failed");
				 return;
			 }
			
			System.out.println(n);

			Connection con2 = DBController.getConnection();
			try {
	            Statement st = con2.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM BOOKS");

	            while (rs.next()) {
	            	Book book=new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),
	            					rs.getInt(8),rs.getString(9), rs.getInt(10),rs.getDate(11));
	            	refreshedBookList.add(book);
	            }
	            con.close();
			} catch (SQLException ex) {
				System.out.println("Book list creation FAILED");
			}
			Collections.sort(refreshedBookList, new Comparator<Book>() {
				public int compare(Book b1, Book b2) {
					int diff=b2.getCopies()-b1.getCopies();
					return diff;
				}
			});
			TerminalView tv = new TerminalView(cv.getUser(), code, refreshedBookList);
			cv.dispose();
			tv.setVisible(true);
			
			
		}
		
	}
	
}
