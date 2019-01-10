package vo;

public class MemberVO {// view -> Dao 로 보내주는 중간 저장소 역할
	//MEMBER 테이블
	private String id;//회원가입 ID
	private String pwd;//암호
	private String member_name;//이름
	private String email;//이메일
	private String phone;//폰번호
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public MemberVO() {
		super();
	}
	public MemberVO(String id, String pwd, String member_name, String email, String phone) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.member_name = member_name;
		this.email = email;
		this.phone = phone;
	}
	
	
	
}
//jdbc.BoardMain <-- id 변수 사용 가능