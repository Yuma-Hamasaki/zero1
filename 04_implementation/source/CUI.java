package チケット予約システム;

import java.util.Scanner;

public class CUI {
	Scanner scanner;
	public CUI() {
		scanner = new Scanner(System.in);
	}

	public String inputID() {
		String ID = null;
		System.out.println("----------------------");
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
		System.out.println("----------------------");
		System.out.println("利用サービスを表示します");
		System.out.println("0.ログアウトする");
		System.out.println("1.チケットを予約する");
		System.out.println("2.チケットを閲覧する");
		System.out.println("3.予約したチケットをキャンセルする");
		System.out.println("4.予約したチケットを閲覧する");
		System.out.println("9.システムを終了する");
		System.out.println("利用するサービスをを入力してください:");
		
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
				systemfunction = null;
		}
		return systemfunction;
	}

	public int inputReservationNo() {
		int reservationNo = 0;
		System.out.print("予約番号を入力してください:");
		try {
			reservationNo = scanner.nextInt();
		}catch(Exception e) {
			reservationNo = -1;
		}
		return reservationNo;
	}

	public int inputTicketNo() {
		int ticketNo;
		System.out.print("チケット番号を入力してください:");
		try {
			ticketNo = scanner.nextInt();
		}catch(Exception e) {
			ticketNo = -1;
		}
		return ticketNo;
	}

	public int inputTicketAmount() {
		int ticketAmount;
		System.out.print("チケット枚数を入力してください:");
		try {
			ticketAmount = scanner.nextInt();
		}catch(Exception e) {
			ticketAmount = -1;
		}
		return ticketAmount;
	}

	public boolean confirm(String message) {
		boolean confirm = false;
		int inputConfirm = 0;
		System.out.println(message);
		System.out.println("1.Yes それ以外:No");
		try {
			inputConfirm = scanner.nextInt();
		}catch(Exception e) {
			inputConfirm = -1;
		}
		if(inputConfirm == 1) {
			confirm = true;
		}
		return confirm;
	}

	public void display(Reservation[] displayedList) {
		for(Reservation reservation : displayedList) {
			System.out.println("----------------------");
			System.out.println(reservation);
		}
	}

	public void display(Ticket[] displayedList) {
		for(Ticket ticket : displayedList) {
			System.out.println("----------------------");
			System.out.println(ticket);
		}
	}

	public void showMessage(String message) {
		System.out.println(message);
	}

}
