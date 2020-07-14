package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;

public class LoginListener implements ActionListener {

	private LoginView lv;
	private String email;
	private String pass;
	
	public LoginListener( LoginView lv) {
		this.lv = lv;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		email = lv.getEmail();
		pass = lv.getPass();
		
		//LOGIN BUTTON
		if(button.getText().equals("LOGIN")) { 
			
			try {
	    	  	//Connection con= DBController.DB_Connection();
				Connection con= DBController.getConnection();
                PreparedStatement pst = con.prepareStatement("SELECT * FROM USERS WHERE email =\'"+ email +"\' AND password =\'"+ pass +"\';");
                ResultSet rs = pst.executeQuery(); 
                if(rs.next()) {
                	RegisteredUser user = new RegisteredUser(rs.getString(1), rs.getString(2),
                			rs.getString(3),rs.getInt(4),rs.getString(5),
                			rs.getString(6), rs.getString(7), rs.getString(8), 
                			rs.getString(9), rs.getInt(10), rs.getInt(11),
                			rs.getDate(12), rs.getBoolean(13));
					ShopView sv = new ShopView(user, lv.getBookList());
					sv.setVisible(true);
					lv.dispose();
                }
                else {
                	lv.noLog();
                	}
	            con.close();
			} catch (SQLException ex) {
				lv.noLog();
	        	System.out.println("User finder failed");
	        }
			
			/*if(email.equals("f") && pass.equals("1")) {
					//RegisteredUser user = new RegisteredUser("Fabio", "Tarocco", "Via XXIV Maggio 59", 35057,"Verona","Italy", "3471840371", "fabiuzzo98@gmail.com", "123456", 777);
					ShopView sv = new ShopView(user, lv.getBookList());
					sv.setVisible(true);
					lv.dispose();
				}
			else
				lv.noLog();*/
		}
		
		//NOT REGISTERED BUTTON
		if(button.getText().equals("Not registered yet? Click here!")) {
			RegisterView rv = new RegisterView(lv.getBookList());
			rv.setEmailField(email);
			rv.setVisible(true);
			lv.dispose();
			
		}
		//GUEST BUTTON
		if(button.getText().equals("Go as Guest")) {
			ShopView sv = new ShopView(new RegisteredUser("Guest", null, null, 00000, null, null, null, null, null, 0, 0,null, false ),lv.getBookList());
			sv.setVisible(true);
			lv.dispose();
			
			
		}
	}
}
	
