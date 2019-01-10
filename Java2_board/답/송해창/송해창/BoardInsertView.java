package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardInsertView {


	public BoardVO input() {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("제목입력 : ");
		String title = sc1.nextLine();
		System.out.println("내용입력 : ");
		String story = sc1.nextLine();
		System.out.println("작성자입력 : ");
		String writer = sc1.nextLine();
		System.out.println("글암호 입력 : ");
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

