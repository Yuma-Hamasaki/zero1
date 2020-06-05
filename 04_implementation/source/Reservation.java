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

	public Reservation(int reservationNo,Member member, Ticket ticket, int reservationAmount, 
			Date reservationDate ) {
		this.reservationNo = reservationNo;
		this.member = member;
		this.ticket = ticket;
		this.reservationAmount = reservationAmount;
		this.reservationDate = reservationDate;
	}

	public int getAmount() {
		return this.reservationAmount;
	}
	
	
	public Member getMember() {
		return this.member;
	}

	public int getReservationNo() {
		return this.reservationNo;
	}
	public Ticket getTicket() {
		
		return this.ticket;
	}
	
	@Override
	public String toString() {
		String str;
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(this.reservationDate);
		
		str = "予約番号 : " + this.reservationNo
		+ "\n" +"会員名 : " + this.member.getName()
		+ "\n" + "チケット名 : " + this.ticket.getName()
		+ "\n" + "予約日 : " + formattedDate 
		+ "\n" + "予約枚数 : " + this.reservationAmount ;
		
		return str;
	}

}
