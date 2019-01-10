package view;

import java.util.Scanner;

import vo.BoardVo;

public class BoardInsertView {

	Scanner sc=new Scanner(System.in);
	
	public BoardVo Input(){
		
		System.out.print("제목 입력 : ");			String title=sc.nextLine();
		System.out.print("글내용 입력 : ");			String contents=sc.nextLine();
		System.out.print("작성자 입력 : ");			String writer=sc.next();
		System.out.print("글 암호 입력 : ");			String pw=sc.next();
		
		BoardVo vo=new BoardVo(title, contents, writer, pw);

		return vo;

	}
	
	
}
