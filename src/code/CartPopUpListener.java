package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CartPopUpListener implements ActionListener{
	
	JFrame cp;
	
	public CartPopUpListener (JFrame cp) {
		this.cp = cp;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		//CLEAR CART BUTTON
		if(cp instanceof CartPopUpFromOrder) {
			if(button.getText().equals("Clear Cart")) {
				((CartPopUpFromOrder) cp).clearCart();
			}
			
			//RETURN BUTTON
			if(button.getText().equals("Return")) {
				cp.dispose();
			}
			
			//REMOVE BOOK FROM CART BUTTON
			if(button.getText().equals("Remove selected item")){
				((CartPopUpFromOrder) cp).removeItem(((CartPopUpFromOrder) cp).getSelectedItem());
			}
		}
		if(cp instanceof CartPopUpFromShop) {
			if(button.getText().equals("Clear Cart")) {
				((CartPopUpFromShop) cp).clearCart();
			}
			
			//RETURN BUTTON
			if(button.getText().equals("Return")) {
				cp.dispose();
			}
			
			//REMOVE BOOK FROM CART BUTTON
			if(button.getText().equals("Remove selected item")){
				((CartPopUpFromShop) cp).removeItem(((CartPopUpFromShop) cp).getSelectedItem());
			}
		}
		
	}

}
