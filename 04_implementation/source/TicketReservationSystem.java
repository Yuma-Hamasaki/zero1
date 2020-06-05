package チケット予約システム;

import java.util.Date;

public class TicketReservationSystem {

	private CUI cui;

	private TicketList ticketList;

	private MemberList memberList;

	private ReservationList reservationList;
	
	private Member currentMember;

	public TicketReservationSystem(TicketList ticketList, MemberList memberList, ReservationList reservationList) {
		this.ticketList = ticketList;
		this.memberList = memberList;
		this.reservationList = reservationList;
		cui = new CUI();
	}

	public Member login() {
		Member user = null;
		while(user == null) {
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
		cui.showMessage("ログアウトしました");
		this.currentMember = null;
	}

	public void makeReservation() {
		this.viewTicket();
		Date date = new Date();
		Ticket ticket = null;
		int ticketAmount = 0;
		while(ticket == null) {
			int inputTicketNo = cui.inputTicketNo();
			for(Ticket tmpTicket : ticketList.getAllTicket()) {
				if(inputTicketNo == tmpTicket.getticketNo()) {
					ticket = tmpTicket;
					break;
				}
			}
			if(ticket == null) {
				System.out.println("指定されたチケットは存在しません");
				continue;
			}
			int inputTicketAmount = cui.inputTicketAmount();
			if(inputTicketAmount > ticket.getStock()) {
				ticket = null;
				System.out.println("在庫がありません");
			}
			else {
				ticketAmount = inputTicketAmount;
			}
			
		}
		boolean j = cui.confirm("予約してもよろしいですか？");
		if(j == true) {
			ticket.reduceStock(ticketAmount);
			int reservationNo = 0;
			reservationNo = (int)(Math.random()*10000);
			for(Reservation res : reservationList.getReservationList()) {
				if(res.getReservationNo() == reservationNo) {
					reservationNo++;
				}
			}
			Reservation  res = new Reservation(reservationNo,currentMember,ticket,ticketAmount, date);
			reservationList.addReservation(res);
			cui.display(reservationList.getAllReservation(currentMember.getId()));
		}
		
	}
	
	public void viewTicket() {
		cui.display(ticketList.getAllTicket());
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
		Reservation[] tmpres = new Reservation[1] ; 
		
		Ticket ticket = null;
		
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
			
			
		
			//ここまでは動きそう.番号一致していないが必ず出るようになってる
			for(Reservation res : this.reservationList.getReservationList()) {
				int resNum = res.getReservationNo();
				
				
				if(inputNumber == resNum) {
					canceledAmount = res.getAmount();
					ticket = res.getTicket();
					reservationFindFlag = false;
					tmpres[0] = res;
					break;
				}
			}
			if(reservationFindFlag == true) {
				cui.showMessage("予約番号が一致していません。再入力してください");
			}
		}
		
		if(cui.confirm("このまま予約をキャンセルしますか？")) {
			this.ticketList.addTicketStock(ticket.getticketNo(),canceledAmount);
			this.reservationList.deleteReservation(inputNumber);
			cui.showMessage("以下の予約をキャンセルしました");
			cui.display(tmpres);
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
					break;
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
