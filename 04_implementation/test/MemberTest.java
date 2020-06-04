package チケット予約システム;

import static org.junit.Assert.*;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class MemberTest {
	Member tanaka;
	Member yoshida;
	
	@Before
	public void setUp() {
		tanaka = new Member("t-tanaka", "Sswgtnk11", "田中太郎");
		yoshida = new Member("r-yoshida", "HHdawko2i2", "吉田流星");
	}
	
	@Test
	public void getIdのテスト() {
		String actual = tanaka.getId();
		String expected_result = "t-tanaka";

		assertThat(actual,is(expected_result));
	}
	
	@Test
	public void getPasswordのテスト() {
		String actual = yoshida.getPassword();
		String expected_result = "HHdawko2i2";

		assertThat(actual,is(expected_result));		
	}
	
	@Test
	public void getNameのテスト() {
		String actual = tanaka.getName();
		String expected_result = "田中太郎";

		assertThat(actual,is(expected_result));
	}
}
