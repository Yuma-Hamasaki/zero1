package チケット予約システム;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {

	private int reservationNo;

	private Date reservationDate;

	private int reservationAmount;

	private Member member;

	private Ticket ticket;

	public Reservation(Member member, Ticket ticket, int reservationAmount, 
			Date reservationDate ) {
		this.member = member;
		this.ticket = ticket;
		this.reservationAmount = reservationAmount;
		this.reservationDate = reservationDate;
	}


	public int getAmount() {
		return this.reservationAmount;
	}

	public boolean checkMatchID(String memberID) {
		if(this.member.getId() == memberID) {
			return true;
		}
		return false;
	}

	public int getReservationNumber() {
		return this.reservationNo;
	}
	
	public String toString() {
		String str;
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(this.reservationDate);
		
		str = "予約番号 : " 
		+ "\n" +"会員名 : " + this.member.getName()
		+ "\n" + "チケット名 : " + this.ticket.getName()
		+ "\n" + "予約日 : " + formattedDate 
		+ "\n" + "予約枚数 : " + this.reservationAmount ;
		
		return str;
	}

}
