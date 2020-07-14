package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JButton;

public class AddPopUpListener implements ActionListener {

	private ShopView sv;
	private AddPopUp apu;
	private Object[] data;

	private String[] genreChart= {	"Best Seller","Drama",
			"Horror", "Kitchen", 
			"For Kids", "Sci-fi",
			"Science", "Crime", 
			"Thriller", "Adventure",
			"Storytelling", "Fiction",
			"Learning", "Fantasy"};
	
	public AddPopUpListener(ShopView sv, AddPopUp apu) {
		this.sv = sv;
		this.apu = apu;
		this.data = apu.getData();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			//{0title, 1author,2house,3year,4isbn,5genre,6price,7desc,8bps,9date}
			if(button.getText().equals("Confirm")) {
				if(apu.somethingNull())
					return;
				
				String title = data[0].toString();
				String author = data[1].toString();
				String house = data[2].toString();
				String isbn = data[4].toString();
				String desc = data[7].toString();
				String genre = data[5].toString();
				
				if(isbn.length()!= 13 || isbn.matches(".*[a-z].*")) {
					apu.setError("Can't process");
					return;
				}

				int year;
				Double price;
				int bps;
				
				try {
					year = Integer.parseInt(data[3].toString());
					price =Double.valueOf(data[6].toString());
					bps = Integer.valueOf(data[8].toString());
				} catch(NumberFormatException nfe) {
					apu.setError("Can't process");
					return;
				}
				
				if( year < 0) {
					apu.setError("Can't process");
					return;
				}

				if( bps < 0) {
					apu.setError("Can't process");
					return;
				}
				
				
				Boolean flag = false;
				for(String s : genreChart) {
					if(s.equals(data[5].toString()))
						flag = true;
				}
				if(flag == false) {
					apu.setError("Can't process");
					return;
				}
				
				Book l = new Book(title, author,house,year,isbn,genre,price,0,desc,bps, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
				final String qAddBook = "INSERT INTO BOOKS VALUES(?,?,?,?,?,?,?,?,?,?,?)";
				final String qAddBookRank ="INSERT INTO RANK VALUES(?,?,?)";
		        //Connection con = DBController.DB_Connection();
				Connection con = DBController.getConnection();
		        PreparedStatement pst,pst2;
		        try {
		            pst = con.prepareStatement(qAddBook);
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
		            pst.setDate(11, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		            
		            pst.execute();
		            
		            pst2 = con.prepareStatement(qAddBookRank);
		            pst2.setString(1, l.getISBN());
		            pst2.setInt(2,sv.getBookList().size()+1);
		            pst2.setDate(3,l.getInsertDate());
		            pst2.execute();
		            
		            con.close();
		        } catch (SQLException ex) {
		            System.out.println(ex);
		            return;
		        }
				
				String priceP = String.format("%.2f",l.getPrice());
				Object[] temp = {l.getTitle(),l.getAuthors(),l.getISBN(),priceP};
				sv.getModel().addRow(temp);
				sv.refreshBooks(l);
				sv.setClassifica();
				apu.dispose();
				
			}
			if(button.getText().equals("Cancel")) {
				apu.dispose();
			}
				
		
	}

}
