package code;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class ModifyPopUp extends JFrame {

	private JPanel popUpPane, colorPane;
	private JLabel nameLabel, surnameLabel, addressLabel, emailLabel, cityLabel, capLabel, telLabel, passLabel, errorLabel;
	private JTextField nameField, surnameField, addressField, emailField, cityField, capField, telField;
	private JPasswordField passwordField;
	private JButton cancelBtn, confirmBtn;
	private ArrayList<Book> Cart = new ArrayList<Book>();
	private RegisteredUser user;
	private PrivateUserView pv;
	private JTextField countryField;
	
	public ModifyPopUp(RegisteredUser user, PrivateUserView pv, ArrayList<Book> Cart) {
		this.user = user;
		this.pv = pv;
		this.Cart=Cart;
		initialize();
	}

	private void initialize() {
		
		
		setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		setTitle("MODIFY YOUR INFORMATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 300);
		popUpPane = new JPanel();
		popUpPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(popUpPane);
		popUpPane.setLayout(null);
		
		colorPane = new JPanel();
		colorPane.setBackground(new Color(102, 153, 153));
		colorPane.setBounds(4, 4, 50, 268);
		popUpPane.add(colorPane);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		nameLabel.setBounds(66, 10, 94, 16);
		popUpPane.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(109, 4, 300, 26);
		popUpPane.add(nameField);
		nameField.setColumns(10);
		
		surnameLabel = new JLabel("Surname:");
		surnameLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		surnameLabel.setBounds(66, 44, 94, 16);
		popUpPane.add(surnameLabel);
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		surnameField.setBounds(129, 38, 280, 26);
		popUpPane.add(surnameField);
		
		addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		addressLabel.setBounds(66, 78, 94, 16);
		popUpPane.add(addressLabel);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(129, 72, 280, 26);
		popUpPane.add(addressField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(129, 206, 280, 26);
		popUpPane.add(emailField);
		
		emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		emailLabel.setBounds(66, 212, 94, 16);
		popUpPane.add(emailLabel);
		
		cityLabel = new JLabel("City:");
		cityLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		cityLabel.setBounds(66, 112, 94, 16);
		popUpPane.add(cityLabel);
		
		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(109, 106, 122, 26);
		popUpPane.add(cityField);
		
		capField = new JTextField();
		capField.setColumns(10);
		capField.setBounds(286, 106, 123, 26);
		popUpPane.add(capField);
		
		capLabel = new JLabel("CAP:");
		capLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		capLabel.setBounds(243, 112, 94, 16);
		popUpPane.add(capLabel);
		
		telLabel = new JLabel("Telephone:");
		telLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		telLabel.setBounds(66, 178, 94, 16);
		popUpPane.add(telLabel);
		
		telField = new JTextField();
		telField.setHorizontalAlignment(SwingConstants.LEFT);
		telField.setBounds(146, 173, 263, 26);
		popUpPane.add(telField);
		telField.setColumns(10);
		
		cancelBtn = new JButton("Cancel");
		/*cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});*/
		cancelBtn.addActionListener(new ModifyPopUpListener(this, user));
		cancelBtn.setForeground(new Color(255, 204, 102));
		cancelBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		cancelBtn.setBounds(438, 4, 117, 29);
		popUpPane.add(cancelBtn);
		
		confirmBtn = new JButton("Confirm");
		/*confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			if(!(emailField.getText().contains("@")&&emailField.getText().contains("."))){
				errorLabel.setText("Can't process, Inavlid data");
				return;
			}
			
			if(capField.getText().length()!=5){
				errorLabel.setText("Can't process, Inavlid data");
				return;
			}
		
			if(!addressField.getText().matches(".*\\d.*")) {
				errorLabel.setText("Can't process, Inavlid data");
				return;
			}
			
			try{
				
			user.setAddress(addressField.getText());
			user.setName(nameField.getText());
			user.setSurname(surnameField.getText());
			user.setCAP(Integer.parseInt(capField.getText()));
			user.setCity(cityField.getText());
			user.setTelephone(telField.getText());
			user.setEmail(emailField.getText());
			user.setPassword(passwordField.getText());
			
			pv.refreshUser(user);
			}
			catch(NumberFormatException nfe) {
				errorLabel.setText("Can't process, Inavlid data");
				return;
			}
			dispose();
			}
		});*/
		confirmBtn.addActionListener(new ModifyPopUpListener(this, user));
		confirmBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		confirmBtn.setForeground(new Color(0, 153, 153));
		confirmBtn.setBounds(438, 39, 117, 29);
		popUpPane.add(confirmBtn);
		
		passLabel = new JLabel("Password:");
		passLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		passLabel.setBounds(66, 236, 94, 16);
		popUpPane.add(passLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 232, 122, 26);
		popUpPane.add(passwordField);
		
		nameField.setText(user.getName());
		surnameField.setText(user.getSurname());
		addressField.setText(user.getAddress());
		cityField.setText(user.getCity());
		capField.setText(""+user.getCap());
		telField.setText(user.getTelephone());
		emailField.setText(user.getEmail());
		passwordField.setText(user.getPassword());
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(new Color(255, 51, 0));
		errorLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 15));
		errorLabel.setBounds(421, 80, 151, 16);
		popUpPane.add(errorLabel);
		
		JLabel countryLabel = new JLabel("Country:");
		countryLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		countryLabel.setBounds(66, 146, 94, 16);
		popUpPane.add(countryLabel);
		
		countryField = new JTextField();
		countryField.setText((String) null);
		countryField.setColumns(10);
		countryField.setBounds(134, 140, 122, 26);
		popUpPane.add(countryField);
	}
	
	public RegisteredUser getRegisteredUser() {
		return user;
	}
	
	public void setError(String err) {
		errorLabel.setText(err);
	}
	
	public String getEmail() {
		return emailField.getText();
	}


	public String getName() {
		return nameField.getText();
	}
	public String getCap() {
		return capField.getText();
	}
	
	public PrivateUserView getPv() {
		return pv;
	}

	public String getAddress() {
		return addressField.getText();
	}

	public String getSurname() {
		// TODO Auto-generated method stub
		return surnameField.getText();
	}

	public String getCity() {
		// TODO Auto-generated method stub
		return cityField.getText();
	}

	public String getTel() {
		// TODO Auto-generated method stub
		return telField.getText();
	}
	public String getCountry() {
		return countryField.getText();
	}

	public ArrayList<Book> getCart(){
		return Cart;
	}
	@SuppressWarnings("deprecation")
	public String getPass() {
		// TODO Auto-generated method stub
		return passwordField.getText();
	}
}
