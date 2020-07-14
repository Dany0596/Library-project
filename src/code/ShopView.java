
package code;

import java.awt.Color;
import java.awt.Font;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ShopView extends JFrame {

	private JPanel shopFrame, colorPanel2, infoPanel;
	private int height = 900;
	private int width = 500;
	private int baseP = 100;
	private RegisteredUser loguser;
	private Book book;
	private ArrayList<Book> BookList = new ArrayList<Book>();
	private ArrayList<Book> tableList = new ArrayList<Book>();
	private ArrayList<Classifica> rankList = new ArrayList<Classifica>();
	private ArrayList<Book> cart = new ArrayList<Book>();
	private int selectedRow;
	private String[] genreChart= {	"Best Seller","Drama",
									"Horror", "Kitchen", 
									"For Kids", "Sci-fi",
									"Science", "Crime", 
									"Thriller", "Adventure",
									"Storytelling", "Fiction",
									"Learning", "Fantasy",
									"Historic", "Biography"};
	private DefaultTableModel tableModel;
	private DefaultComboBoxModel<String> comboModel;
	
	private JTable shopTable;
	private JScrollPane tablePane;
	private JButton logoutBtn,
					profileBtn,
					cartBtn, 
					addBtn, 
					newBookBtn,
					allOrderBtn,
					allCardBtn,
					orderBtn,
					updateRankBtn;
	
	
	
	private JLabel 	registLabel,
					isbnLabel,
					priceLabel,
					houseLabel,
					BookPointsLabel,
					titleLabel,
					authorLabel,
					yearLabel,
					descLabel,
					loggedLabel,
					errorLabel,
					adminLabel;
	
	private JTextField 	isbnField,
						priceField,
						houseField,
						bpField,
						titleField,
						authorField, 
						yearField;
	private JButton checkOutBtn;
	private JTextArea descField,updateText;
	private JComboBox<String> chartBox;
	private JLabel rankLabel;
	private JLabel weekLabel;
	private JLabel soldCopiesLbl;
	
	public ShopView(RegisteredUser user, ArrayList<Book> BookList) {
		//this.book = book;
		this.BookList = BookList;
		this.loguser = user;
		setClassifica();
		initialize();
		loggedLabel.setText("Hi " + loguser.getName());
	}
	
	private void initialize() {
		
		setTitle("BOOKBUNKER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(baseP, baseP, baseP + height, baseP + width);
		shopFrame = new JPanel();
		shopFrame.setForeground(Color.LIGHT_GRAY);
		
		setResizable(false);
		shopFrame.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(shopFrame);
		shopFrame.setLayout(null);

		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		errorLabel.setBounds(772, 484, 131, 19);
		shopFrame.add(errorLabel);
		
		colorPanel2 = new JPanel();
		colorPanel2.setBounds(6, 6, 284, 568);
		shopFrame.add(colorPanel2);
		colorPanel2.setBackground(new Color(102, 153, 153));
		colorPanel2.setLayout(null);
		//BUTTON
		
		profileBtn = new JButton("YOUR PROFILE");
		profileBtn.addActionListener(new ShopListener(this));
		profileBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		profileBtn.setBounds(864, 37, 130, 29);
		shopFrame.add(profileBtn);
		
		orderBtn = new JButton("CHECK ORDER NUMBER");
		orderBtn.addActionListener(new ShopListener(this));
		orderBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		orderBtn.setBounds(794, 37, 200, 29);
		shopFrame.add(orderBtn);
		if(loguser.getName().equals("Guest")) 
			orderBtn.setVisible(true);
		else
			orderBtn.setVisible(false);
		
		/*
		if(loguser.getName().equals("Guest")) 
			profileBtn.setVisible(false);
		if(loguser.getName().equals("Guest"))
			newBookBtn.setVisible(false);*/

		allCardBtn = new JButton("CHECK ALL BOOKCARD");
		allCardBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		allCardBtn.setBounds(0, 85, 284, 29);
		colorPanel2.add(allCardBtn);
		allCardBtn.addActionListener(new ShopListener(this));
		
		newBookBtn = new JButton("ADD NEW BOOK");
		newBookBtn.setBounds(0, 56, 284, 29);
		colorPanel2.add(newBookBtn);
		newBookBtn.addActionListener(new ShopListener(this));
		newBookBtn.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		
		allOrderBtn = new JButton("CHECK ALL ORDER");
		allOrderBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		allOrderBtn.setBounds(0, 27, 284, 29);
		colorPanel2.add(allOrderBtn);
		allOrderBtn.addActionListener(new ShopListener(this));
		
		adminLabel = new JLabel("Admin Panel:");
		adminLabel.setForeground(new Color(255, 255, 255));
		adminLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		adminLabel.setBounds(6, 6, 118, 19);
		colorPanel2.add(adminLabel);
		
		updateRankBtn = new JButton("UPDATE RANKING");
		updateRankBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		updateRankBtn.setBounds(0, 114, 284, 29);
		colorPanel2.add(updateRankBtn);
		updateRankBtn.addActionListener(new ShopListener(this));
		
		updateText = new JTextArea();
		updateText.setForeground(new Color(255, 255, 255));
		updateText.setBackground(new Color(102, 153, 153));
		updateText.setWrapStyleWord(true);
		updateText.setRows(30);
		updateText.setBounds(0, 141, 284, 324);
		colorPanel2.add(updateText);
		
		addBtn = new JButton("ADD TO CART");
		addBtn.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		addBtn.setBounds(850, 363, 141, 29);
		addBtn.addActionListener(new ShopListener(this));
		shopFrame.add(addBtn);
		
		checkOutBtn = new JButton("CHECK OUT");
		checkOutBtn.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		checkOutBtn.setBounds(850, 404, 141, 29);
		checkOutBtn.addActionListener(new ShopListener(this));
		shopFrame.add(checkOutBtn);
		
		cartBtn = new JButton("SHOW CART");
		cartBtn.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		cartBtn.setBounds(850, 322, 141, 29);
		cartBtn.addActionListener(new ShopListener(this));
		shopFrame.add(cartBtn);
		
		if(loguser.isMaster()) {
			adminLabel.setVisible(true);
			allOrderBtn.setVisible(true);
			allCardBtn.setVisible(true);
			newBookBtn.setVisible(true);
			updateRankBtn.setVisible(true);
			checkOutBtn.setVisible(false);
			profileBtn.setVisible(false);
			addBtn.setVisible(false);
			cartBtn.setVisible(false);
		}
		else if(loguser.getName().equals("Guest") && loguser.isMaster()==false) {

			adminLabel.setVisible(false);
			allOrderBtn.setVisible(false);
			allCardBtn.setVisible(false);
			newBookBtn.setVisible(false);
			profileBtn.setVisible(false);
			updateRankBtn.setVisible(false);
			checkOutBtn.setVisible(true);
			addBtn.setVisible(true);
			cartBtn.setVisible(true);

		}
		else if(loguser.isMaster()==false && !loguser.getName().equals("Guest")){
			adminLabel.setVisible(false);
			allOrderBtn.setVisible(false);
			allCardBtn.setVisible(false);
			newBookBtn.setVisible(false);
			profileBtn.setVisible(true);
			checkOutBtn.setVisible(true);
			addBtn.setVisible(true);
			cartBtn.setVisible(true);
			updateRankBtn.setVisible(false);
		}
		
		
		/*
		if(loguser.getName().equals("Guest")) {
			adminLabel.setVisible(false);
			allOrderBtn.setVisible(false);
			allCardBtn.setVisible(false);
			newBookBtn.setVisible(false);
		}
		if(!loguser.getName().equals("Guest") && loguser.isMaster()) {
			adminLabel.setVisible(true);
			allOrderBtn.setVisible(true);
			allCardBtn.setVisible(true);
			newBookBtn.setVisible(true);
		}*/
		
		// PANEL
		
		tablePane = new JScrollPane();
		tablePane.setEnabled(false);
		tablePane.setBounds(300, 68, 691, 247);
		shopFrame.add(tablePane);
		
		/*shopTable = new JTable(new DefaultTableModel());
		
		String col[] = {"Title", "Author/s"," ISBN", "Price (€)" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for(Book x : BookList) {
			Object[] objs = {x.getTitle(), x.getAuthors(),x.getISBN(),x.getPrice()};
			tableModel.addRow(objs);
		}
		
		shopTable.setModel(tableModel);*/
		
		
		tableModel = InitializeTable(BookList);
		shopTable = new JTable(tableModel);
		
		
		shopTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			selectedRow = shopTable.getSelectedRow();
			if(tableList.isEmpty()) {
				infoPanel.setVisible(false);
			}
			else {
				infoPanel.setVisible(true);
				if(loguser.isMaster()!=true)
					addBtn.setVisible(true);
				isbnField.setText(tableList.get(selectedRow).getISBN());
				descField.setText(tableList.get(selectedRow).getDescription());
				priceField.setText(String.format("%.2f",(tableList.get(selectedRow).getPrice())));
				houseField.setText(tableList.get(selectedRow).getHouse());
				bpField.setText(String.valueOf(tableList.get(selectedRow).getBookPoint()));
				titleField.setText(tableList.get(selectedRow).getTitle());
				authorField.setText(tableList.get(selectedRow).getAuthors());
				yearField.setText(String.valueOf(tableList.get(selectedRow).getYear()));
				Classifica b = getRanking(tableList.get(selectedRow).getISBN());
				Date today = new Date();
				Date d = b.getDate();
				//Date d = rankList.get(selectedRow).getDate();
				long settimane = (today.getTime() - d.getTime())/(1000*3600*24*7); //TODO
				weekLabel.setText(String.valueOf(settimane) +" weeks");
				rankLabel.setText("Pos: " + String.valueOf(b.getPosizione())+ " for \n");
				soldCopiesLbl.setText("Sold copies: " + String.valueOf(tableList.get(selectedRow).getCopies()));
				//rankLabel.setText("Pos: " + String.valueOf(rankList.get(selectedRow).getPosizione())+ " for \n");
				//soldCopiesLbl.setText("Sold copies: " + String.valueOf(tableList.get(selectedRow).getCopies()));
				
				System.out.println("Today:"+ today.toString()+"\nInsertDate:"+ d.toString()+"\ntime:"+  settimane);
				}
			}
			
		});
		shopTable.setBackground(new Color(255, 255, 255));
		shopTable.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		tablePane.setViewportView(shopTable);
		
		comboModel = new DefaultComboBoxModel<String>(genreChart);
		chartBox = new JComboBox<String>(comboModel);
		chartBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shopTable.setModel(InitializeTable(BookList,chartBox.getSelectedItem().toString()));
				shopTable.repaint();
			}
		});
		chartBox.setFont(new Font("Lantinghei TC", Font.PLAIN, 14));
		chartBox.setMaximumRowCount(12);
		chartBox.setBounds(852, 445, 135, 27);
		shopFrame.add(chartBox);
		/*shopTable.setModel(new DefaultTableModel(
				new Object[][] {
					{book.getTitle().toString(), book.getAuthors().toString() ,book.getISBN(),book.getPrice()},
					{null,null,null,null}
					
				},
				new String[] {
						"Title","Author","ISBN", "Price (€)"
				}
				
		));
		shopTable.getColumnModel().getColumn(0).setPreferredWidth(200);
		shopTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		shopTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		shopTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		*/
		
		
		logoutBtn = new JButton("LOG OUT");
		logoutBtn.addActionListener(new ShopListener(this));
		logoutBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		logoutBtn.setBounds(877, 6, 117, 29);
		shopFrame.add(logoutBtn);
			
		
		
		
		registLabel = new JLabel("OUR LIBRARY");
		registLabel.setBounds(300, 6, 694, 50);
		shopFrame.add(registLabel);
		registLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registLabel.setFont(new Font("Avenir", Font.PLAIN, 31));
		
		infoPanel = new JPanel();
		infoPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		infoPanel.setBounds(300, 322, 551, 252);
		shopFrame.add(infoPanel);
		infoPanel.setLayout(null);
		
		
		isbnField = new JTextField();
		isbnField.setEditable(false);
		isbnField.setBounds(49, 206, 151, 26);
		infoPanel.add(isbnField);
		isbnField.setColumns(10);
		
		isbnLabel = new JLabel("ISBN");
		isbnLabel.setBounds(6, 210, 31, 19);
		infoPanel.add(isbnLabel);
		isbnLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		
		descLabel = new JLabel("Description");
		descLabel.setBounds(6, 60, 71, 19);
		infoPanel.add(descLabel);
		descLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		
		priceLabel = new JLabel("Price");
		priceLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		priceLabel.setBounds(238, 210, 36, 19);
		infoPanel.add(priceLabel);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setEditable(false);
		priceField.setBounds(270, 206, 130, 26);
		infoPanel.add(priceField);
		
		houseLabel = new JLabel("House");
		houseLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		houseLabel.setBounds(6, 185, 53, 19);
		infoPanel.add(houseLabel);
		
		houseField = new JTextField();
		houseField.setColumns(10);
		houseField.setEditable(false);
		houseField.setBounds(54, 181, 179, 26);
		infoPanel.add(houseField);
		
		BookPointsLabel = new JLabel("BookPoints");
		BookPointsLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		BookPointsLabel.setBounds(245, 185, 71, 19);
		infoPanel.add(BookPointsLabel);
		
		bpField = new JTextField();
		bpField.setEditable(false);
		bpField.setColumns(10);
		bpField.setBounds(317, 181, 130, 26);
		infoPanel.add(bpField);
		
		titleLabel = new JLabel("Title");
		titleLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		titleLabel.setBounds(6, 10, 53, 19);
		infoPanel.add(titleLabel);
		
		titleField = new JTextField();
		titleField.setEditable(false);
		titleField.setColumns(10);
		titleField.setBounds(36, 6, 388, 26);
		infoPanel.add(titleField);
		
		authorLabel = new JLabel("Author/s");
		authorLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		authorLabel.setBounds(6, 35, 71, 19);
		infoPanel.add(authorLabel);
		
		authorField = new JTextField();
		authorField.setColumns(10);
		authorField.setEditable(false);
		authorField.setBounds(71, 31, 171, 26);
		infoPanel.add(authorField);
		
		yearLabel = new JLabel("Year");
		yearLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		yearLabel.setBounds(247, 35, 36, 19);
		infoPanel.add(yearLabel);
		
		yearField = new JTextField();
		yearField.setColumns(10);
		yearField.setEditable(false);
		yearField.setBounds(285, 31, 83, 26);
		infoPanel.add(yearField);
		
		descField = new JTextArea();
		descField.setWrapStyleWord(true);
		descField.setLineWrap(true);
		descField.setRows(8);
		descField.setBounds(6, 79, 539, 98);
		infoPanel.add(descField);
		
		rankLabel = new JLabel("Pos: ");
		rankLabel.setFont(new Font("Lantinghei SC", Font.BOLD, 16));
		rankLabel.setBounds(425, 13, 104, 19);
		infoPanel.add(rankLabel);
		
		weekLabel = new JLabel("Weeks:");
		weekLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		weekLabel.setBounds(426, 34, 123, 19);
		infoPanel.add(weekLabel);
		
		
		soldCopiesLbl = new JLabel();
		soldCopiesLbl.setFont(new Font("Lantinghei TC", Font.PLAIN, 15));
		soldCopiesLbl.setBounds(412, 211, 123, 19);
		infoPanel.add(soldCopiesLbl);
		if(loguser.isMaster())
			soldCopiesLbl.setVisible(true);
		else
			soldCopiesLbl.setVisible(false);
		
		
		loggedLabel = new JLabel("");
		loggedLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		loggedLabel.setBounds(302, 28, 218, 16);
		shopFrame.add(loggedLabel);
		
				
		
	}
	
