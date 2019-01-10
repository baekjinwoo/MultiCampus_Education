package board;

import java.util.Scanner;

import VO.BoardVO;

public class BoardInsertView {
	public BoardVO input(){
		Scanner sc= new Scanner(System.in);
		
		System.out.println("제목을 입력하시오:");
		String title= sc.nextLine();
		
		System.out.println("내용입력:");
		String text= sc.next();
		
		System.out.println("작성자 입력:");
		String writer= sc.next();
		
		System.out.println("글 암호 입력:");
		System.out.println("(문자입력이지만 table에의해, pw는 숫자만(1~5자리))");
		String pw= sc.next();
		
		BoardVO vo=new BoardVO(title,text,writer,pw);
		return vo;
	}
}
