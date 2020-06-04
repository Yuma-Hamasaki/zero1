package チケット予約システム;

public class TicketReservationSystem {

	private CUI cui;

	private TicketList ticketList;

	private MemberList memberList;

	private ReservationList reservationList;
	
	private Member currentMember;

	public TicketReservationSystem(TicketList ticketList, MemberList memberList, ReservationList reservationList) {

	}

	public Member login() {
		Member user = null;
		while(user != null) {
			String ID = cui.inputID();
			String password = cui.inputPW();
			user = memberList.searchMember(ID,password);
			if(user == null) {
				cui.showMessage("ログイン情報が間違っています");
			}
		}
		return user;
	}

	public void logout() {
		this.currentMember = null;
	}

	public void makeReservation() {
		
	}

	public void viewTicket() {

	}

	public void viewReservation() {
		Reservation[] reservationList = this.reservationList.getAllReservation(currentMember.getId());
		
		if(reservationList != null) {
			cui.display(reservationList);
		}
		else {
			cui.showMessage("現在予約されているチケットはありません。\n機能選択画面へ戻ります。\n");
			return;
		}
	}

	public void cancelReservation() {
		Reservation[] reservationList = this.reservationList.getAllReservation(currentMember.getId());
		int inputNumber = 0;
		int canceledAmount = 0;
		
		if(reservationList != null) {
			cui.display(reservationList);
		}
		else {
			cui.showMessage("現在予約されているチケットはありません。\n機能選択画面へ戻ります。\n");
			return;
		}
		
		boolean reservationFindFlag = true;
		while(reservationFindFlag) {
			boolean con = cui.confirm("予約キャンセルを続けますか？");
			if(con == false) {
				cui.showMessage("機能選択画面に戻ります。\n");
				return;
			}
			
			while(true) {
				inputNumber = cui.inputReservationNo();
				
				if(inputNumber != -1) {
					break;
				}
			}
			
			for(Reservation res: reservationList) {
				int resNum = res.getReservationNo();
				
				if(inputNumber == resNum) {
					canceledAmount = res.getAmount();
					reservationFindFlag = false;
					break;
				}
			}
			cui.showMessage("予約番号が一致していません。再入力してください");
		}
		
		if(cui.confirm("このまま予約をキャンセルしますか？")) {
			this.ticketList.addTicketStock(inputNumber,canceledAmount);
			this.reservationList.deleteReservation(inputNumber);
		}
		else {
			return;
		}
	}

	public void start() {
		while(true) {
			currentMember = login();
			while(currentMember != null) {
				SystemFunction func = cui.selectFunction();
				if(func == SystemFunction.Logout) {
					logout();
				}
				switch(func) {
					case TicketReservation:
						makeReservation();
						break;
					case TicketViewing:
						viewTicket();
						break;
					case CancelReservation:
						cancelReservation();
						break;
					case ReservationViewing:
						viewReservation();
						break;
					case Quit:
						return;
					default:
						cui.showMessage("入力値が不適切です");
				}
			}
		}

	}

}
