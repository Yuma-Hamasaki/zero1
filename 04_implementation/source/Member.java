package チケット予約システム;

public class Member {

	private String id;

	private String password;

	private String name;

	public Member(String memberID, String password, String name) {
		this.id = memberID;
		this.password = password;
		this.name = name;
	}

	public String getId() {
		return this.id;
		
	}

	public String getPassword() {
		return this.password;
	}

	public String getName() {
		return name;
	}

}
