package VO;

public class MemberVO {
//MEMBER ���̺�
//��ü������ ������ private���� ����
//��ü������ �޼���� public���� return
	private String id;  //Ű���� �Է� id-> ȸ������ID
	private String pw;  //��ȣ
	private String member_name;//�̸�
	private String email;//�̸���
	private String phone;//����ó
	
	//set�� ����
//get�� ��ȯ
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
// jdbc.BoardMain <---- id���� ��밡��