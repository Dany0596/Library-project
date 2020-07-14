package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class TerminalListener implements ActionListener {
	
	private TerminalView tv;
	private ArrayList<Book> refreshedBookList = new ArrayList<Book>();
	
	public TerminalListener (TerminalView tv, ArrayList<Book> refreshedBookList) {
		this.tv=tv;
		this.refreshedBookList=refreshedBookList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		
		if(button.getText().equals("LOGIN SCREEN")) {
		LoginView lv = new LoginView(refreshedBookList);
		tv.dispose();
		lv.setVisible(true);
		}

		if(button.getText().equals("CLOSE")) {
			tv.dispose();
		}
		
		if(button.getText().equals("RETURN TO SHOP")) {
			ShopView sv = new ShopView(tv.getUser(), refreshedBookList);
			tv.dispose();
			sv.setVisible(true);
		}
	}
	
	
	

}
