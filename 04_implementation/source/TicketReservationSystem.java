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

	}

	public void cancelReservation() {

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
