package チケット予約システム;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ticket {

	private int ticketNo;

	private String ticketName;

	private int price;

	private Date eventDate;

	private int stock;

	public Ticket(int ticketNo, String ticketName, int price, Date eventDate, int stock) {
		this.ticketNo = ticketNo;
		this.ticketName = ticketName;
		this.price = price;
		this.eventDate = eventDate;
		this.stock = stock;
	}
	
	public int getticketNo() {
		return this.ticketNo;
	}

	public void addStock(int canceledAmount) {
		this.stock += canceledAmount;
	}

	public void reduceStock(int reservationAmount) {
		this.stock -= reservationAmount;
	}

	public int getStock() {
		return this.stock;
	}

	public String getName() {
		return this.ticketName;
	}
	public String toString() {
		String str;
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(this.eventDate);
		
		str = "チケット番号 : " + this.ticketNo +
				"\n" + "チケット名 : " + this.ticketName + 
				"\n" + "価格 : " + this.price + "円"+
				"\n" + "開催日 : " + formattedDate + 
				"\n" + "在庫数 : " + this.stock;

		return str;
	}

}
