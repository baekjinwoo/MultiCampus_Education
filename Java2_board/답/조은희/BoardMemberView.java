package view;

import java.util.Scanner;

import vo.MemberVo;

public class BoardMemberView {

	Scanner sc= new Scanner(System.in);
	
	public MemberVo input() {

		System.out.print("id �Է� : ");			String id=sc.next();
		System.out.print("password �Է� : ");		String pw=sc.next();
		System.out.print("�̸� �Է� : ");			String member_name=sc.next();
		System.out.print("email �Է� : ");		String email=sc.next();
		System.out.print("phone �Է� : ");		String phone=sc.next();
		
		MemberVo vo=new MemberVo(id, pw, member_name, email, phone);
		
/****************************************
		MemberVo vo=new MemberVo();
		
		vo.setId(id);
		vo.setPw(pw);
		vo.setMember_name(member_name);
		vo.setEmail(email);
		vo.setPhone(phone);
*****************************************/
		return vo;
	}

}





//MemberVo mv=new MemberVo();
//mv.setId(id);
//mv.setPw(pw);
//mv.setMember_name(member_name);
//mv.setEmail(email);
//mv.setPhone(phone);