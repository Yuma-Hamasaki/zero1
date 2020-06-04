package チケット予約システム;

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

	public void addStock(int canceledAmount) {
		this.stock += canceledAmount;
	}

	public void reduceStock(int reservationAmount) {
		this.stock -= reservationAmount;
	}

	public int getStock() {
		return this.stock;
	}

	public String toString() {
		String str;
		str = this.ticketNo + "¥n" +  this.ticketName + "¥n" + 
				this.price + "¥n" + this.eventDate + "¥n" + 
				this.stock;

		return str;
	}

	public String getName() {
		return this.ticketName;
	}

}
