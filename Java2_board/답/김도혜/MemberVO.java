package vo;

public class MemberVO {
	
	private String id;
	private String pw;
	private String mamber_name;
	private String email;
	private String phone;
	
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
	public String getMamber_name() {
		return mamber_name;
	}
	public void setMamber_name(String mamber_name) {
		this.mamber_name = mamber_name;
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
	
	public MemberVO(){
		
	}
	
	public MemberVO(String id, String pw, String mamber_name, String email, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.mamber_name = mamber_name;
		this.email = email;
		this.phone = phone;
	}

	
}
