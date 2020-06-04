package チケット予約システム;

import java.util.Date;

public class Reservation {

	private int reservationNo;

	private Date reservationDate;

	private int reservationAmount;

	private Member member;

	private Ticket ticket;

	public Reservation(Member member, Ticket ticket, int reservationAmount) {
		this.member = member;
		this.ticket = ticket;
		this.reservationAmount = reservationAmount;
	}

	public String changeReservationInfo() {
		return null;
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

}
