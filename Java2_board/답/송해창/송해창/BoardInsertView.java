package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardInsertView {


	public BoardVO input() {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("�����Է� : ");
		String title = sc1.nextLine();
		System.out.println("�����Է� : ");
		String story = sc1.nextLine();
		System.out.println("�ۼ����Է� : ");
		String writer = sc1.nextLine();
		System.out.println("�۾�ȣ �Է� : ");
		String pass = sc1.nextLine();
	
		BoardVO vo = new BoardVO(title, story, writer, pass);
	
		
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