//---------------------FUNCTIONS-----------------------
	
	//TABEL FUNCTION
	public DefaultTableModel getModel() {
		
		return (DefaultTableModel) shopTable.getModel();
		
	}
	
	public DefaultTableModel InitializeTable(ArrayList<Book> BookList) {
		String col[] = {"Title", "Author/s"," ISBN", "Price (€)" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableList.clear();
		if(BookList.isEmpty())
			return tableModel;
		String title;
		String authors;
		String ISBN;
		String price = null;
		
		
		for(Book x: BookList) {
			tableList.add(x);
			title = x.getTitle();
			authors = x.getAuthors();
			ISBN = x.getISBN();
			price = String.format("%.2f",x.getPrice());
			Object [] temp = {title,authors,ISBN,price};
			tableModel.addRow(temp);
		}
		return tableModel;
	}
	
	public DefaultTableModel InitializeTable(ArrayList<Book> BookList, String Selector) {
		String col[] = {"Title", "Author/s"," ISBN", "Price (€)" };
		
		tableList.clear();
		
		DefaultTableModel tableModel = new DefaultTableModel(col, 0){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		if(BookList.isEmpty())
			return tableModel;
		
		String title;
		String authors;
		String ISBN;
		String price = null;
		
		if(Selector.equals("Best Seller"))
			return InitializeTable(BookList);
		
		for(Book x: BookList) {
			if(x.getGenre().toLowerCase().equals(Selector.toLowerCase()) || x.getGenre().toLowerCase().contains(Selector.toLowerCase())) {
				tableList.add(x);
				title = x.getTitle();
				authors = x.getAuthors();
				ISBN = x.getISBN();
				price = String.format("%.2f",x.getPrice());
				Object [] temp = {title,authors,ISBN,price};
				tableModel.addRow(temp);
			}
		}
		if(tableModel.getRowCount()==0) {
			Object[] temp = {"No items found!","","",""};
			tableModel.addRow(temp);
		}
		
		return tableModel;
	}
	
	public RegisteredUser getLoggedUser() {
		return loguser;
	}
	public Book getBook() {
		return book;
	}
	
	public Book getSelectedBook() {
		String isbn = (String) shopTable.getModel().getValueAt(selectedRow, 2);
		Book result = null;
		for(Book x : BookList) {
			if(x.getISBN().equals(isbn))
				result = x;
		}
		return result;
	}
	
	public ArrayList<Book> getBookList(){
		return (ArrayList<Book>) BookList;
	}
	
	//CART FUNCTION
	public ArrayList<Book> getCart(){
		return cart;
	}
	
	public void setCart( ArrayList<Book> newCart) {
		cart = newCart;
	}
	
	//USARE QUESTA NEI LISTENER DI Regist e Log
	public void setClassifica(){
		
			rankList.clear();
		try {
			Connection con = DBController.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM RANK");

            while (rs.next()) {
            	Classifica l =new Classifica(rs.getString(1),rs.getDate(3),rs.getInt(2));
            	System.out.println(l.getISBN().toString() +" "+ l.getPosizione() + " " +l.getDate() );
            	rankList.add(l);
            }
            con.close();
		} catch (SQLException ex) {
			System.out.println("Rank list creation FAILED");
		}
	}
	
	public ArrayList<Classifica> getClassifica(){
		return rankList;
	}
	
	public void refreshClassifica(ArrayList<Classifica> r) {
		this.rankList=r;
	}
	
	public void setUpdateText(String res) {
		updateText.setText(res);
	}
	
	private Classifica getRanking(String isbn) {
		Classifica b = null;
		for(Classifica x: rankList) {
			if(x.getISBN().equals(isbn)) {
				b=x;
			}
		}
		return b;
	}
	
	//BOOK FUNCTION
	public void refreshBooks(Book newBook) {
		getBookList().add(newBook);
		InitializeTable(BookList);
	}
}
