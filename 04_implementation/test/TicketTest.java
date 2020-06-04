package チケット予約システム;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TicketTest {
	
	Calendar cal = Calendar.getInstance();
	Date date = new Date();
	
	@Before
	public void setUp() {
	    cal.set(2020, Calendar.JULY, 15);
	    date = cal.getTime();
	    
	}
	 
	@Test
	public void test1(){
		Ticket ticket1 = new Ticket(1,"A1ライブ",3000,date,4) ;
		System.out.println(ticket1);
		
	
	}		

}
