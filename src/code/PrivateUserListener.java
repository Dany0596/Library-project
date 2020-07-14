package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PrivateUserListener implements ActionListener {
	
	private PrivateUserView puv;
	
	public PrivateUserListener (PrivateUserView puv) {
		this.puv=puv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		
		if(button.getText().equals("Modify")) {
			ModifyPopUp modpp = new ModifyPopUp(puv.getUser(), puv, puv.getCart());
			modpp.setVisible(true);
		}
		
		if(button.getText().equals("RETURN TO SHOP")) {
			puv.dispose();
			ShopView sv = new ShopView(puv.getUser(), puv.getBookList());
			sv.setCart(puv.getCart());
			sv.setVisible(true);
		}
		
	}
	
	
	

}
