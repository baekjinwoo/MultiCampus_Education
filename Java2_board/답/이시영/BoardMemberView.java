package view;

import java.util.Scanner;
import vo.MemberVO;

public class BoardMemberView {	
	public MemberVO input() {
		
		Scanner sc=new Scanner(System.in);
			
		System.out.print("���̵� �Է��Ͻÿ� : ");
		String id=sc.next();
		
		System.out.print("��ȣ�� �Է��Ͻÿ� : ");
		String password=sc.next();
		
		System.out.print("�̸��� �Է��Ͻÿ� : ");
		String member_name=sc.next();
		
		System.out.print("�̸����� �Է��Ͻÿ� : ");
		String email=sc.next();
		
		System.out.print("��ȭ��ȣ�� �Է��Ͻÿ� : ");
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
