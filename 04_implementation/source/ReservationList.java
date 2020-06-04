package チケット予約システム;

import java.util.ArrayList;
import java.util.List;

public class ReservationList {
	//ReservationListクラスが返す配列の戻り値は、すべてList型にする。
	private List<Reservation> reservationList = new ArrayList<Reservation>();

	public ReservationList() {

	}

	public void addReservation(Reservation reservation) {
		reservationList.add(reservation);
	}
	/*
	public Reservation getReservation(int reservationNo) {
		
		return null;
	}
	*/
	public int getAmount(int reservationNo) {
		for(Reservation rsv : reservationList) {
			int currentNo = rsv.getReservationNo();
			if(reservationNo == currentNo) {
				return rsv.getAmount();
			}
		}
		return 0;
	}

	public void deleteReservation(int reservationNo) {
		for(int i=0; i<reservationList.size(); i++) {
			Reservation rsv = reservationList[i]
			int currentNo = rsv.getReservationNo();
			if(reservationNo == currentNo) {
				reservationList.remove(i);
			}
		}

	}

	public List<Reservation> getAllReservation(String memberID) {
		List<Reservation> returnList = new ArrayList<Reservation>();
		for(int i=0; i<reservationList.size(); i++) {
			Reservation rsv = reservationList[i]
			if(rsv.checkMatchID(memberID)) {
				returnList.add(rsv);
			}
		}
		if(returnList.size()==0) {
			return null;
		}else {
			return returnList;
		}
	}

}
