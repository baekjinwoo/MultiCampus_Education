package view;

import java.util.Scanner;

import vo.MemberVO;

public class BoardMemberView {


	public MemberVO input() {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("아아디 입력 : ");
		String id = sc1.next();
		System.out.println("암호 입력 : ");
		String pw = sc1.next();
		System.out.println("이름 입력 : ");
		String member_name = sc1.next();
		System.out.println("이메일 : ");
		String email = sc1.next();
		System.out.println("전화번호 : ");
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

