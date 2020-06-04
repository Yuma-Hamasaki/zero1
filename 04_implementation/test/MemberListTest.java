package チケット予約システム;

import static org.junit.Assert.*;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class MemberListTest {
	MemberList memList;
	Member tanaka;
	
	@Before
	public void setUp() {
		memList = new MemberList();
		tanaka = new Member("t-tanaka", "Sswgtnk11", "田中太郎");
		memList.addMember(tanaka);
	}
	
	@Test
	public void searchMemberのテスト_tanakaが得られる場合() {
		Member actual = memList.searchMember("t-tanaka", "Sswgtnk11");
		Member expected_result = tanaka;

		assertThat(actual,sameInstance(expected_result));
	}
	
	@Test
	public void searchMemberのテスト_nullが得られる場合() {
		Member actual = memList.searchMember("t-motoi", "gghdai22");
		Member expected_result = null;

		assertThat(actual,sameInstance(expected_result));
	}
}