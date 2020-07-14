package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;

public class RegisterListener implements ActionListener {

	private RegisterView rv;
	
	public RegisterListener (RegisterView rv) {
		this.rv = rv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		if(button.getText().equals("Return to Login")) {
					LoginView loginView = new LoginView(rv.getBookList());
					rv.dispose();
					loginView.setVisible(true);
			
		}
		
		if(button.getText().equals("Clear fields")) {
			rv.clearFields();
		}
		
		if(button.getText().equals("REGIST ME!")) {
			
			if(rv.somethingNull()) {
				rv.setErrorMsg("Missing info!");
				return;
			}
			
			String name = rv.getName();
			String surname = rv.getSurname();
			String address = rv.getAddress();
			String city = rv.getCity();
			String country = rv.getCountry();
			String telephone = rv.getTelephone();
			String email = rv.getEmail();
			String password = rv.getPassword();
			
			if(!(email.contains("@")&& email.contains("."))){
				rv.setErrorMsg("Can't process, Inavlid data");
				return;
			}
			
			if(rv.getCap().length()!=5 || !rv.getCap().matches("[0-9]+")){
				rv.setErrorMsg("Can't process, Inavlid data");
				return;
			}
			if(telephone.length()>13 && telephone.length()<8) {
				rv.setErrorMsg("Can't process, Inavlid data");
				return;
			}
			
			long n = new Date().getTime();
			int librocard = Math.abs((int) n); //TODO
			int cap = Integer.parseInt(rv.getCap());
			RegisteredUser ru = new RegisteredUser(name, surname, address, cap, city, country, telephone, email, password, librocard,0, new java.sql.Date(Calendar.getInstance().getTimeInMillis()) , false);
			
			final String query = "INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			//Connection con = DBController.DB_Connection();
			Connection con = DBController.getConnection();
			PreparedStatement pst;
			try {
			    pst = con.prepareStatement(query);
			    pst.setString(1, name);
			    pst.setString(2, surname);
			    pst.setString(3, address);
			    pst.setInt(4, cap);
			    pst.setString(5, city);
			    pst.setString(6, country);
			    pst.setString(7, telephone);
			    pst.setString(8, email);
			    pst.setString(9, password);
			    pst.setInt(10, librocard);
			    pst.setInt(11, 0);
			
			    pst.execute();
			    con.close();
			} catch (SQLException ex) {
			    System.out.println(ex);
			    return;
			}
			ShopView shopview = new ShopView(ru, rv.getBookList());
			shopview.setVisible(true);
				rv.dispose();
		}
		//ShopView shopview = new ShopView(user, rv.getBookList());
		//shopview.setVisible(true);
		
		// TODO Auto-generated method stub
		
	}

}
