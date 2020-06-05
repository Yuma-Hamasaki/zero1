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
		for(Ticket ticket: ticketList) {
			if(ticketNo == ticket.getticketNo()) {
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
