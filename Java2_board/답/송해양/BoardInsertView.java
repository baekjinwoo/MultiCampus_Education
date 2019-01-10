package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardInsertView {
	
	public BoardVO input() {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		System.out.println();
		System.out.print("1. 제목을 입력하세요 : ");
		String title = key.nextLine();
		System.out.print("2. 내용을 입력하세요 : ");
		String main = key.nextLine();
		System.out.print("3. 작성자를 입력하세요 : ");
		String writer = key.next();
		System.out.print("4. 글의 암호를 입력하세요 : ");
		String pw = key.next();
		
		BoardVO vo = new BoardVO(title, main, writer, pw);
		return vo;
		
	}
	
}
