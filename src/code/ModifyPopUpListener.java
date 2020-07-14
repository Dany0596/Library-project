package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
public class ModifyPopUpListener implements ActionListener{
	
	private ModifyPopUp mpu;
	private RegisteredUser user;
	
	public ModifyPopUpListener(ModifyPopUp mpu, RegisteredUser user) {
		this.mpu = mpu;
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton button = (JButton )e.getSource();
		
		// CONFIRM BUTTON
		if(button.getText().equals("Confirm")) {
			
			if(mpu.getName().matches(".*[0-9].*")) {
				mpu.setError("Invalid Name");
				return;
			}
			if(mpu.getSurname().matches(".*[0-9].*")) {
				mpu.setError("Invalid Surname");
				return;
			}

			if(!mpu.getTel().matches(".*[0-9].*")) {
				mpu.setError("Invalid Telephone Number");
				return;
			}
			
			if(!(mpu.getEmail().contains("@")&& mpu.getEmail().contains("."))){
				mpu.setError("Can't process, Inavlid data");
				return;
			}
			

			if(mpu.getCap().length()!=5){
				mpu.setError("Can't process, Inavlid data");
				return;
			}
			String oldEmail = mpu.getRegisteredUser().getEmail();
			Connection con = DBController.getConnection();
			PreparedStatement pst;
			String updateProfile = "UPDATE USERS SET name=?, surname=?, address=?, cap=?, city=?, country=?, telephone=?, email=?, password=? WHERE email=?";
			String updateOrderEmail = "UPDATE ORDERS SET email=? WHERE email=?";
			try{
				pst = con.prepareStatement(updateProfile);
				pst.setString(1, mpu.getName());
				pst.setString(2,mpu.getSurname());
				pst.setString(3,mpu.getAddress());
				pst.setInt(4,Integer.parseInt(mpu.getCap()));
				pst.setString(5,mpu.getCity());
				pst.setString(6, mpu.getCountry());
				pst.setString(7, mpu.getTel());
				pst.setString(8, mpu.getEmail());
				pst.setString(9, mpu.getPass());
				pst.setString(10, oldEmail);
				pst.execute();
				
				pst=con.prepareStatement(updateOrderEmail);
				pst.setString(1, mpu.getEmail());
				pst.setString(2, oldEmail);
				pst.execute();
				
				con.close();
				
				user.setAddress(mpu.getAddress());
				user.setName(mpu.getName());
				user.setSurname(mpu.getSurname());
				user.setCap(Integer.parseInt(mpu.getCap()));
				user.setCity(mpu.getCity());
				user.setTelephone(mpu.getTel());
				user.setEmail(mpu.getEmail());
				user.setPassword(mpu.getPass());
				mpu.getPv().refreshUser(user,mpu.getCart());
				}
				catch(NumberFormatException | SQLException nfe) {
					mpu.setError("Can't process, Inavlid data");
					return;
				}
				mpu.dispose();
			
		}

		if(button.getText().equals("Cancel")){
			mpu.dispose();
		}
	}

}
