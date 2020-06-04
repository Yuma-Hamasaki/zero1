package チケット予約システム;

import java.util.Scanner;

public class CUI {
	Scanner scanner;
	public CUI() {
		scanner = new Scanner(System.in);
	}

	public String inputID() {
		String ID = null;
		System.out.print("IDを入力してください:");
		ID = scanner.nextLine();
		return ID;
	}
	
	public String inputPW() {
		String PW = null;
		System.out.print("パスワードを入力してください:");
		PW = scanner.nextLine();
		return PW;
	}

	public SystemFunction selectFunction() {
		SystemFunction systemfunction = null;
		System.out.println("0.ログアウトする");
		System.out.println("1.チケットを予約する");
		System.out.println("2.チケットを閲覧する");
		System.out.println("3.予約したチケットをキャンセルする");
		System.out.println("4.予約したチケットを閲覧する");
		System.out.println("9.システムを終了する");
		System.out.print("利用するサービスをを入力してください:");
		switch(scanner.nextInt()) {
			case 0: 
				systemfunction = SystemFunction.Logout;
				break;
			case 1:
				systemfunction = SystemFunction.TicketReservation;
				break;
			case 2:
				systemfunction = SystemFunction.TicketViewing;
				break;
			case 3:
				systemfunction = SystemFunction.CancelReservation;
				break;
			case 4:
				systemfunction = SystemFunction.ReservationViewing;
				break;
			case 9:
				systemfunction = SystemFunction.Quit;
				break;
			default:
		}
		return systemfunction;
	}

	public int inputReservationNo() {
		int reservationNo = -1;
		System.out.print("予約番号を入力してください:");
		reservationNo = scanner.nextInt();
		return reservationNo;
	}

	public int inputTicketNo() {
		int ticketNo = -1;
		System.out.print("チケット番号を入力してください:");
		ticketNo = scanner.nextInt();
		return ticketNo;
	}

	public int inputTicketAmount() {
		int ticketAmount = -1;
		System.out.print("チケット枚数を入力してください:");
		ticketAmount = scanner.nextInt();
		return ticketAmount;
	}

	public boolean confirm(String message) {
		boolean confirm = false;
		System.out.println(message);
		System.out.println("1.Yes それ以外:No");
		if(scanner.nextInt() == 1) {
			confirm = true;
		}
		return confirm;
	}

	public void display(Reservation[] displayedList) {
		for(Reservation reservation : displayedList) {
			System.out.println(reservation);
		}
	}

	public void display(Ticket[] displayedList) {
		for(Ticket ticket : displayedList) {
			System.out.println(ticket);
		}
	}

	public void showMessage(String message) {
		System.out.println(message);
	}

}
