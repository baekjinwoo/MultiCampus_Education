package view;

import java.util.Scanner;

import vo.MemberVO;

public class BoardMemberView {


	public MemberVO input() {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("�ƾƵ� �Է� : ");
		String id = sc1.next();
		System.out.println("��ȣ �Է� : ");
		String pw = sc1.next();
		System.out.println("�̸� �Է� : ");
		String member_name = sc1.next();
		System.out.println("�̸��� : ");
		String email = sc1.next();
		System.out.println("��ȭ��ȣ : ");
		String phone = sc1.next();
		
		MemberVO vo = new MemberVO(id, pw, member_name, email, phone);
		
		
		/*MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setMember_name(member_name);
		vo.setEmail(email);
		vo.setPhone(phone);
*/		
		return vo;
		
		
	
	}
}

