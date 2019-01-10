package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardDeleteView {
	Scanner sc = new Scanner(System.in);

	public BoardVO input(){
		
		System.out.print("삭제할 게시물 번호 입력>> ");
		int seq = sc.nextInt();
		System.out.print("글암호 입력>> ");
		String pw = sc.next();
		
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setPw(pw);
		
		return vo;
	}
	
	
}
