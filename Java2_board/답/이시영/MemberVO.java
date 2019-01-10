package vo;

public class MemberVO {
	private String id;
	private String password;
	private String member_name;
	private String email;
	private String phone;
	
	public MemberVO(String id, String password, String member_name, String email, String phone) {
		super();
		this.id=id;
		this.password=password;
		this.member_name=member_name;
		this.email=email;
		this.phone=phone;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
