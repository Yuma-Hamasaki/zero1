package チケット予約システム;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

public class CUI_Test {
	CUI cui;
	@Before
	public void Setup() {
		cui = new CUI();
	}
	
	@Test
	public void Test1() {
		String actual = cui.inputID();
		String expected_ID = "t-tanaka";
		assertThat(actual ,is(expected_ID));
	}
	
	@Test
	public void Test2() {
		String actual = cui.inputPW();
		String expected_PW = "Sswgtnk11";
		assertThat(actual ,is(expected_PW));
	}
	
	@Test
	public void Test3_1() {
		SystemFunction actual = cui.selectFunction();
		SystemFunction expected_select = SystemFunction.Logout;
		assertThat(actual ,is(expected_select));
	}
	@Test
	public void Test3_2() {
		SystemFunction actual = cui.selectFunction();
		SystemFunction expected_select = SystemFunction.TicketReservation;
		assertThat(actual ,is(expected_select));
	}
	@Test
	public void Test3_3() {
		SystemFunction actual = cui.selectFunction();
		SystemFunction expected_select = SystemFunction.TicketViewing;
		assertThat(actual ,is(expected_select));
	}
	@Test
	public void Test3_4() {
		SystemFunction actual = cui.selectFunction();
		SystemFunction expected_select = SystemFunction.CancelReservation;
		assertThat(actual ,is(expected_select));
	}
	@Test
	public void Test3_5() {
		SystemFunction actual = cui.selectFunction();
		SystemFunction expected_select = SystemFunction.ReservationViewing;
		assertThat(actual ,is(expected_select));
	}
	@Test
	public void Test3_6() {
		SystemFunction actual = cui.selectFunction();
		SystemFunction expected_select = SystemFunction.Quit;
		assertThat(actual ,is(expected_select));
	}
	@Test
	public void Test3_7() {
		SystemFunction actual = cui.selectFunction();
		SystemFunction expected_select = null;
		assertThat(actual ,is(expected_select));
	}
	@Test
	public void Test3_8() {
		SystemFunction actual = cui.selectFunction();
		SystemFunction expected_select = null;
		assertThat(actual ,is(expected_select));
	}
	@Test
	public void Test3_9() {
		SystemFunction actual = cui.selectFunction();
		SystemFunction expected_select = null;
		assertThat(actual ,is(expected_select));
	}
	@Test
	public void Test4_1() {
		int actual = cui.inputReservationNo();
		int expected_No = 1;
		assertThat(actual ,is(expected_No));
	}
	@Test
	public void Test4_2() {
		int actual = cui.inputReservationNo();
		int expected_No = -1;
		assertThat(actual ,is(expected_No));
	}
	@Test
	public void Test5_1() {
		int actual = cui.inputTicketNo();
		int expected_No = 1;
		assertThat(actual ,is(expected_No));
	}
	@Test
	public void Test5_2() {
		int actual = cui.inputTicketNo();
		int expected_No = -1;
		assertThat(actual ,is(expected_No));
	}
	@Test
	public void Test6_1() {
		int actual = cui.inputTicketAmount();
		int expected_No = 1;
		assertThat(actual ,is(expected_No));
	}
	@Test
	public void Test6_2() {
		int actual = cui.inputTicketAmount();
		int expected_No = -1;
		assertThat(actual ,is(expected_No));
	}
	@Test
	public void Test7_1() {
		boolean actual = cui.confirm("動作を完了します.よろしいですか");
		boolean expected_bool = true;
		assertThat(actual ,is(expected_bool));
	}
	@Test
	public void Test7_2() {
		boolean actual = cui.confirm("動作を完了します.よろしいですか");
		boolean expected_bool = false;
		assertThat(actual ,is(expected_bool));
	}
	@Test
	public void Test7_3() {
		boolean actual = cui.confirm("動作を完了します.よろしいですか");
		boolean expected_bool = false;
		assertThat(actual ,is(expected_bool));
	}
	@Test
	public void Test8() {
		cui.showMessage("出力の確認");
	}
}

