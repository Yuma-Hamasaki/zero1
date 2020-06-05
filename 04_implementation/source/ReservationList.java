package チケット予約システム;

import java.util.ArrayList;

public class ReservationList {

	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();

	public ReservationList() {

	}

	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}
	
	/**入力された予約番号と合致する予約を返す
	 * 
	 * @param reservationNo
	 * @return
	 */
	public Reservation getReservation(int reservationNo) {
		Reservation trnReservation = null; //リターン用変数
		for(Reservation res : reservations) {
			if(res.getReservationNo() == reservationNo) {
				trnReservation = res;
				break;
			}
		}
		
		return trnReservation;
	}
	
	
	/**予約を削除する
	 * 
	 * @param reservationNo
	 */
	public void deleteReservation(int reservationNo) {
		System.out.println("1");
		for(Reservation res : reservations) {
			
			if(res.getReservationNo() == reservationNo) {
				reservations.remove(res);
				break;
			}
		}
	}
	
	/**会員IDが合致する予約を全て配列で返す
	 * 
	 * @param memberID
	 * @return
	 */
	public Reservation[] getAllReservation(String memberID) {
		ArrayList<Reservation> rtnList = new ArrayList<Reservation>(); //リターン用リスト
		for(Reservation res : reservations) {
			if(memberID.equals(res.getMember().getId() ))
				rtnList.add(res);
		}
		Reservation[] resArray = rtnList.toArray(new Reservation[rtnList.size()]);
		return  resArray;
		
	}
	public ArrayList<Reservation> getReservationList(){
		return this.reservations;
	}

}
