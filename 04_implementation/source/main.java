package チケット予約システム;

import java.util.Calendar;
import java.util.Date;

public class main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		//会員インスタンス作成
		Member tanaka = new Member("t-tanaka", "crsctnk11", "田中太郎");
		Member yoshida = new Member("r-yoshida", "crscysd22", "吉田流星");
		
		//会員一覧インスタンス作成
		MemberList memberList = new MemberList();
		memberList.addMember(tanaka);
		memberList.addMember(yoshida);
		
		//イベント開催作成
		Calendar cal = Calendar.getInstance();
		cal.set(2020, Calendar.JULY, 15);
		Date date1 = cal.getTime();
		
		Calendar cal2 = Calendar.getInstance();
		cal.set(2020, Calendar.AUGUST, 01);
		Date date2 = cal2.getTime();
		
		//チケットインスタンス作成
		Ticket a1live = new Ticket(1,"A1ライブ",3000,date1,4);
		Ticket b2live = new Ticket(2,"B2ライブ",4500,date2,1);
		
		//チケット一覧インスタンス作成
		TicketList ticketList = new TicketList();
		ticketList.addTicket(a1live);
		ticketList.addTicket(b2live);
		
		//予約一覧インスタンス作成
		ReservationList reservationList = new ReservationList();
		
		//チケット予約システムインスタンス作成
		TicketReservationSystem TRS = new TicketReservationSystem(ticketList,memberList,reservationList);
		TRS.start();
		
		

	}

}
