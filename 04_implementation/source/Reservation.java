package 設計;

import 分析.Date;

public class Reservation {

	private int reservationNo;

	private Date reservationDate;

	private int reservationAmount;

	private Member member;

	private Ticket ticket;

	public Reservation(Member member, Ticket ticket, int reservationAmount) {

	}

	public String changeReservationInfo() {
		return null;
	}

	public int getAmount() {
		return 0;
	}

	public boolean checkMatchID(String memberID) {
		return false;
	}

	public int getReservationNumber() {
		return 0;
	}

}
