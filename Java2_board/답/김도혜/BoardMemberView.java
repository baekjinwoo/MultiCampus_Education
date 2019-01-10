package view;
import java.util.Scanner;

import vo.MemberVO;

public class BoardMemberView {
	Scanner sc = new Scanner(System.in);
	
	public MemberVO input(){
		
	/*	System.out.print("id 입력 >> ");
		vo.setId(sc.nextLine());
		System.out.print("암호 입력 >> ");
		vo.setPw(sc.nextLine());
		System.out.print("이름 입력 >> ");
		vo.setMamber_name(sc.nextLine());
		System.out.print("이메일 입력 >> ");
		vo.setEmail(sc.nextLine());
		System.out.print("폰번호 입력 >> ");
		vo.setPhone(sc.nextLine());*/
		
		System.out.print("id 입력 >> ");
		String id = sc.nextLine();
		System.out.print("암호 입력 >> ");
		String pw = sc.nextLine();
		System.out.print("이름 입력 >> ");
		String name = sc.nextLine();
		System.out.print("이메일 입력 >> ");
		String email = sc.nextLine();
		System.out.print("폰번호 입력 >> ");
		String phone = sc.nextLine();
		
		MemberVO vo = new MemberVO(id, pw, name, email, phone);
		
		return vo;
	}
	
}
