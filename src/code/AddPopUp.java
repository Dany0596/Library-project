package code;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.util.Calendar;

@SuppressWarnings("serial")
public class AddPopUp extends JFrame {

	private JPanel 	popUpPane,
					colorPane;
	private JLabel 	titleLabel,
					authorLabel,
					houseLabel,
					isbnLabel,
					yearLabel,
					priceLabel,
					descLabel,
					pointLabel,
					typeLabel,
					dateLabel;
	private JTextField 	titleField,
						authorField,
						houseField,
						isbnField,
						yearField,
						priceField,
						descField,
						pointField,
						typeField,
						dateField;
	private JButton confirmBtn,
					cancelBtn;
	//private String[] genreChart= {	"Best Seller","Drama","Horror", "Kitchen", "For Kids", "Sci-fi","Science", "Crime", 
	//		"Thriller", "Adventure","Storytelling", "Fiction","Learning", "Fantasy"};
	private ShopView sv;
	private JLabel errorLabel;
	//private Statement stat= null;
	
	
	public AddPopUp(ShopView sv) {
		this.sv = sv;
		initialize();
	}

	private void initialize() {
		
		
		setFont(new Font("Lantinghei SC", Font.PLAIN, 12));
		setTitle("ADD NEW BOOK");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 334);
		popUpPane = new JPanel();
		popUpPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(popUpPane);
		popUpPane.setLayout(null);
		
		colorPane = new JPanel();
		colorPane.setBackground(new Color(102, 153, 153));
		colorPane.setBounds(4, 4, 50, 304);
		popUpPane.add(colorPane);
		
		titleLabel = new JLabel("Title:");
		titleLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		titleLabel.setBounds(66, 10, 94, 16);
		popUpPane.add(titleLabel);
		
		titleField = new JTextField();
		titleField.setBounds(109, 4, 300, 26);
		popUpPane.add(titleField);
		titleField.setColumns(10);
		
		authorLabel = new JLabel("Author/s:");
		authorLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		authorLabel.setBounds(66, 44, 94, 16);
		popUpPane.add(authorLabel);
		
		authorField = new JTextField();
		authorField.setColumns(10);
		authorField.setBounds(129, 38, 280, 26);
		popUpPane.add(authorField);
		
		houseLabel = new JLabel("House:");
		houseLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		houseLabel.setBounds(66, 78, 94, 16);
		popUpPane.add(houseLabel);
		
		houseField = new JTextField();
		houseField.setColumns(10);
		houseField.setBounds(129, 72, 280, 26);
		popUpPane.add(houseField);
		
		isbnField = new JTextField();
		isbnField.setColumns(10);
		isbnField.setBounds(129, 106, 280, 26);
		popUpPane.add(isbnField);
		
		isbnLabel = new JLabel("ISBN:");
		isbnLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		isbnLabel.setBounds(66, 112, 94, 16);
		popUpPane.add(isbnLabel);
		
		yearLabel = new JLabel("Year:");
		yearLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		yearLabel.setBounds(66, 146, 94, 16);
		popUpPane.add(yearLabel);
		
		yearField = new JTextField();
		yearField.setColumns(10);
		yearField.setBounds(109, 140, 122, 26);
		popUpPane.add(yearField);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(286, 140, 123, 26);
		popUpPane.add(priceField);
		
		priceLabel = new JLabel("Price:");
		priceLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		priceLabel.setBounds(243, 146, 94, 16);
		popUpPane.add(priceLabel);
		
		descLabel = new JLabel("Description:");
		descLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		descLabel.setBounds(66, 178, 94, 16);
		popUpPane.add(descLabel);
		
		descField = new JTextField();
		descField.setHorizontalAlignment(SwingConstants.LEFT);
		descField.setBounds(66, 195, 343, 67);
		popUpPane.add(descField);
		descField.setColumns(10);
		
		pointLabel = new JLabel("BP:");
		pointLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		pointLabel.setBounds(257, 280, 42, 16);
		popUpPane.add(pointLabel);
		
		pointField = new JTextField();
		pointField.setColumns(10);
		pointField.setBounds(287, 274, 122, 26);
		popUpPane.add(pointField);
		
