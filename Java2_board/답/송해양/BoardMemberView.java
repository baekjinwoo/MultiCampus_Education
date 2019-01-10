package view;

import java.util.Scanner;

import vo.MemberVO;

public class BoardMemberView {
	
	public MemberVO input() {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		System.out.println();
		System.out.print("1. ID를 입력하세요 : ");
		String id = key.next();
		System.out.print("2. PASSWORD를 입력하세요 : ");
		String pw = key.next();
		System.out.print("3. 이름를 입력하세요 : ");
		String member_name = key.next();
		System.out.print("4. Email을 입력하세요 : ");
		String email = key.next();
		System.out.print("5. 전화번호를 입력하세요 : ");
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
