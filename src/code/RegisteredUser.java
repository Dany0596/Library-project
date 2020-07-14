package code;
import java.util.Date;

public class RegisteredUser {
	

	private String name;
	private String surname;
	private String address;
	private int cap;
	private String city;
	private String country;
	private String telephone;
	private String email;
	private String password;
	private int librocard;
	private int bookPoints;
	private Date ReleaseDate;
	private boolean master;
	

	public RegisteredUser(String name,String surname,String address,int cap,String city,String country,String telephone,String email,String password,int librocard,int bookPoints,Date ReleaseDate,boolean master){		
		this.name=name;
		this.surname=surname;
		this.address=address;
		this.cap=cap;
		this.city=city;
		this.country=country;
		this.telephone=telephone;
		this.email=email;
		this.password=password;
		this.librocard=librocard;
		this.bookPoints= bookPoints;
		this.ReleaseDate= ReleaseDate;
		this.master=master;
	}
	
	public int getBookPoints() {
		return bookPoints;
	}

	public void setBookPoints(int bookPoints) {
		this.bookPoints = bookPoints;
	}

	public boolean isMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public int getLibrocard() {
		return librocard;
	}

	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getAddress() {
		return address;
	}
	public int getCap() {
		return cap;
	}
	public String getCity() {
		return city;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public int librocard() {
		return librocard;
	}
	public Date getReleaseDate() {
		return ReleaseDate;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return email.hashCode();
	}@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof RegisteredUser && ((RegisteredUser)obj).getEmail().equals(email);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLibrocard(int librocard) {
		this.librocard = librocard;
	}

	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	} 
}