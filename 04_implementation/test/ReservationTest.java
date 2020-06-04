package チケット予約システム;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class ReservationTest {
	Ticket ticket;
	Member yoshida;
	Reservation reserv;

	@Before
	public void setUp() {
		Calendar cal = Calendar.getInstance();

		cal.set(2020, Calendar.AUGUST, 1);
		Date day1 = cal.getTime();
		ticket = new Ticket(0002, "B2ライブ", 4500, day1, 1);
		yoshida = new Member("r-yoshida", "HHdawko2i2", "吉田流星");
		reserv = new Reservation(yoshida, ticket, 1);
	}

	@Test
	public void checkMatchIDのテスト_trueの場合() {
		boolean actual = reserv.checkMatchID("r-yoshida");
		boolean expected_result = true;

		assertThat(actual,is(expected_result));
	}
	
	@Test
	public void checkMatchIDのテスト_falseの場合() {
		boolean actual = reserv.checkMatchID("t-yoshida");
		boolean expected_result = false;

		assertThat(actual,is(expected_result));		
	}
}