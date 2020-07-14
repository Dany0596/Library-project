
package code;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RegisterView extends JFrame {

	/**
	 * 
	 */
	private JPanel registFrame;
	
	private Book book;
	private ArrayList<Book> BookList = new ArrayList<Book>();

	private int height = 900;
	private int width = 500;
	private int baseP = 100;
	private JPanel colorPanel2;
	private JLabel registLabel,
					nameLabel,
					cityLabel,
					capLabel,
					emailLabel,
					surnameLabel,
					addressLabel,
					telephoneLabel, 
					passLabel,
					passLabel2,
					tempLabel,
					tempLabel2,
					countryLabel;
		
	private JTextField 	nameField,
						surnameField,
						addressField,
						cityField,
						capField, 
						emailField,
						telephoneField,
						countryField;
	
	private JPasswordField 	passField,
						 	passCheckField;
	
	private JButton clearBtn,
					goonBtn,
					backBtn;
	private JLabel errorLabel;
	
	
	public RegisterView(ArrayList<Book> BookList) {
		this.BookList = BookList;
		
		initialize();
		
	}
	
	private void initialize() {
		setTitle("BOOKBUNKER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(baseP, baseP, baseP + height, baseP + width);
		setResizable(false);
		registFrame = new JPanel();
		registFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(registFrame);
		
		registFrame.setLayout(null);
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(312, 85, 169, 16);
		registFrame.add(nameLabel);
		nameLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		
		nameField = new JTextField();
		nameField.setBounds(310, 105, 329, 35);
		registFrame.add(nameField);
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		nameField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		nameField.setColumns(10);
		
		surnameLabel = new JLabel("Surname");
		surnameLabel.setBounds(653, 85, 120, 16);
		registFrame.add(surnameLabel);
		surnameLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		
		surnameField = new JTextField();
		surnameField.setBounds(651, 105, 330, 35);
		registFrame.add(surnameField);
		surnameField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		surnameField.setColumns(10);
		
		addressLabel = new JLabel("Address");
		addressLabel.setBounds(312, 165, 169, 16);
		registFrame.add(addressLabel);
		addressLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		
		addressField = new JTextField();
		addressField.setBounds(310, 185, 329, 35);
		registFrame.add(addressField);
		addressField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		addressField.setColumns(10);
		
		cityLabel = new JLabel("City");
		cityLabel.setBounds(653, 165, 172, 16);
		registFrame.add(cityLabel);
		cityLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		
		cityField = new JTextField();
		cityField.setBounds(651, 185, 176, 35);
		registFrame.add(cityField);
		cityField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		cityField.setColumns(10);
		
		capLabel = new JLabel("CAP");
		capLabel.setBounds(841, 165, 67, 16);
		registFrame.add(capLabel);
		capLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		
		capField = new JTextField();
		capField.setBounds(839, 185, 137, 35);
		registFrame.add(capField);
		capField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		capField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(310, 335, 329, 35);
		registFrame.add(emailField);
		emailField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		emailField.setColumns(10);
		
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(312, 315, 169, 16);
		registFrame.add(emailLabel);
		emailLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		
		telephoneField = new JTextField();
		telephoneField.setBounds(651, 335, 330, 35);
		registFrame.add(telephoneField);
		telephoneField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		telephoneField.setColumns(10);
		
		telephoneLabel = new JLabel("Telephone number");
		telephoneLabel.setBounds(653, 315, 172, 16);
		registFrame.add(telephoneLabel);
		telephoneLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		
		passLabel = new JLabel("Password");
		passLabel.setBounds(312, 395, 172, 16);
		registFrame.add(passLabel);
		passLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		
		passLabel2 = new JLabel("Confirm password");
		passLabel2.setBounds(484, 395, 172, 16);
		registFrame.add(passLabel2);
		passLabel2.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		
		passField = new JPasswordField();
		passField.setBounds(310, 415, 160, 35);
		registFrame.add(passField);
		passField.setToolTipText("");
		
		passCheckField = new JPasswordField();
		passCheckField.setBounds(482, 415, 160, 35);
		registFrame.add(passCheckField);
		
		
		colorPanel2 = new JPanel();
		colorPanel2.setBounds(6, 6, 284, 568);
		registFrame.add(colorPanel2);
		colorPanel2.setBackground(new Color(102, 153, 153));
		colorPanel2.setLayout(new BorderLayout());
		
		registLabel = new JLabel("REGISTRATION FORM");
		registLabel.setBounds(300, 6, 694, 50);
		registFrame.add(registLabel);
		registLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registLabel.setFont(new Font("Avenir", Font.PLAIN, 31));
		
		tempLabel = new JLabel("Password confirmed!");
		tempLabel.setForeground(new Color(51, 102, 153));
		tempLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		tempLabel.setBounds(314, 510, 172, 16);
		tempLabel.setVisible(false);
		registFrame.add(tempLabel);
		
		tempLabel2 = new JLabel("Password not match!");
		tempLabel2.setForeground(new Color(51, 102, 153));
		tempLabel2.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		tempLabel2.setBounds(314, 510, 172, 16);
		tempLabel2.setVisible(false);
		registFrame.add(tempLabel2);
		
		JButton fcheckBtn = new JButton("Fast Password Check");
		//TODO
		fcheckBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(passField.getText().equals(passCheckField.getText()) ) {
					tempLabel.setVisible(true);
					tempLabel2.setVisible(false);
					}
				else {
					tempLabel.setVisible(false);
					tempLabel2.setVisible(true);
				}
			}
		});
		
		fcheckBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		fcheckBtn.setBounds(312, 465, 329, 35);
		registFrame.add(fcheckBtn);
		
		goonBtn = new JButton("REGIST ME!");
		goonBtn.addActionListener(new RegisterListener(this));
		/*
		goonBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if(!(emailField.getText().contains("@")&&emailField.getText().contains("."))){
					errorLabel.setText("Can't process, Inavlid data");
					return;
				}
				
				if(capField.getText().length()!=5){
					errorLabel.setText("Can't process, Inavlid data");
					return;
				}
				
				if(!passField.getText().equals(passCheckField.getText())){
					errorLabel.setText("Can't process, Inavlid data");
					return;
				}
			
				if(!addressField.getText().matches(".*[0-9].*")) {
					errorLabel.setText("Can't process, Inavlid data");
					return;
				}
				String name = nameField.getText();
				String surname = surnameField.getText();
				String address = addressField.getText();
				String city = cityField.getText();
				String country = countryField.getText();
				String telephone = telephoneField.getText();
				String email = emailField.getText();
				String password = passField.getText();
				
				
				long n = new Date().getTime();
				int librocard = (int) n;
				int cap = Integer.parseInt(capField.getText());
				RegisteredUser ru = new RegisteredUser(name, surname, address, cap, city, country, telephone, email, password, librocard,0, new Date() , false);
				
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
		        ShopView shopview = new ShopView(ru, BookList);
				shopview.setVisible(true);
		        
				
				
				try{RegisteredUser user = new RegisteredUser(nameField.getText(), surnameField.getText(), addressField.getText(),
															Integer.parseInt(capField.getText()), cityField.getText(),countryField.getText(), telephoneField.getText(), 
															emailField.getText(), passField.getText(), 0);
				
				
				}
				catch(NumberFormatException nfe) {
					errorLabel.setText("Can't process, Inavlid data");
					return;
				}
				dispose();
			}
		});
		*/
		goonBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		goonBtn.setBounds(664, 416, 310, 35);
		registFrame.add(goonBtn);
		
		backBtn = new JButton("Return to Login");
		backBtn.addActionListener(new RegisterListener(this));
		backBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		backBtn.setBounds(824, 465, 150, 35);
		registFrame.add(backBtn);
		
		clearBtn = new JButton("Clear fields");
		clearBtn.addActionListener(new RegisterListener(this));
		clearBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		clearBtn.setBounds(664, 465, 150, 35);
		registFrame.add(clearBtn);
		
		countryField = new JTextField();
		countryField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		countryField.setColumns(10);
		countryField.setBounds(312, 260, 327, 35);
		registFrame.add(countryField);
		
		countryLabel = new JLabel("Country");
		countryLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		countryLabel.setBounds(314, 240, 142, 16);
		registFrame.add(countryLabel);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		errorLabel.setBounds(702, 511, 225, 16);
		registFrame.add(errorLabel);
		
		
	}
	
	public void setErrorMsg(String e) {
		errorLabel.setText(e);
	}
	public void clearFields() {
		
		nameField.setText(null);
		surnameField.setText(null);
		addressField.setText(null);
		capField.setText(null);
		emailField.setText(null);
		cityField.setText(null);
		passField.setText(null);
		passCheckField.setText(null);
		telephoneField.setText(null);
		tempLabel.setVisible(false);
		tempLabel2.setVisible(false);
		
	}

	@SuppressWarnings("deprecation")
	public boolean somethingNull() {
		if(nameField.getText().isEmpty() ||
				surnameField.getText().isEmpty()||
				addressField.getText().isEmpty()||
				capField.getText().isEmpty()||
				emailField.getText().isEmpty()||
				cityField.getText().isEmpty()||
				countryField.getText().isEmpty()||
				passField.getText().isEmpty()||
				telephoneField.getText().isEmpty())
		return true;
		else 
			return false;
	}

	public void setEmailField(String email) {
		emailField.setText(email);
	}
	public Book getBook() {
		return book;
	}
	public ArrayList<Book> getBookList(){
		return BookList;
	}

	public String getName() {
		
		return nameField.getText();
	}
	
	public String getEmail() {
		return emailField.getText();
	}

	public String getCap() {
		return capField.getText();
	}

	public String getCity() {
		return cityField.getText();
	}

	public String getCountry() {
		return countryField.getText();
	}

	public String getAddress() {
		return addressField.getText();
	}

	public String getSurname() {
		return surnameField.getText();
	}

	public String getTelephone() {
		return telephoneField.getText();
	}

	@SuppressWarnings("deprecation")
	public String getPassword() {
		return passField.getText();
	}
}
