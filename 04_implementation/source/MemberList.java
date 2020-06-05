package チケット予約システム;

import java.util.ArrayList;

public class MemberList {

	private ArrayList<Member> members = new ArrayList<Member>();

	public MemberList() {
		
	}

	public void addMember(Member member) {
		this.members.add(member);
	}
	
	/**
	 * IDとパスワードの一致する会員を取得
	 * @param memberID
	 * @param password
	 * @return
	 */
	public Member searchMember(String memberID, String password) {
		Member rtnMember = null; //	戻り値用変数
		for(Member member : members) {
			if(memberID.equals(member.getId()) && password.equals(member.getPassword())) {
				rtnMember = member;
				break;
			}
		}
		
		return rtnMember;
	}

}
