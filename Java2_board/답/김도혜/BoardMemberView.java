package view;
import java.util.Scanner;

import vo.MemberVO;

public class BoardMemberView {
	Scanner sc = new Scanner(System.in);
	
	public MemberVO input(){
		
	/*	System.out.print("id �Է� >> ");
		vo.setId(sc.nextLine());
		System.out.print("��ȣ �Է� >> ");
		vo.setPw(sc.nextLine());
		System.out.print("�̸� �Է� >> ");
		vo.setMamber_name(sc.nextLine());
		System.out.print("�̸��� �Է� >> ");
		vo.setEmail(sc.nextLine());
		System.out.print("����ȣ �Է� >> ");
		vo.setPhone(sc.nextLine());*/
		
		System.out.print("id �Է� >> ");
		String id = sc.nextLine();
		System.out.print("��ȣ �Է� >> ");
		String pw = sc.nextLine();
		System.out.print("�̸� �Է� >> ");
		String name = sc.nextLine();
		System.out.print("�̸��� �Է� >> ");
		String email = sc.nextLine();
		System.out.print("����ȣ �Է� >> ");
		String phone = sc.nextLine();
		
		MemberVO vo = new MemberVO(id, pw, name, email, phone);
		
		return vo;
	}
	
}
