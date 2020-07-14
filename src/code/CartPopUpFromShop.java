package code;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.WindowConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class CartPopUpFromShop extends JFrame {

	private JPanel 	popUpPane, 
					colorPane;
	private JTable 	cartTable;
	
	private JScrollPane tablePane;
	
	private JButton clearBtn,
					rmBtn,
					backBtn;
	
	private ShopView sv;// necessario per l'aggiornamento del model della tabella dei libri e per il cart
	private ArrayList<Book> cart = new ArrayList<Book>();
	
	private int selectedRow;
	
	public CartPopUpFromShop(ArrayList<Book> cart, ShopView sv) {
		this.cart = cart;
		this.sv = sv;
		initialize();
	}

	private void initialize() {
		
		
		setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		setTitle("YOUR CART");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 300);
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
		tablePane.setBounds(60, 4, 513, 228);
		popUpPane.add(tablePane);
		
		//cartTable = new JTable();
		DefaultTableModel tableModel = InitializeTable(cart);
		cartTable = new JTable(tableModel);
		cartTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			selectedRow = cartTable.getSelectedRow();
			}
			
		});
		cartTable.setBackground(new Color(255, 255, 255));
		cartTable.setFont(new Font("Lantinghei SC", Font.PLAIN, 14));
		tablePane.setViewportView(cartTable);
		 //TODO: riempire con i libri all'interno di cart
		/*cartTable.setModel(new DefaultTableModel(
				new Object[][] {
					{null,null,null},
					{null,null,null},
					{null,null,null},
					{null,null,null},
					{null,null,null},
					{null,null,null}
					
				},
				new String[] {
						"Title","Price (€) ", "BPs"
				}
				
		));*/
		cartTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);		
		
		
		rmBtn = new JButton("Remove selected item");
		/*rmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});*/
		rmBtn.addActionListener(new CartPopUpListener(this));
		rmBtn.setForeground(new Color(153, 51, 51));
		rmBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		rmBtn.setBounds(276, 240, 219, 30);
		popUpPane.add(rmBtn);
		
		
		backBtn = new JButton("Return");
		backBtn.addActionListener(new CartPopUpListener(this));
		
		/*backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});*/
		
		clearBtn = new JButton("Clear Cart");
		clearBtn.addActionListener(new CartPopUpListener(this));
		/*clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CartPopUpFromShop a = new CartPopUpFromShop(cart, sv);
				//Inserire il refresh del carrello
				a.setVisible(true);
				
			}
		});*/
		clearBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		clearBtn.setForeground(new Color(204, 153, 0));
		clearBtn.setBounds(163, 240, 117, 30);
		popUpPane.add(clearBtn);
		
		backBtn.setForeground(new Color(255, 153, 102));
		backBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		backBtn.setBounds(54, 240, 113, 30);
		popUpPane.add(backBtn);
		
	}
	
	public DefaultTableModel InitializeTable(ArrayList<Book> BookList) {
		String col[] = {"Title", "Price (€)", "BPs" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		if(BookList.isEmpty())
			return tableModel;
		String title;
		double price = 0.00;
		int BPs = 0;
		
		for(Book x: BookList) {
			title = x.getTitle();
			price = x.getPrice();
			BPs = x.getBookPoint();
			Object [] temp = {title,String.format("%.2f",price),BPs};
			tableModel.addRow(temp);
		}
		return tableModel;
	}
	
	public void clearCart() {
		//this.cart = new ArrayList<Book>();
		cart.clear();
		sv.setCart(cart);
		InitializeTable(cart);
		CartPopUpFromShop temp = new CartPopUpFromShop(cart, sv);
		this.dispose();
		temp.setVisible(true);
	}
	
	public void removeItem(int index) {
		
		cart.remove(index);
		sv.setCart(cart);
		CartPopUpFromShop temp = new CartPopUpFromShop(cart, sv);
		this.dispose();
		temp.setVisible(true);
		
	}
	
	public int getSelectedItem() {
		return selectedRow;
	}
	
}
