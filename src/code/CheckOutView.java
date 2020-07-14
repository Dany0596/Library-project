
package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CheckOutView extends JFrame {

	/**
	 * 
	 */
	private JPanel 	checkOutFrame;

	private Panel paymentPanel, cachetPanel, paypalPanel;
	
	private ArrayList<Book> cart = new ArrayList<Book>();
	private RegisteredUser user;
	private Book book;
	private ArrayList<Book> BookList = new ArrayList<Book>();

	private int baseP = 100;
	private JPanel colorPanel2;
	private JScrollPane tablePane;
	private DefaultComboBoxModel<String> comboCCModel, comboPModel;
	private final String[] paymentString = {"Credit/Debit Card", "Cachet", "PayPal"};
	private final String[] ccString = {"Visa", "Maestro", "MasterCard"};
	
	
	private JLabel registLabel,
					nameLabel,
					cityLabel,
					capLabel,
					emailLabel,
					surnameLabel,
					addressLabel,
					telephoneLabel,
					ccSecLbl,
					ccExpLbl,
					ccNLbl,
					ccTypeLbl,
					countryLbl,
					ccOwnerLabel,
					BillLbl,
					paymentLbl,
					errorLbl;
		
	private JTextField 	nameField,
						surnameField,
						addressField,
						cityField,
						capField, 
						emailField,
						telephoneField,
						ccNField,
						countryField,
						ccExpField,
						ccSecField,
						ccOwnerField;
	private JTextArea cachetText;
	
	private JButton chkCartBtn,
					goonBtn,
					backBtn;
	
	private JTable cartTable;
	private JComboBox<String> comboCCBox, comboPBox;
	private JLabel bpsLbl;
	
	
	public CheckOutView(ArrayList<Book> cart, RegisteredUser user, ArrayList<Book> BookList) {
		this.cart = cart;
		this.user = user;
		this.BookList = BookList;
		initialize();
			
		
	}
	
	private void initialize() {
		
		
		//VIEW SETTING 
		setTitle("BOOKBUNKER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(baseP, baseP, 1000, 490);
		setResizable(false);
		checkOutFrame = new JPanel();
		checkOutFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(checkOutFrame);
		
		checkOutFrame.setLayout(null);
		
		//PANEL
		
		paymentPanel = new Panel();
		paymentPanel.setBounds(706, 110, 288, 225);
		checkOutFrame.add(paymentPanel);
		paymentPanel.setLayout(null);
		paymentPanel.setVisible(true);

		paypalPanel = new Panel();
		paypalPanel.setBounds(706, 110, 288, 225);
		checkOutFrame.add(paypalPanel);
		paypalPanel.setLayout(null);
		paypalPanel.setVisible(true);
		
		cachetPanel = new Panel();
		cachetPanel.setBounds(706, 110, 288, 225);
		checkOutFrame.add(cachetPanel);
		cachetPanel.setLayout(null);
		cachetPanel.setVisible(true);
		
		
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(168, 60, 169, 16);
		checkOutFrame.add(nameLabel);
		nameLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		
		nameField = new JTextField();
		nameField.setBounds(164, 80, 232, 25);
		checkOutFrame.add(nameField);
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		nameField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		nameField.setColumns(10);
		
		surnameLabel = new JLabel("Surname");
		surnameLabel.setBounds(168, 120, 120, 16);
		checkOutFrame.add(surnameLabel);
		surnameLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		
		surnameField = new JTextField();
		surnameField.setBounds(164, 140, 232, 25);
		checkOutFrame.add(surnameField);
		surnameField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		surnameField.setColumns(10);
		
		addressLabel = new JLabel("Address");
		addressLabel.setBounds(168, 240, 169, 16);
		checkOutFrame.add(addressLabel);
		addressLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		
		addressField = new JTextField();
		addressField.setBounds(164, 260, 232, 25);
		checkOutFrame.add(addressField);
		addressField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		addressField.setColumns(10);
		
		cityLabel = new JLabel("City");
		cityLabel.setBounds(168, 300, 82, 16);
		checkOutFrame.add(cityLabel);
		cityLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		
		cityField = new JTextField();
		cityField.setBounds(164, 320, 124, 25);
		checkOutFrame.add(cityField);
		cityField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		cityField.setColumns(10);
		
		capLabel = new JLabel("CAP");
		capLabel.setBounds(302, 300, 67, 16);
		checkOutFrame.add(capLabel);
		capLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		
		capField = new JTextField();
		capField.setBounds(300, 320, 96, 25);
		checkOutFrame.add(capField);
		capField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		capField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(164, 373, 232, 25);
		checkOutFrame.add(emailField);
		emailField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		emailField.setColumns(10);
		
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(168, 353, 169, 16);
		checkOutFrame.add(emailLabel);
		emailLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		
		telephoneField = new JTextField();
		telephoneField.setBounds(164, 430, 232, 25);
		checkOutFrame.add(telephoneField);
		telephoneField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		telephoneField.setColumns(10);
		
		telephoneLabel = new JLabel("Telephone number");
		telephoneLabel.setBounds(168, 410, 172, 16);
		checkOutFrame.add(telephoneLabel);
		telephoneLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		
		countryField = new JTextField();
		countryField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		countryField.setColumns(10);
		countryField.setBounds(164, 200, 232, 25);
		checkOutFrame.add(countryField);
		
		countryLbl = new JLabel("Country");
		countryLbl.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		countryLbl.setBounds(168, 180, 169, 16);
		checkOutFrame.add(countryLbl);
		
		colorPanel2 = new JPanel();
		colorPanel2.setBounds(6, 6, 150, 456);
		checkOutFrame.add(colorPanel2);
		colorPanel2.setBackground(new Color(102, 153, 153));
		colorPanel2.setLayout(new BorderLayout());
		
		registLabel = new JLabel("ORDER CHECK OUT");
		registLabel.setBounds(158, 6, 788, 50);
		checkOutFrame.add(registLabel);
		registLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registLabel.setFont(new Font("Avenir", Font.PLAIN, 31));
		
		ccTypeLbl = new JLabel("Credit Circuit");
		ccTypeLbl.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		ccTypeLbl.setBounds(8, 65, 169, 16);
		paymentPanel.add(ccTypeLbl);
		
		ccNField = new JTextField();
		ccNField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		ccNField.setColumns(10);
		ccNField.setBounds(8, 133, 272, 25);
		paymentPanel.add(ccNField);
		
		ccNLbl = new JLabel("Credit Card Number");
		ccNLbl.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		ccNLbl.setBounds(10, 114, 169, 16);
		paymentPanel.add(ccNLbl);
		
		ccExpField = new JTextField();
		ccExpField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		ccExpField.setColumns(10);
		ccExpField.setBounds(8, 189, 123, 25);
		paymentPanel.add(ccExpField);
		
		ccExpLbl = new JLabel("Expiration Date");
		ccExpLbl.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		ccExpLbl.setBounds(10, 170, 121, 16);
		paymentPanel.add(ccExpLbl);
		
		ccSecField = new JTextField();
		ccSecField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		ccSecField.setColumns(10);
		ccSecField.setBounds(157, 189, 123, 25);
		paymentPanel.add(ccSecField);
		
		ccSecLbl = new JLabel("Security Number");
		ccSecLbl.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		ccSecLbl.setBounds(159, 170, 121, 16);
		paymentPanel.add(ccSecLbl);
		
		ccOwnerField = new JTextField();
		ccOwnerField.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		ccOwnerField.setColumns(10);
		ccOwnerField.setBounds(6, 28, 274, 25);
		paymentPanel.add(ccOwnerField);
		
		ccOwnerLabel = new JLabel("Owner");
		ccOwnerLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		ccOwnerLabel.setBounds(8, 9, 169, 16);
		paymentPanel.add(ccOwnerLabel);
		
		comboCCModel = new DefaultComboBoxModel<String>(ccString);
		comboCCBox = new JComboBox<String>(comboCCModel);
		comboCCBox.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		comboCCBox.setMaximumRowCount(3);
		comboCCBox.setBounds(6, 82, 125, 27);
		paymentPanel.add(comboCCBox);
		
		
		tablePane = new JScrollPane();
		tablePane.setBounds(405, 60, 295, 313);
		checkOutFrame.add(tablePane);
		
		
		DefaultTableModel tableModel = InitializeTable(cart);
		cartTable = new JTable(tableModel);
		tablePane.setViewportView(cartTable);
		cartTable.setBackground(new Color(204, 204, 204));
		cartTable.setBackground(new Color(255, 255, 255));
		cartTable.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		tablePane.setViewportView(cartTable);
		cartTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);		
		
		BillLbl = new JLabel("Total: " + String.format(" %.2f ", totalPrice()) +"€");
		BillLbl.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		BillLbl.setBounds(408, 385, 183, 16);
		checkOutFrame.add(BillLbl);
		
		chkCartBtn = new JButton("Modify Cart");
		chkCartBtn.setBounds(716, 404, 123, 35);
		checkOutFrame.add(chkCartBtn);
		chkCartBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		
		backBtn = new JButton("Return to Shop");
		backBtn.setBounds(844, 404, 150, 35);
		checkOutFrame.add(backBtn);
		backBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		
		goonBtn = new JButton("CHECK OUT");
		goonBtn.setBounds(716, 369, 274, 35);
		checkOutFrame.add(goonBtn);
		/*goonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ccNumber = ccNField.getText();
				if(!(ccNumber.length()>= 13 && ccNumber.length()<=16) || ccNumber.matches(".*[a-z].*"))
					return;
				
				if(LocalDate.now().isAfter(LocalDate.parse(ccExpField.getText())))
					return;
						
				if(!(ccSecField.getText().length()==3)|| ccSecField.getText().matches(".*[a-z].*"))
					return;
				
				if(!(ccOwnerField.getText().toLowerCase().matches(".*[a-z].*")) || !(ccOwnerField.getText().contains(" ")))
					return;
				
				chkCartBtn.setVisible(false);
			}
		});*/
		goonBtn.addActionListener(new CheckOutListener(this,cart));
		goonBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		
		comboPModel = new DefaultComboBoxModel<String>(paymentString);
		comboPBox = new JComboBox<String>(comboPModel);
		comboPBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CREDIT CARD PAYMENT
				if(comboPModel.getSelectedItem().toString().equals(paymentString[0])) {
					paymentPanel.setVisible(true);
					cachetPanel.setVisible(false);
					paypalPanel.setVisible(false);
				}
				//CACHET PAYMENT
				if(comboPModel.getSelectedItem().toString().equals(paymentString[1])) {
					paymentPanel.setVisible(false);
					cachetPanel.setVisible(true);
					paypalPanel.setVisible(false);
				}
				//PAYPAL PAYMENT
				if(comboPModel.getSelectedItem().toString().equals(paymentString[2])) {
					paymentPanel.setVisible(false);
					cachetPanel.setVisible(false);
					paypalPanel.setVisible(true);
				}
			}
		});
		comboPBox.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		comboPBox.setMaximumRowCount(3);
		comboPBox.setBounds(710, 80, 170, 27);
		checkOutFrame.add(comboPBox);
		
		paymentLbl = new JLabel("Payment method:");
		paymentLbl.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		paymentLbl.setBounds(715, 59, 169, 16);
		checkOutFrame.add(paymentLbl);
		
		cachetText = new JTextArea();
		cachetText.setEditable(false);
		cachetText.setLineWrap(true);
		cachetText.setRows(8);
		cachetText.setText("Selecting via cachet payment methods there'll be an extra fee of 5€");
		cachetText.setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		cachetText.setBounds(8, 8, 176, 54);
		cachetPanel.add(cachetText);
		
		bpsLbl = new JLabel("BookPoints Gain: " + totalBPs());
		bpsLbl.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		bpsLbl.setBounds(408, 409, 183, 16);
		checkOutFrame.add(bpsLbl);
		
		errorLbl = new JLabel("");
		errorLbl.setForeground(new Color(255, 51, 0));
		errorLbl.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		errorLbl.setBounds(763, 347, 183, 16);
		checkOutFrame.add(errorLbl);
		cachetPanel.setVisible(false);
		
		
		backBtn.addActionListener(new CheckOutListener(this,cart));
		chkCartBtn.addActionListener(new CheckOutListener(this,cart));
		
	}

	public DefaultTableModel InitializeTable(ArrayList<Book> cart) {
		String col[] = {"Title","ISBN", "Price (€)", "BPs" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		if(cart.isEmpty())
			return tableModel;
		String title;
		String ISBN;
		double price = 0;
		int BPs = 0;
		
		for(Book x: cart) {
			title = x.getTitle();
			ISBN = x.getISBN();
			price = x.getPrice();
			BPs = x.getBookPoint();
			Object [] temp = {title,ISBN,String.format("%.2f",price),BPs};
			tableModel.addRow(temp);
		}
		return tableModel;
	}
	
	public void setInfo() {
		
		nameField.setText(user.getName());
		surnameField.setText(user.getSurname());
		addressField.setText(user.getAddress());
		capField.setText(Integer.toString(user.getCap()));
		emailField.setText(user.getEmail());
		cityField.setText(user.getCity());
		telephoneField.setText(user.getTelephone());
		countryField.setText(user.getCountry());
	
	}
	
	public ArrayList<Book> getCart(){
		return cart;
	}
	
	public RegisteredUser getUser() {
		return user;
	}
	
	public Book getBook() {
		return book;
	}
	
	public ArrayList<Book> getBookList(){
		return BookList;
	}

	public void refreshCart( ArrayList<Book> newCart) {
		cart = newCart;
	}

	
	public double totalPrice() {
		double res = 0.00;
		for(Book x : this.cart) {
			res = res + x.getPrice();
		}
		return res;
	}
	
	public int totalBPs() {
		int res = 0;
		for(Book x : cart) {
			res = res + x.getBookPoint();
		}
		return res;
	}
	
	public String getDeliveryAddress() {
		String r = null;
		String id = nameField.getText() + " " + surnameField.getText();
		String address = addressField.getText();
		String city = cityField.getText();
		String cap = capField.getText();
		String country = countryField.getText();
		r = String.format("%s, %s, %s, %s, %s", id,address,city,cap,country);
		System.out.println(r);
		return r;
	}
	public String getPaymentMethod() {
		return comboPModel.getSelectedItem().toString();
	}
	public void setErrorMsg(String err) {
		errorLbl.setText(err);
	}
}
