package vo;

public class MemberVO {// view -> Dao �� �����ִ� �߰� ����� ����
	//MEMBER ���̺�
	private String id;//ȸ������ ID
	private String pwd;//��ȣ
	private String member_name;//�̸�
	private String email;//�̸���
	private String phone;//����ȣ
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
//jdbc.BoardMain <-- id ���� ��� ����