package チケット予約システム;

import java.util.ArrayList;

public class ReservationList {

	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();

	public ReservationList() {

	}

	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}

	public Reservation getReservation(int reservationNo) {
		Reservation trnReservation = null; //リターン用変数
		for(Reservation res : reservations) {
			if(res.getReservationNo() == reservationNo)
				trnReservation = res;
				break;
		}
		
		return trnReservation;
	}
	
	public void deleteReservation(int reservationNo) {
		for(Reservation res : reservations) {
			if(res.getReservationNo() == reservationNo)
				reservations.remove(res);
		}
	}

	public Reservation[] getAllReservation(String memberID) {
		ArrayList<Reservation> rtnList = new ArrayList<Reservation>(); //リターン用リスト
		for(Reservation res : reservations) {
			if(res.getMember().getId() == memberID)
				rtnList.add(res);
		}
		Reservation[] resArray = rtnList.toArray(new Reservation[rtnList.size()]);
		return  resArray;
		
	}

}
