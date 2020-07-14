package code;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.WindowConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BookCardPopUp extends JFrame {

	private JPanel 	popUpPane, 
					colorPane;
	private JTable 	ordersTable;
	
	private JScrollPane tablePane;
	private JLabel srcLbl;
	private JButton searchBtn;
	private JTextField textField;
	private JButton closeBtn;
	private ArrayList<RegisteredUser> UserList = new ArrayList<RegisteredUser>();
	
	public BookCardPopUp() {
		initialize();
	}

	private void initialize() {
		
		
		setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		setTitle("ALL USER'S BOOKCARDs");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		popUpPane = new JPanel();
		popUpPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(popUpPane);
		popUpPane.setLayout(null);
		
		colorPane = new JPanel();
		colorPane.setBackground(new Color(102, 153, 153));
		colorPane.setBounds(4, 4, 50, 270);
		popUpPane.add(colorPane);
		
		
		tablePane = new JScrollPane();
		tablePane.setEnabled(false);
		tablePane.setBounds(60, 4, 634, 228);
		popUpPane.add(tablePane);
		
		
		UserList = getUserList();
		DefaultTableModel tableModel = InitializeTable(UserList);
		ordersTable = new JTable(tableModel);
		ordersTable.setBackground(new Color(255, 255, 255));
		ordersTable.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		tablePane.setViewportView(ordersTable);
		ordersTable.getColumnModel().getColumn(1).setPreferredWidth(300);
		ordersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);		
		
		
		searchBtn = new JButton("Search Card");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		searchBtn.setForeground(new Color(102, 153, 153));
		searchBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		searchBtn.setBounds(415, 240, 160, 30);
		popUpPane.add(searchBtn);
		
		srcLbl = new JLabel("What order are you looking for?");
		srcLbl.setFont(new Font("Lantinghei SC", Font.PLAIN, 15));
		srcLbl.setBounds(60, 244, 260, 23);
		popUpPane.add(srcLbl);
		
		textField = new JTextField();
		textField.setBounds(289, 242, 130, 26);
		popUpPane.add(textField);
		textField.setColumns(10);
		
		closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserList.clear();
				dispose();
			}
		});
		closeBtn.setForeground(new Color(102, 153, 153));
		closeBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		closeBtn.setBounds(570, 240, 124, 30);
		popUpPane.add(closeBtn);
		
	}
	
	private ArrayList<RegisteredUser> getUserList(){
		ArrayList<RegisteredUser> UserList = new ArrayList<RegisteredUser>();
		try {
    		//Connection con= DBController.DB_Connection();
			Connection con= DBController.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM USERS");

            while (rs.next()) {
            	RegisteredUser n = new RegisteredUser(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
            			rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
            			rs.getInt(10), rs.getInt(11), rs.getDate(12), rs.getBoolean(13));
            	UserList.add(n);
            }
            con.close();
		} catch (SQLException ex) {
			System.out.println("User list creation FAILED");
		}
		return UserList;
	}
	
	public DefaultTableModel InitializeTable(ArrayList<RegisteredUser> UserList) {
		String col[] = {"BookCard#", "User Email"," BP's", "Sub Date"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		if(UserList.isEmpty())
			return tableModel;
		int cardcode = 0;
		String email = null;
		int bps = 0;
		Date date = null;
		
		for(RegisteredUser x: UserList) {
			if(!x.isMaster()) {
			email = x.getEmail();
			cardcode = x.getLibrocard();
			bps = x.getBookPoints();
			date = (Date) x.getReleaseDate();
			Object [] temp = {cardcode,email,bps,date};
			tableModel.addRow(temp);
			}
		}
		return tableModel;
	}
}

