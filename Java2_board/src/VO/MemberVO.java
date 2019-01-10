package VO;

public class MemberVO {
//MEMBER 테이블
//대체적으로 변수는 private으로 생성
//대체적으로 메서드는 public으로 return
	private String id;  //키보드 입력 id-> 회원가입ID
	private String pw;  //암호
	private String member_name;//이름
	private String email;//이메일
	private String phone;//연락처
	
	//set은 수정
//get은 반환
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
// jdbc.BoardMain <---- id변수 사용가능