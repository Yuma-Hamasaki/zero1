package チケット予約システム;

import java.util.List;
import java.util.ArrayList;

public class TicketList {

	private List<Ticket> ticketList = new ArrayList<Ticket>();
	
	public TicketList() {

	}
	
	public void addTicket(Ticket ticket) {
		ticketList.add(ticket);
	}
	
	public Ticket getTicket(int ticketNo, int reservationAmount) {
		// 予約枚数が0以下の場合
		if(reservationAmount <= 0) return null;
		
		for(Ticket ticket: ticketList) {
			if(ticketNo == ticket.getticketNo()) {
				// 予約枚数が在庫を上回っている場合
				if(ticket.getStock() < reservationAmount) {
					return null;
				}
				return ticket;
			}
		}
		return null;
	}
	
	public void addTicketStock(int ticketNo, int cancelAmount) {
		for(Ticket ticket: ticketList) {
			if(ticketNo == ticket.getticketNo()) {
				ticket.addStock(cancelAmount);
				break;
			}
		}
	}
	
	public void reduceTicketStock(int ticketNo, int reservationAmount) {
		for(Ticket ticket: ticketList) {
			if(ticketNo == ticket.getticketNo()) {
				ticket.reduceStock(reservationAmount);
				break;
			}
		}
	}
	
	public Ticket[] getAllTicket() {
		return ticketList.toArray(new Ticket[ticketList.size()]);
	}

}
