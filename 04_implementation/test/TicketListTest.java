package チケット予約システム;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class TicketListTest {
	TicketList ticketList;
	Ticket ticket1;
	Ticket ticket2;
	Calendar cal;
	Date day1;
	Date day2;
	
	@Before
	public void setUp() {
		ticketList = new TicketList();
		
		cal = Calendar.getInstance();
		cal.set(2020, Calendar.JULY, 13);
	    day1 = cal.getTime();
	    
	    cal.set(2020, Calendar.AUGUST, 1);
	    day2 = cal.getTime();
		
		ticket1 = new Ticket(0001, "A1ライブ", 3000, day1, 4);
		ticket2 = new Ticket(0002, "B2ライブ", 4500, day2, 1);
		ticketList.addTicket(ticket1);
		ticketList.addTicket(ticket2);
	}
	
	@Test
	public void addTicketとgetTicketのテスト() {
		Ticket[] tArray = ticketList.getAllTicket();
		
		assertThat(tArray[0], sameInstance(ticket1));
		assertThat(tArray[1], sameInstance(ticket2));
	}

	@Test
	public void getTicketのテスト_1() {
		Ticket actual = ticketList.getTicket(0001, 1);
		
		assertThat(actual, sameInstance(ticket1));
	}

	@Test
	public void getTicketのテスト_2() {
		Ticket actual = ticketList.getTicket(0003, 2);
		
		assertThat(actual, nullValue());
	}

	@Test
	public void getTicketのテスト_3() {
		Ticket actual = ticketList.getTicket(0002, 2);
		
		assertThat(actual, nullValue());
	}
	
	@Test
	public void getTicketのテスト_4() {
		Ticket actual = ticketList.getTicket(0002, 1);
		
		assertThat(actual, is(ticket2));
	}
	
	@Test
	public void getTicketのテスト_5() {
		Ticket actual = ticketList.getTicket(0001, 0);
		
		assertThat(actual, nullValue());
	}

	@Test
	public void addTicketStockのテスト() {
		ticketList.addTicketStock(0001, 1);
		int actual = ticket1.getStock();
		int expected_result = 5;
		
		assertThat(actual, is(expected_result));
	}
	
	@Test
	public void reduceTicketStockのテスト() {
		ticketList.reduceTicketStock(0002, 1);
		int actual = ticket2.getStock();
		int expected_result = 0;
		
		assertThat(actual, is(expected_result));
	}


}
	