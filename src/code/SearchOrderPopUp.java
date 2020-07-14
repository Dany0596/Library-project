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
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;

@SuppressWarnings("serial")
public class SearchOrderPopUp extends JFrame {

	private JPanel 	popUpPane, 
					colorPane;
	private JTable 	ordersTable;
	
	private JScrollPane tablePane;
	private DefaultTableModel tableModel;
	
	private JButton searchBtn;
	private JTextField textField;
	private JLabel srcLbl;
	private JButton closeBtn;
	private Boolean master;
	private ArrayList<Order> OrderList = new ArrayList<Order>();
	
	public SearchOrderPopUp(ArrayList<Order> OrderList, Boolean master) {
		this.OrderList=OrderList;
		this.master = master;
		initialize();
	}

	private void initialize() {
		
		
		setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		setTitle("SEARCH ORDERS");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 300);
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
		tablePane.setBounds(60, 4, 834, 228);
		popUpPane.add(tablePane);
		
		if(master)
			tableModel = InitializeTable(OrderList);
		else
			tableModel =InitializeTable("0");
		
		ordersTable = new JTable(tableModel);
		ordersTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] stateO = {"Processing", "In transit", "Delivered"};
				if(master) {
					int i = ordersTable.getSelectedRow();
					String orderCode= ordersTable.getValueAt(i, 0).toString();
					String books = ordersTable.getValueAt(i, 2).toString();
					String booklist = books.replace("[","") ;
					booklist= booklist.replace("]", "\n");
					String order_day=ordersTable.getValueAt(i,1).toString();
					String bill = ordersTable.getValueAt(i, 3).toString();
					String bps = ordersTable.getValueAt(i, 4).toString();
					String address = ordersTable.getValueAt(i, 5).toString();
					String state = ordersTable.getValueAt(i, 6).toString();
					Object selectedStatus = JOptionPane.showInputDialog(null,"Order Number: "+orderCode+"\n" +
													"Order date: "+ order_day +"\n" +
													"Books ordered: "+ booklist + "\n" +
													"Bill: "+ bill + " €      " +
													"Book points gained: "+ bps + "\n" +
													"Delivery address: " + address + "\n"+
													"Order Status: " + state +"\nModify order status:" ,
													"Order Info",JOptionPane.PLAIN_MESSAGE,null,stateO,"Processing");
					
					System.out.println(selectedStatus);
					
					if(selectedStatus == null)
						return;
					
						System.out.println("ciao");
						Connection con = DBController.getConnection();
						PreparedStatement pst;
						try {
							pst=con.prepareStatement("UPDATE ORDERS SET orderstate = ? WHERE ORDERS.code = ?");
							pst.setString(1, selectedStatus.toString());
							pst.setInt(2, Integer.parseInt(orderCode));
							pst.execute();
							
							OrderList.clear();
							Statement st = con.createStatement();
							ResultSet rs = st.executeQuery("SELECT * FROM ORDERS");
							while (rs.next()) {
								Order o = new Order(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
								OrderList.add(o);
							}
							con.close();
							}catch (SQLException e1) {
								System.out.println("Order status update failed!");
							}
							ordersTable.setModel(InitializeTable(OrderList));
							ordersTable.getColumnModel().getColumn(0).setPreferredWidth(120);
							ordersTable.getColumnModel().getColumn(1).setPreferredWidth(200);
							ordersTable.getColumnModel().getColumn(2).setPreferredWidth(60);
							ordersTable.getColumnModel().getColumn(3).setPreferredWidth(60);
							ordersTable.getColumnModel().getColumn(4).setPreferredWidth(150);
							ordersTable.repaint();
							
				}
				else {
					int i = ordersTable.getSelectedRow();
					String order_day=ordersTable.getValueAt(i,0).toString();
					String books = ordersTable.getValueAt(i, 1).toString();

					String booklist = books.replace("[","") ;
					booklist= booklist.replace("]", "\n");
					String bill = ordersTable.getValueAt(i, 2).toString();
					String bps = ordersTable.getValueAt(i, 3).toString();
					
					String address = ordersTable.getValueAt(i, 4).toString();
					String state = ordersTable.getValueAt(i, 5).toString();
					JOptionPane.showMessageDialog(null, "Order date: "+ order_day+ "\n" +
														"Books ordered: "+ booklist + "\n" +
														"Bill: "+ bill + " €      " +
														"Book points gained: "+ bps + "\n" +
														"Delivery address: " + address + "\n"+
														"Order Status: " + state,
														"Order", JOptionPane.PLAIN_MESSAGE);
					
				}
			}
		});
		ordersTable.setBackground(new Color(255, 255, 255));
		ordersTable.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		tablePane.setViewportView(ordersTable);

		ordersTable.getColumnModel().getColumn(0).setPreferredWidth(120);
		ordersTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		ordersTable.getColumnModel().getColumn(2).setPreferredWidth(200);
		ordersTable.getColumnModel().getColumn(3).setPreferredWidth(60);
		ordersTable.getColumnModel().getColumn(4).setPreferredWidth(60);
		ordersTable.getColumnModel().getColumn(5).setPreferredWidth(150);
		searchBtn = new JButton("Search order");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1788256426
				ordersTable.setModel(InitializeTable(textField.getText()));
				ordersTable.repaint();
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
				dispose();
				OrderList.clear();
			}
		});
		closeBtn.setForeground(new Color(102, 153, 153));
		closeBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		closeBtn.setBounds(570, 240, 124, 30);
		popUpPane.add(closeBtn);
		
	}
	
	public DefaultTableModel InitializeTable(ArrayList<Order> OrderList) {
		String col[] = {"Order #","Order Date","BookList", "Bill (€)"," BPs Gained","Email", "Delivery Address", "Order State" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		if(OrderList.isEmpty())
			return tableModel;
		int code = 0;
		String order_day = "";
		String books = null;
		String email = null;
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
			email = x.getEmail();
			order_day = x.getOrder_day().toString();
			orderState = x.getOrderState();
			Object [] temp = {code,order_day,books,String.format("%.2f",bill),bp,email, address,orderState};
			tableModel.addRow(temp);
		}
		return tableModel;
	}

	public DefaultTableModel InitializeTable(String selector) {
		String col[] = {"Order Date","BookList","Bill (€)"," BPs Gained", "Delivery Address", "Order State" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		if(OrderList.isEmpty())
			return tableModel;

		//int code = 0;
		String order_day = null;
		String books = null;
		//String email = null;
		double bill = 0.00;
		int bp = 0;
		//String payment_metod = null;
		String address = null;
		String orderState = null;
		
		for(Order x: OrderList) {
			if(x.getCode() == Integer.parseInt(selector) && !selector.equals("")) {
				//code = x.getCode();
				bill = x.getBill();
				bp = x.getPoints();
				address=x.getAddress();
				books = x.getBooks();
				order_day=x.getOrder_day().toString();
				//email = x.getEmail();
				orderState = x.getOrderState();
				Object [] temp = {order_day,books,String.format("%.2f",bill),bp, address,orderState};
				tableModel.addRow(temp);
			}
		}
		return tableModel;
	}
	
	
}
