package code;
/*
public class Book {
	private String title;
	private String authors;
	private String house;
	private int year;
	private String ISBN;
	private String type;
	private double price;
	private int copies;
	private String description;
	private int bookPoint;
	
	public Book( String title, String authors,  String house, int year, String ISBN, String type, double price, int copies, String description, int bookPoint) {
	
		this.title=title;
		this.authors = authors;
		this.house = house;
		this.year = year;
		this.ISBN = ISBN;
		this.type = type;
		this.price = price;
		this.copies = copies;
		this.description= description;
		this.bookPoint = bookPoint;
	}
	
	
	//		******* funziione per ottenere i dati *******
	public String getTitle() {
		return title;
	}
	
	public String getAuthors() {
		return authors;
	}
	
	public String getHouse() {
		return house;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public String getType() {
		return type;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getCopies() {
		return copies;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getBookPoint() {
		return bookPoint;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}


	public void setAuthors(String authors) {
		this.authors = authors;
	}


	public void setHouse(String house) {
		this.house = house;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public void setCopies(int copies) {
		this.copies = copies;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setBookPoint(int bookPoint) {
		this.bookPoint = bookPoint;
	}


	//		****** equals ******
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Book && ((Book)obj).ISBN == this.ISBN;
	}
	//		****** hashCode ******
	
	@Override
	public int hashCode() {
		return Integer.parseInt(ISBN);
	}
	
	
}*/
import java.sql.*;
    

public class Book {


	private  String title;
	private  String authors;
	private  String house;
	private  int year;
	private  String ISBN;
	private  String genre;
	private  double price;
	private  int copies;
	private  String description;
	private  int bookPoint;
	private Date insertDate;

	  
	
	 	 
	
	public Book(String title,String authors,String house,int year,String ISBN,String genre,double price,int copies,String description,int bookPoint,Date insertDate){
			this.title=title;
			this.authors=authors;
			this.house=house;
			this.year=year;
			this.ISBN=ISBN;
			this.genre=genre;
			this.price=price;
			this.copies=copies;
			this.description=description;
			this.bookPoint=bookPoint;
			//problema con inserimento della data <======================================
			this.insertDate= insertDate;
	}
	


	@Override
	public boolean equals(Object obj) {
		
		return obj instanceof Book && ((Book)obj).getISBN().equals(ISBN) ;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthors() {
		return authors;
	}
	public String getHouse() {
		return house;
	}
	public int getYear() {
		return year;
	}
	public String getISBN() {
		return ISBN;
	}
	public String getGenre() {
		return genre;
	}
	public double getPrice() {
		return price;
	}
	public int getCopies() {
		return copies;
	}
	public String getDescription() {
		return description;
	}

	public int getBookPoint() {
		return bookPoint;
	}

	
	@Override
	public int hashCode() {
		
		return ISBN.hashCode();
	}
	@Override
	public String toString() {

		return "Tittle: " + getTitle()+ "\n" +
				"Authors: "+ getAuthors()+ "\n" + "House: "+getHouse()+"\t year:"+ getYear()+"\n"+
				"ISBN : "+ getISBN() + "\t Type: " +getGenre()+ "\n"+
				"Price: "+ getPrice()+"$"+ "\t Available copies: "+ getCopies() +"\t Bookpoint: "+ getBookPoint() + "\n"+
				"\nDescription: " + getDescription()+
				"\n_____________________________________________________________________________________________\n";
	}


	public Date getInsertDate() {
		return insertDate;
	}



	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public void setAuthors(String authors) {
		this.authors = authors;
	}



	public void setHouse(String house) {
		this.house = house;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public void setCopies(int copies) {
		this.copies = copies;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public void setBookPoint(int bookPoint) {
		this.bookPoint = bookPoint;
	}

}	

