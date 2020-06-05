package チケット予約システム;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class ReservationListTest {
	ReservationList rList;
	Ticket ticket1;
	Ticket ticket2;
	Member member1;
	Member member2;
	Reservation reserv1;
	
	Date day1, day2, day3;

	@Before
	public void setUp() {
		Calendar cal = Calendar.getInstance();
		
		cal.set(2020, Calendar.JULY, 13);
		day1 = cal.getTime();
		
		cal.set(2020, Calendar.AUGUST, 1);
		day2 = cal.getTime();

		cal.set(2020, Calendar.JUNE, 5);
		day3 = cal.getTime();

		
		rList = new ReservationList();
		ticket1 = new Ticket(0001, "A1ライブ", 3000, day1, 4);
		ticket2 = new Ticket(0002, "B2ライブ", 4500, day2, 1);
		member1 = new Member("t-tanaka", "Sswgtnk11", "田中太郎");
		member2 = new Member("r-yoshida", "HHdawko2i2", "吉田流星");
		reserv1 = new Reservation(1000, member1, ticket1, 2, day3);
		
		rList.addReservation(reserv1);
	}

	@Test
	public void testCase01() {
		rList.addReservation(reserv1);
		Reservation actual = rList.getReservation(reserv1.getReservationNo());
		
		System.out.println(actual);
	}
	
	@Test
	public void testCase02() {
		Reservation reserv2 = new Reservation(1000, member1, ticket2, 1, day3);
		Reservation reserv3 = new Reservation(2000, member2, ticket1, 1, day3);
		
		rList.addReservation(reserv2);
		rList.addReservation(reserv3);
		
		Reservation[] actual = rList.getAllReservation("t-tanaka");
		Reservation[] expected_result = new Reservation[2];
		expected_result[0] = reserv1;
		expected_result[1] = reserv2;
		
		System.out.println("test02, actual:");

		assertThat(actual[0], sameInstance(expected_result[0]));
		assertThat(actual[1], sameInstance(expected_result[1]));
	}
	
	@Test
	public void testCase03() {
		Reservation reserv2 = new Reservation(1000, member1, ticket2, 1, day3);
		
		int actual = reserv2.getAmount();
		int expected_result = 1;

		assertThat(actual,is(expected_result));
	}
	
	@Test
	public void testCase04() {
		Reservation reserv2 = new Reservation(1000, member1, ticket2, 1, day3);
		rList.addReservation(reserv2);
		
		rList.deleteReservation(reserv2.getReservationNo());
		Reservation[] actual = rList.getAllReservation("t-tanaka");
		
		System.out.println(actual[0]);
	}

}