package code;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Classifica {

	private String ISBN;
	private int posizione;
	private Date date;

	public Classifica(String ISBN, Date date, int posizione) {
		this.ISBN = ISBN;
		this.posizione = posizione;
		this.date = date;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public int getPosizione() {
		return posizione;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long settimaneInClassifica(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) / 7;
	}
	
	
}
