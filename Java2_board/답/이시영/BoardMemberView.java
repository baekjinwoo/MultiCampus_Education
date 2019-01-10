package view;

import java.util.Scanner;
import vo.MemberVO;

public class BoardMemberView {	
	public MemberVO input() {
		
		Scanner sc=new Scanner(System.in);
			
		System.out.print("아이디를 입력하시오 : ");
		String id=sc.next();
		
		System.out.print("암호를 입력하시오 : ");
		String password=sc.next();
		
		System.out.print("이름을 입력하시오 : ");
		String member_name=sc.next();
		
		System.out.print("이메일을 입력하시오 : ");
		String email=sc.next();
		
		System.out.print("전화번호를 입력하시오 : ");
		String phone=sc.next();
		
		MemberVO vo=new MemberVO(id,password,member_name,email,phone);
		
		/*MemberVO vo=new MemberVO();
		
		vo.setId(id);
		vo.setPassword(password);
		vo.setMember_member_name(member_name);
		vo.setEmail(email);
		vo.setPhone(phone);*/
		
		return vo;
	}

}
