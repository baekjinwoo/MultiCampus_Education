package board;
import java.util.Scanner;

import VO.MemberVO;

public class BoardMemberView {
	MemberVO vo = new MemberVO();
	Scanner sc = new Scanner(System.in);
	
	public MemberVO input() {
		
		System.out.println("���̵� �Է��Ͻÿ�:");
		String a= sc.next();
		vo.setId(a);
		
		System.out.println("����� �Է��Ͻÿ�:");
		String b= sc.next();
		vo.setPw(b);
		
		System.out.println("�̸��� �Է��Ͻÿ�:");
		String c= sc.next();
		vo.setMember_name(c);
		
		System.out.println("�̸����� �Է��Ͻÿ�:");
		String d= sc.next();
		vo.setEmail(d);
		
		System.out.println("����ó�� �Է��Ͻÿ�:");
		String e= sc.next();
		vo.setPhone(e);
		
		return vo;
	
	}
}
/*
 * MemberVO���� 
 * public MemberVO(String id, String pw, String member_name, String email, String phone) {
		this.id = id;
		this.pw = pw;
		this.member_name = member_name;
		this.email = email;
		this.phone = phone;
	}
 * 
 * BoardDAO����
 * MemberVO vo = new MemberVO(a,b,c,d,e);��� �����ڸ� ������ ������ MemberView.java���� setter�� �� �ʿ����
 * 
 * */

