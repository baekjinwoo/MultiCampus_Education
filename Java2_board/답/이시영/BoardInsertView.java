package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardInsertView {
	public BoardVO input() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("제목을 입력하시오 : ");
		String title=sc.nextLine();
		
		System.out.print("내용을 입력하시오 : ");
		String text=sc.nextLine();
		
		System.out.print("이름을 입력하시오 : ");
		String wmember=sc.next();
		
		System.out.print("글 암호를 입력하시오 : ");
		String pwd=sc.next();
		
		BoardVO vo=new BoardVO(title, text, wmember, pwd);
		
		return vo;
		
	}
}
