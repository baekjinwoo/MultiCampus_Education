package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardUpdateView {
	
	public BoardVO input() {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		System.out.println();
		System.out.println("수정항목을 입력해주세요.\n(수정이 불필요할 시 Enter 사용)");
		System.out.print("1. 수정될 제목을 입력하세요 : ");
		String title = key.nextLine();
		System.out.print("2. 수정될 내용을 입력하세요 : ");
		String main = key.nextLine();
		System.out.print("3. 수정될 작성자를 입력하세요 : ");
		String writer = key.nextLine();
		System.out.print("4. 글의 암호를 입력하세요 : ");
		String pw = key.next();
		
		BoardVO vo = new BoardVO(title, main, writer, pw);
		return vo;
		
	}
	
}
