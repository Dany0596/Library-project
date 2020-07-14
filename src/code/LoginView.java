package code;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private Book book;
	private ArrayList<Book> BookList = new ArrayList<Book>();
	private JPanel contentPane,colorPanel,loginPanel;
	private JLabel welcomeLabel, emailLabel,passLabel, errorLabel,iconLabel ;
	private JTextField emailField;
	private JPasswordField passField;
	private JSeparator separator;
	private JButton registBtn,loginBtn,guestBtn;
	
	//cambiato da book a booklist
	public LoginView(ArrayList<Book> BookList) {
		//this.book = bookList;
		this.BookList= BookList; 
		initialize();
	}
	
	private void initialize() {
		
		
		setTitle("BOOKBUNKER");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 463);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginPanel = new JPanel();
		loginPanel.setBounds(5, 5, 632, 431);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		colorPanel = new JPanel();
		colorPanel.setBackground(new Color(102, 153, 153));
		colorPanel.setBounds(0, 0, 317, 431);
		loginPanel.add(colorPanel);
		colorPanel.setLayout(new BorderLayout());
		
		iconLabel = new JLabel("");
		iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		iconLabel.setIcon(new ImageIcon(LoginView.class.getResource("/other/Schermata 2019-09-04 alle 13.54.19.png")));
		
		colorPanel.add(iconLabel );
		
		separator = new JSeparator();
		separator.setBounds(317, 0, 0, 431);
		loginPanel.add(separator);
		
		welcomeLabel = new JLabel("BOOKBUNKER");
		welcomeLabel.setForeground(new Color(0, 0, 0));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Avenir", Font.BOLD, 31));
		welcomeLabel.setBounds(329, 18, 285, 52);
		loginPanel.add(welcomeLabel);
		
		emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		emailLabel.setBounds(333, 82, 61, 16);
		loginPanel.add(emailLabel);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		emailField.setHorizontalAlignment(SwingConstants.LEFT);
		emailField.setBounds(329, 110, 285, 35);
		loginPanel.add(emailField);
		emailField.setColumns(10);
		
		passLabel = new JLabel("Password");
		passLabel.setToolTipText("Password errata");
		passLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		passLabel.setBounds(333, 159, 104, 16);
		loginPanel.add(passLabel);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		passField.setHorizontalAlignment(SwingConstants.LEFT);
		passField.setBounds(329, 187, 156, 35);
		loginPanel.add(passField);
		
		registBtn = new JButton("Not registered yet? Click here!");//TODO
		/*registBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				RegisterView registView = new RegisterView(book);
				registView.setVisible(true);
				contentPane.setVisible(false);
			}
		});*/
		registBtn.addActionListener(new LoginListener(this));
		
		registBtn.setForeground(new Color(0, 153, 153));
		registBtn.setBounds(329, 271, 285, 29);
		loginPanel.add(registBtn);
		registBtn.setBorder(null);
		registBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		
		loginBtn = new JButton("LOGIN");
		/*loginBtn.addActionListener(new ActionListener() {//
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(emailField.getText().equals("fabiuzzo98@gmail.com") && passField.getText().equals("123456")) {
					errorLabel.setText("");
					ShopView shopView = new ShopView(emailField.getText(),book);
					shopView.setVisible(true);
					
					emailField.setText(null);
					passField.setText(null);
					
					dispose();
				}
				else {
					errorLabel.setText("Email or Password is incorrect!");
				}
			}
		});*/
		loginBtn.addActionListener(new LoginListener (this));
		
		loginBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		loginBtn.setBounds(497, 188, 117, 34);
		loginPanel.add(loginBtn);
		
		guestBtn = new JButton("Go as Guest");
		/*guestBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopView shopview = new ShopView("Guest", book);
				dispose();
				shopview.setVisible(true);
			}
		});*/
		guestBtn.addActionListener(new LoginListener(this));
		
		guestBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		guestBtn.setBounds(371, 312, 203, 29);
		loginPanel.add(guestBtn);
		
		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 15));
		errorLabel.setForeground(new Color(255, 51, 153));
		errorLabel.setBounds(331, 229, 283, 30);
		loginPanel.add(errorLabel);
	}
	
	public String getEmail() {
		return emailField.getText();
	}
	@SuppressWarnings("deprecation")
	public String getPass() {
		return passField.getText();
	}
	public Book getBook() {
		return book;
	}
	public ArrayList<Book> getBookList(){
		return BookList;
	}
	
	public void noLog() {
		emailField.setText(null);
		passField.setText(null);
		errorLabel.setText("Email or Password is incorrect!");
	}
	
} 
