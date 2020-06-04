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
		return null;
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
		reservationList.getAllReservation(currentMember.getId());
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
