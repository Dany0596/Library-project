package code;


import java.awt.EventQueue;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainView {
	public static void main(String[] args) {
		
		
		//
		ArrayList<Book> BookList = new ArrayList<Book>(); 
		try {
    		//Connection con= DBController.DB_Connection();
			Connection con = DBController.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM BOOKS");

            while (rs.next()) {
            	Book book=new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),
            					rs.getInt(8),rs.getString(9), rs.getInt(10),rs.getDate(11));
            	BookList.add(book);
            	System.out.println((BookList.indexOf(book) + 1));
            }
            con.close();
		} catch (SQLException ex) {
			System.out.println("Book list creation FAILED");
		}
		Collections.sort(BookList, new Comparator<Book>() {
			/*Date today = new Date();
			long settimaneB1 = 0;
			long settimaneB2 = 0;*/
			public int compare(Book b1, Book b2) {/*
				settimaneB1 = (today.getTime() - b1.getInsertDate().getTime())/(1000*3600*24*7);
				settimaneB2 = (today.getTime() - b2.getInsertDate().getTime())/(1000*3600*24*7);
				int diff = (int)(((b2.getCopies()/settimaneB2)-(b1.getCopies()/settimaneB1))*100);*/
				int diff=b2.getCopies()-b1.getCopies();
				return diff;
			}
		});
		
		ArrayList<Classifica> rankList = new ArrayList<Classifica>();
		try {
			Connection con = DBController.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM RANK ORDER BY position");

            while (rs.next()) {
            	Classifica l =new Classifica(rs.getString(1),rs.getDate(3),rs.getInt(2));
            	System.out.println(l.getISBN().toString() +" "+ l.getPosizione() + " " +l.getDate() );
            	rankList.add(l);
            }
            con.close();
		} catch (SQLException ex) {
			System.out.println("Rank list creation FAILED");
		}
		
		
		 //UPDATE RANK LIST DA PORTARE ALL'ADMIN
		//CHIAMARE LA FUNZIONE getClassifica al passaggio da registView o login view
		/*
		try {
			String isbn;
			String updateRanking="UPDATE RANK SET position=?, positionDate=DEFAULT WHERE isbn=? ";
			Connection con = DBController.getConnection();
			PreparedStatement pst;
			
			for(Book x : BookList) {
				isbn= x.getISBN();
				for(Classifica y : rankList) {
					if(y.getISBN().equals(x.getISBN())){
						if(y.getPosizione()!= (BookList.indexOf(x) + 1)){
							System.out.println("Updating C:"+ y.getISBN() +" B:"+x.getISBN());
							System.out.println("Da posizione C:" + y.getPosizione() +" a B:" + (BookList.indexOf(x) + 1));
							pst=con.prepareStatement(updateRanking);
							pst.setInt(1,BookList.indexOf(x) + 1 );
							pst.setString(2, x.getISBN());
							pst.execute();
							y.setPosizione(BookList.indexOf(x)+1); // TODO:
							y.setDate(new Date());
							
						}
					}
				}
			}
		}catch(SQLException ex2) {
			System.out.println("Checking failed!" + ex2);
		}*/
		
		//CREAZIONE DB PER RANKING
		
		/*
		Connection c1 = DBController.getConnection();
		PreparedStatement pst2;
		String query = "INSERT INTO RANK VALUES(?,?)";
		int i = 1;
		try {
			for(Book x: BookList) {
					
					pst2=c1.prepareStatement(query);
					pst2.setString(1, x.getISBN());
					pst2.setInt(2, i);
					i++;
					pst2.execute();
				
			}
				c1.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					LoginView frame = new LoginView(BookList);
					frame.setVisible(true);
					frame.setResizable(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		);
	}
}


