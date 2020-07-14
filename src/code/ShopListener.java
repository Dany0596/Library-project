package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.JButton;



public class ShopListener implements ActionListener {

	private ShopView sv;
	private ArrayList<Order> OrderList = new ArrayList<Order>();
	private ArrayList<Book> BookList = new ArrayList<Book>();
	private ArrayList<Classifica> RankList = new ArrayList<Classifica>();
	public ShopListener(ShopView sv) {
		this.sv = sv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton button = (JButton)e.getSource();
		
		//LOG OUT BUTTON
		if(button.getText().equals("LOG OUT")) {
			LoginView lv = new LoginView(sv.getBookList());
			lv.setVisible(true);
			sv.dispose();
		}
		
		//YOUR PROFILE BUTTON
		if(button.getText().equals("YOUR PROFILE") && !sv.getLoggedUser().getName().equals("Guest")) {

			
			final String query = "SELECT * FROM ORDERS WHERE ORDERS.email=\'"+sv.getLoggedUser().getEmail()+"\'";
			Connection con = DBController.getConnection();
            try {
            	Statement st = con.createStatement();
            	
	            ResultSet rs = st.executeQuery(query);
	            while (rs.next()) {
	            	Order o = new Order(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
	            	OrderList.add(o);
	            }
	            con.close();
            }catch (SQLException e1) {
				System.out.println("Can't load all orders");
			}
			PrivateUserView puv = new PrivateUserView(sv.getLoggedUser(),sv.getBookList(),OrderList);
			puv.setVisible(true);
			puv.SetCart(sv.getCart());
			sv.dispose();
		}
		
		//ORDER SEARCH
		if(button.getText().equals("CHECK ORDER NUMBER") && sv.getLoggedUser().getName().equals("Guest")) {

			
			final String query = "SELECT * FROM ORDERS";
			Connection con = DBController.getConnection();
            try {
            	Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while (rs.next()) {
	            	Order o = new Order(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
	            	OrderList.add(o);
	            }
	            con.close();
            }catch (SQLException e1) {
				System.out.println("Can't load all orders");
			}
			SearchOrderPopUp sp = new SearchOrderPopUp(OrderList,sv.getLoggedUser().isMaster());
			sp.setVisible(true);
		}
		
		if(button.getText().equals("UPDATE RANKING") && sv.getLoggedUser().isMaster()) {
			//UPDATE DELLE CLASSIFICHE
			try {
				String isbn;
				String updateRanking="UPDATE RANK SET position=?, positionDate=DEFAULT WHERE isbn=? ";
				Connection con = DBController.getConnection();
				PreparedStatement pst;
				BookList=sv.getBookList();
				RankList=sv.getClassifica();
				String res="";
				for(Book x : BookList) {
					isbn= x.getISBN();
					for(Classifica y : RankList) {
						if(y.getISBN().equals(x.getISBN())){
							if(y.getPosizione()!= (BookList.indexOf(x) + 1)){
								res+="Updating C:"+ y.getISBN()+"\n";
								res+="From pos: " + y.getPosizione() +" to pos:" + (BookList.indexOf(x) + 1)+"\n";
								System.out.println("Updating C:"+ y.getISBN() +" B:"+x.getISBN());
								System.out.println("Da posizione C:" + y.getPosizione() +" a B:" + (BookList.indexOf(x) + 1));
								
								pst=con.prepareStatement(updateRanking);
								pst.setInt(1,BookList.indexOf(x) + 1 );
								pst.setString(2, x.getISBN());
								pst.execute();
								
								y.setPosizione(BookList.indexOf(x)+1); // TODO:
								y.setDate(new Date());
								
							}
						}
					}
				}
				sv.setUpdateText(res);
				
				sv.refreshClassifica(RankList);
				
				
			}catch(SQLException ex2) {
				System.out.println("Checking failed!" + ex2);
			}
			//Scrittura nel field dei libri aggiornati
		}
		
		//ALL ORDER SEARCH
		if(button.getText().equals("CHECK ALL ORDER") && sv.getLoggedUser().isMaster()) {
			
			final String query = "SELECT * FROM ORDERS";
			Connection con = DBController.getConnection();
            try {
            	Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while (rs.next()) {
	            	Order o = new Order(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
	            	OrderList.add(o);
	            }
	            con.close();
            }catch (SQLException e1) {
				System.out.println("Can't load all orders");
			}
			SearchOrderPopUp sp = new SearchOrderPopUp(OrderList,sv.getLoggedUser().isMaster());
			sp.setVisible(true);
		}

		if(button.getText().equals("CHECK ALL BOOKCARD") && !sv.getLoggedUser().getName().equals("Guest")) {
			BookCardPopUp sp = new BookCardPopUp();
			sp.setVisible(true);
		}
		
		
		//SHOW CART BUTTON
		if(button.getText().equals("SHOW CART")) {
			CartPopUpFromShop cp = new CartPopUpFromShop(sv.getCart(), sv);
			cp.setVisible(true);
		}
		
		//ADD TO CART BUTTON
		if(button.getText().equals("ADD TO CART")) {
			sv.getCart().add(sv.getSelectedBook());
		}
		
		//ADD BOOK BUTTON
		if(button.getText().equals("ADD NEW BOOK")) {
			AddPopUp ap = new AddPopUp(sv);
			ap.setVisible(true);
			
		}
		//CHECK OUT BUTTON
		if(button.getText().equals("CHECK OUT")){
			/*
			 *  Caricamento delle informazioni dell'utente registrato nel pannello di ordine
			 * altrimenti vengono aggiunte in seguito
			 */
			if(sv.getLoggedUser().getName().equals("Guest")) {
				//chiusura della shop view e passaggio del carrello nel pannello order
				CheckOutView rv = new CheckOutView(sv.getCart(), sv.getLoggedUser(), sv.getBookList());
				rv.setVisible(true);
				sv.dispose();
			}
			if(!sv.getLoggedUser().getName().equals("Guest")) {
				//chiusura della shop view e passaggio del carrello nel pannello order oltre alle informazioni del luser.

				CheckOutView rv = new CheckOutView(sv.getCart(), sv.getLoggedUser(), sv.getBookList());
				rv.setInfo();
				rv.setVisible(true);
				sv.dispose();
			}
			
		}
		
		
	}

}
