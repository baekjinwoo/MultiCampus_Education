package vo;

public class MemberVo {

	//member table
	private String id;			//Ű�����Է� id -> ȸ������ ���̵�
	private String pw;			//��ȣ
	private String member_name;	//�̸�
	private String email;		//�̸���
	private String phone;		//����ȣ
	
	//������ private �޼���� public���� ����

	public MemberVo() {
		super();
	}
	public MemberVo(String id, String pw, String member_name, String email, String phone) {
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