		dateField = new JTextField(new java.sql.Date(Calendar.getInstance().getTimeInMillis()).toString());
		dateField.setColumns(10);
		dateField.setBounds(421, 195, 122, 26);
		popUpPane.add(dateField);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new AddPopUpListener(sv, this));
		cancelBtn.setForeground(new Color(255, 204, 102));
		cancelBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		cancelBtn.setBounds(438, 4, 117, 29);
		popUpPane.add(cancelBtn);
		
		confirmBtn = new JButton("Confirm");
		/*confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//TODO
				
				String title = titleField.getText();
				String author = authorField.getText();
				String house = houseField.getText();
				String isbn = isbnField.getText();
				String desc = descField.getText();
				String genre = typeField.getText();
				Date date = Date.valueOf(dateField.getText());
				
				if(isbn.length()!= 13 || isbn.matches(".*[a-z].*")) {
					errorLabel.setText("Can't process");
					return;
				}

				int year;
				Double price;
				int bps;
				
				try {
					year = Integer.valueOf(yearField.getText());
					price =Double.valueOf(priceField.getText());
					bps = Integer.valueOf(pointField.getText());
				} catch(NumberFormatException nfe) {
					errorLabel.setText("Can't process");
					return;
				}
				
				if( year < 0) {
					errorLabel.setText("Can't process");
					return;
				}

				if( bps < 0) {
					errorLabel.setText("Can't process");
					return;
				}
				
				
				Boolean flag = false;
				for(String s : genreChart) {
					if(s.equals(typeField.getText()))
						flag = true;
				}
				if(flag == false) {
					errorLabel.setText("Can't process");
					return;
				}
				
				Book l = new Book(title, author,house,year,isbn,genre,price,0,desc,bps,date);
				final String query = "INSERT INTO BOOKS VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		        //Connection con = DBController.DB_Connection();
				Connection con = DBController.getConnection();
		        PreparedStatement pst;
		        try {
		            pst = con.prepareStatement(query);
		            pst.setString(1, l.getTitle());
		            pst.setString(2, l.getAuthors());
		            pst.setString(3, l.getHouse());
		            pst.setInt(4, l.getYear());
		            pst.setString(5, l.getISBN());
		            pst.setString(6, l.getGenre());
		            pst.setDouble(7, l.getPrice());
		            pst.setInt(8, l.getCopies());
		            pst.setString(9, l.getDescription());
		            pst.setInt(10, l.getBookPoint());
		            pst.setDate(11, l.getInsertDate());
		            
		            pst.execute();
		            con.close();
		        } catch (SQLException ex) {
		            System.out.println(ex);
		            return;
		        }
				

				String priceP = String.format("%.2f",l.getPrice());
				Object[] temp = {l.getTitle(),l.getAuthors(),l.getISBN(),priceP};
				sv.getModel().addRow(temp);
				sv.refreshBooks(l);
				dispose();
			}
		});*/
		confirmBtn.addActionListener(new AddPopUpListener(sv, this));
		confirmBtn.setFont(new Font("Lantinghei SC", Font.PLAIN, 16));
		confirmBtn.setForeground(new Color(0, 153, 153));
		confirmBtn.setBounds(438, 39, 117, 29);
		popUpPane.add(confirmBtn);
		
		typeField = new JTextField();
		typeField.setColumns(10);
		typeField.setBounds(109, 274, 122, 26);
		popUpPane.add(typeField);
		
		typeLabel = new JLabel("Genre:");
		typeLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		typeLabel.setBounds(66, 280, 94, 16);
		popUpPane.add(typeLabel);
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(421, 116, 110, 16);
		popUpPane.add(errorLabel);
		
		dateLabel = new JLabel("Insert date:");
		dateLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 13));
		dateLabel.setBounds(421, 178, 94, 16);
		popUpPane.add(dateLabel);
		
		
	}
	public ShopView getShopView() {
		return sv;
	}
	public Object[] getData() {
		
		String title = titleField.getText();
		String author = authorField.getText();
		String house = houseField.getText();
		int year = Integer.valueOf(yearField.getText());
		String isbn = isbnField.getText();
		Double price =Double.valueOf(priceField.getText());
		String desc = descField.getText();
		String genre = typeField.getText();		
		int bps = Integer.valueOf(pointField.getText());
		
		
		Object[] res = {title, author,house,year,isbn,genre,price,desc,bps};
		
		return res;
	}

	public void setError(String s) {
		errorLabel.setText(s);
		// TODO Auto-generated method stub
		
	}

	public boolean somethingNull() {
		if(titleField.getText().isEmpty() ||
				authorField.getText().isEmpty()||
				houseField.getText().isEmpty()||
				isbnField.getText().isEmpty()||
				yearField.getText().isEmpty()||
				priceField.getText().isEmpty()||
				descField.getText().isEmpty()||
				typeField.getText().isEmpty()||
				pointField.getText().isEmpty())
		return true;
		else 
			return false;
	}
}
