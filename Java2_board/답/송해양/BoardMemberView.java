package view;

import java.util.Scanner;

import vo.MemberVO;

public class BoardMemberView {
	
	public MemberVO input() {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		System.out.println();
		System.out.print("1. ID�� �Է��ϼ��� : ");
		String id = key.next();
		System.out.print("2. PASSWORD�� �Է��ϼ��� : ");
		String pw = key.next();
		System.out.print("3. �̸��� �Է��ϼ��� : ");
		String member_name = key.next();
		System.out.print("4. Email�� �Է��ϼ��� : ");
		String email = key.next();
		System.out.print("5. ��ȭ��ȣ�� �Է��ϼ��� : ");
		String phone = key.next();
		
		MemberVO vo = new MemberVO(id, pw, member_name, email, phone);

/*		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setMember_name(member_name);
		vo.setEmail(email);
		vo.setPhone(phone);*/
		return vo;
		
	}
	
}
