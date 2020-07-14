
package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PrivateUserView extends JFrame {

	private JPanel PrivateUserFrame, colorPanel2,infoPanel, panel;
	JScrollPane tablePane;
	private int height = 900;
	private int width = 500;
	private int baseP = 100;
	//private Book book;
	private ArrayList<Book> BookList = new ArrayList<Book>();	
	private ArrayList<Book> CartList = new ArrayList<Book>();
	private ArrayList<Order> OrderList = new ArrayList<Order>();
	
	private JButton shopBtn, modifyBtn;
	private DefaultTableModel tableModel;

	private JTable ordersTable;
	private JLabel 	profileLabel,
					cityLabel, 
					telLabel,
					emailLabel,
					sunameLabel,
					unameLabel,
					addressLabel, 
					capLabel,
					countryLabel,
					cEmailLabel,
					pointLabel, 
					infoLabel, 
					librocardLabel, 
					ptsLabel,
					cDateLbl,
					cCodeLbl;
	
	private JPasswordField passwordField;
	private JSeparator separator;
	//TODO:questo user è quello che deve esser caricato dall'inizio del login
	private RegisteredUser user ;
	
	
	public PrivateUserView(RegisteredUser user, ArrayList<Book> BookList, ArrayList<Order> OrderList) {
		this.user = user;
		this.BookList = BookList;
		this.OrderList=OrderList;
		initialize();
		
	}
	
	private void initialize() {
		setTitle("BOOKBUNKER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(baseP, baseP, baseP + height, baseP + width);
		PrivateUserFrame = new JPanel();
		PrivateUserFrame.setForeground(Color.LIGHT_GRAY);
		
		setResizable(false);
		PrivateUserFrame.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(PrivateUserFrame);
		PrivateUserFrame.setLayout(null);
		
		//PANEL
		colorPanel2 = new JPanel();
		colorPanel2.setBounds(6, 6, 284, 568);
		PrivateUserFrame.add(colorPanel2);
		colorPanel2.setBackground(new Color(102, 153, 153));
		colorPanel2.setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel.setLayout(null);
		panel.setBounds(650, 90, 336, 246);
		PrivateUserFrame.add(panel);
		
		infoPanel = new JPanel();
		infoPanel.setBorder(new LineBorder(new Color(153, 153, 153)));
		infoPanel.setBounds(302, 90, 336, 246);
		PrivateUserFrame.add(infoPanel);
		infoPanel.setLayout(null);
		
		
		//BUTTON
		shopBtn = new JButton("RETURN TO SHOP");
		shopBtn.addActionListener(new PrivateUserListener(this));
		shopBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		shopBtn.setBounds(834, 17, 160, 29);
		PrivateUserFrame.add(shopBtn);
		
		modifyBtn = new JButton("Modify");
		modifyBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		modifyBtn.setBounds(226, 13, 104, 29);
		modifyBtn.addActionListener(new PrivateUserListener(this));
		infoPanel.add(modifyBtn);
		
		//LABEL
		profileLabel = new JLabel(user.getName() + "'s PROFILE");
		profileLabel.setBounds(260, 6, 634, 50);
		PrivateUserFrame.add(profileLabel);
		profileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		profileLabel.setFont(new Font("Avenir", Font.PLAIN, 31));
		
		unameLabel = new JLabel("Name: " + user.getName());
		unameLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		unameLabel.setBounds(6, 18, 176, 16);
		infoPanel.add(unameLabel);
		
		sunameLabel = new JLabel("Surname: " + user.getSurname() );
		sunameLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		sunameLabel.setBounds(6, 46, 201, 16);
		infoPanel.add(sunameLabel);
		
		addressLabel = new JLabel("Address: " + user.getAddress());
		addressLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		addressLabel.setBounds(6, 74, 309, 16);
		infoPanel.add(addressLabel);
		
		cityLabel = new JLabel("City: " + user.getCity());
		cityLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		cityLabel.setBounds(6, 102, 139, 16);
		infoPanel.add(cityLabel);
		
		capLabel = new JLabel("CAP: " + user.getCap());
		capLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		capLabel.setBounds(6, 130, 120, 16);
		infoPanel.add(capLabel);
		
		telLabel = new JLabel("Telephone: " + user.getTelephone());
		telLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		telLabel.setBounds(6, 158, 176, 16);
		infoPanel.add(telLabel);
		
		emailLabel = new JLabel("Email: " + user.getEmail());
		emailLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		emailLabel.setBounds(6, 186, 309, 16);
		infoPanel.add(emailLabel);
		
		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.setBackground(SystemColor.window);
		passwordField.setBounds(6, 214, 104, 26);
		passwordField.setBorder(null);
		infoPanel.add(passwordField);
		passwordField.setText(user.getPassword());
		
		countryLabel = new JLabel("Country: " + user.getCountry());
		countryLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		countryLabel.setBounds(157, 102, 158, 16);
		infoPanel.add(countryLabel);
		
		
		cEmailLabel = new JLabel(user.getEmail());
		cEmailLabel.setForeground(new Color(255, 255, 255));
		cEmailLabel.setFont(new Font("Gujarati Sangam MN", Font.BOLD, 15));
		cEmailLabel.setBounds(13, 48, 309, 16);
		panel.add(cEmailLabel);
		
		pointLabel = new JLabel(""+user.getBookPoints());
		pointLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pointLabel.setForeground(new Color(255, 255, 255));
		pointLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 93));
		pointLabel.setBounds(6, 81, 206, 159);
		panel.add(pointLabel);
		
		ptsLabel = new JLabel("BookPoints");
		ptsLabel.setForeground(new Color(255, 255, 255));
		ptsLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 21));
		ptsLabel.setBounds(210, 174, 120, 24);
		panel.add(ptsLabel);
		
		separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(11, 66, 312, 12);
		panel.add(separator);
		
		cCodeLbl = new JLabel(""+user.getLibrocard());
		cCodeLbl.setForeground(Color.WHITE);
		cCodeLbl.setFont(new Font("Gujarati Sangam MN", Font.BOLD, 15));
		cCodeLbl.setBounds(13, 20, 156, 16);
		panel.add(cCodeLbl);
		
		cDateLbl = new JLabel("Sub Date: " + user.getReleaseDate());
		cDateLbl.setForeground(Color.WHITE);
		cDateLbl.setFont(new Font("Gujarati Sangam MN", Font.PLAIN, 13));
		cDateLbl.setBounds(144, 209, 186, 16);
		panel.add(cDateLbl);
		
		librocardLabel = new JLabel("LibroCard:");
		librocardLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		librocardLabel.setBounds(650, 68, 74, 16);
		PrivateUserFrame.add(librocardLabel);
		
		infoLabel = new JLabel("User Info:");
		infoLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		infoLabel.setBounds(302, 68, 74, 16);
		PrivateUserFrame.add(infoLabel);
		
		tablePane = new JScrollPane();
		tablePane.setEnabled(false);
		tablePane.setBounds(300, 346, 691, 228);
		PrivateUserFrame.add(tablePane);
		
		tableModel = InitializeTable(OrderList);
		ordersTable = new JTable(tableModel);
		ordersTable.setBackground(new Color(255, 255, 255));
		ordersTable.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		tablePane.setViewportView(ordersTable);
		ordersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		ordersTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = ordersTable.getSelectedRow();
				String orderCode= ordersTable.getValueAt(i, 0).toString();
				String books = ordersTable.getValueAt(i, 1).toString();
				String booklist = books.replace("[","") ;
				booklist= booklist.replace("]", "\n");
				String bill = ordersTable.getValueAt(i, 2).toString();
				String bps = ordersTable.getValueAt(i, 3).toString();
				String address = ordersTable.getValueAt(i, 4).toString();
				String state = ordersTable.getValueAt(i, 5).toString();
				JOptionPane.showMessageDialog(null,"Order Number: "+orderCode+"\n" +
													"Books ordered: "+ booklist + "\n" +
													"Bill: "+ bill + " €      " +
													"Book points gained: "+ bps + "\n" +
													"Delivery address: " + address + "\n"+
													"Order Status: " + state,
													"Order", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
	}
	public void refreshUser(RegisteredUser newUser, ArrayList<Book> cart) {
		dispose();
		PrivateUserView puv = new PrivateUserView(newUser, BookList, OrderList);
		puv.SetCart(cart);
		puv.setVisible(true);
	
	}
	public RegisteredUser getUser() {
		return user;
	}
	
	public ArrayList<Book> getBookList(){
		return BookList;
	}

	
	public DefaultTableModel InitializeTable(ArrayList<Order> OrderList) {
		String col[] = {"Order #", "BookList", "Bill (€)"," BPs Gained", "Delivery Address", "Order State" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		if(OrderList.isEmpty())
			return tableModel;
		int code = 0;
		//String order_day = null;
		String books = null;
		double bill = 0.00;
		int bp = 0;
		//String payment_metod = null;
		String address = null;
		String orderState = null;
		
		for(Order x: OrderList) {
			code = x.getCode();
			bill = x.getBill();
			bp = x.getPoints();
			address=x.getAddress();
			books = x.getBooks();
			orderState = x.getOrderState();
			Object [] temp = {code,books,String.format("%.2f",bill),bp, address,orderState};
			tableModel.addRow(temp);
		}
		return tableModel;
	}
	
	public void SetCart(ArrayList<Book> cart) {
		this.CartList=cart;
	}
	public ArrayList<Book> getCart(){
		return CartList;
	}
}
