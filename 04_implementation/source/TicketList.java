package チケット予約システム;

import java.util.List;
import java.util.ArrayList;

public class TicketList {
	
	private List<Ticket> ticketList = new ArrayList<Ticket>();
	
	public TicketList() {

	}
	//チケットの在庫数を増やす
	public void addTicket(Ticket ticket) {
		ticketList.add(ticket);
	}
	
	/**該当するチケットを返す
	 * 
	 * @param ticketNo
	 * @param reservationAmount
	 * @return
	 */
	public Ticket getTicket(int ticketNo) {
		for(Ticket ticket: ticketList) {
			if(ticketNo == ticket.getticketNo()) {
				return ticket;
			}
		}
		return null;
	}
	/**チケットの在庫数を増やす
	 * 
	 * @param ticketNo
	 * @param cancelAmount
	 */
	
	public void addTicketStock(int ticketNo, int cancelAmount) {
		for(Ticket ticket: ticketList) {
			if(ticketNo == ticket.getticketNo()) {
				ticket.addStock(cancelAmount);
				break;
			}
		}
	}
	
	/**チケットの在庫数を減らす
	 * 
	 * @param ticketNo
	 * @param reservationAmount
	 */
	public void reduceTicketStock(int ticketNo, int reservationAmount) {
		for(Ticket ticket: ticketList) {
			if(ticketNo == ticket.getticketNo()) {
				ticket.reduceStock(reservationAmount);
				break;
			}
		}
	}
	
	//リスト型を配列に変換して返す
	public Ticket[] getAllTicket() {
		return ticketList.toArray(new Ticket[ticketList.size()]);
	}

}
