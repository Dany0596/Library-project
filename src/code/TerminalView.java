package code;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TerminalView extends JFrame {

	private JPanel popUpPane, colorPane;
	private JButton backShopViewBtn,disposeBtn,logoutBtn;
	private JLabel lblYourOrderNumber,msgLabel;
	private RegisteredUser user;
	private int orderNumber;
	private ArrayList<Book> refreshedBookList = new ArrayList<Book>();
	
	public TerminalView(RegisteredUser user, int orderNumber, ArrayList<Book> refreshedBookList) {
		setResizable(false);
		this.user = user;
		this.orderNumber = orderNumber;
		this.refreshedBookList = refreshedBookList;
		initialize();
	}

	private void initialize() {
		
		
		setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		setTitle("ORDER COMPLETED");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 200);
		popUpPane = new JPanel();
		popUpPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(popUpPane);
		popUpPane.setLayout(null);
		
		colorPane = new JPanel();
		colorPane.setBackground(new Color(102, 153, 153));
		colorPane.setBounds(4, 4, 50, 168);
		popUpPane.add(colorPane);
		
		msgLabel = new JLabel("Thanks for your order!");
		msgLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 19));
		msgLabel.setBounds(59, 17, 408, 52);
		popUpPane.add(msgLabel);
		if(user.getName().equals("Guest"))
			msgLabel.setText("Thanks for your order!");
		if(!user.getName().equals("Guest"))
			msgLabel.setText("Thanks for your order, " +user.getName() + "!");
		
		lblYourOrderNumber = new JLabel("Your order number is: " + orderNumber);
		lblYourOrderNumber.setFont(new Font("Lantinghei TC", Font.PLAIN, 19));
		lblYourOrderNumber.setBounds(59, 60, 408, 52);
		popUpPane.add(lblYourOrderNumber);
		
		logoutBtn = new JButton("LOGIN SCREEN");
		logoutBtn.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		logoutBtn.setBounds(59, 124, 150, 29);
		logoutBtn.addActionListener(new TerminalListener(this, refreshedBookList));
		popUpPane.add(logoutBtn);
		
		backShopViewBtn = new JButton("RETURN TO SHOP");
		backShopViewBtn.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		backShopViewBtn.setBounds(207, 124, 150, 29);

		backShopViewBtn.addActionListener(new TerminalListener(this, refreshedBookList));
		popUpPane.add(backShopViewBtn);
		
		disposeBtn = new JButton("CLOSE");
		disposeBtn.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		disposeBtn.setBounds(354, 124, 150, 29);
		disposeBtn.addActionListener(new TerminalListener(this, refreshedBookList));
		popUpPane.add(disposeBtn);
	}
	
	public RegisteredUser getUser() {
		return user;
	}
}
