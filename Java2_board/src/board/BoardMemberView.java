package board;
import java.util.Scanner;

import VO.MemberVO;

public class BoardMemberView {
	MemberVO vo = new MemberVO();
	Scanner sc = new Scanner(System.in);
	
	public MemberVO input() {
		
		System.out.println("아이디를 입력하시오:");
		String a= sc.next();
		vo.setId(a);
		
		System.out.println("비번를 입력하시오:");
		String b= sc.next();
		vo.setPw(b);
		
		System.out.println("이름을 입력하시오:");
		String c= sc.next();
		vo.setMember_name(c);
		
		System.out.println("이메일을 입력하시오:");
		String d= sc.next();
		vo.setEmail(d);
		
		System.out.println("연락처를 입력하시오:");
		String e= sc.next();
		vo.setPhone(e);
		
		return vo;
	
	}
}
/*
 * MemberVO에서 
 * public MemberVO(String id, String pw, String member_name, String email, String phone) {
		this.id = id;
		this.pw = pw;
		this.member_name = member_name;
		this.email = email;
		this.phone = phone;
	}
 * 
 * BoardDAO에서
 * MemberVO vo = new MemberVO(a,b,c,d,e);라고 생성자를 넣으면 일일이 MemberView.java에서 setter를 쓸 필요없다
 * 
 * */

