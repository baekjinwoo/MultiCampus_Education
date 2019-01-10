package vo;

public class MemberVO {
	// MEMBER 테이블
	private String id;// 키보드 입력 ID -> 회원가입 ID
	private String pw;// 암호
	private String member_name;// 이름
	private String email;// 이메일
	private String phone;// 폰번호
	
	public MemberVO(String id, String pw, String member_name, String email, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.member_name = member_name;
		this.email = email;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}