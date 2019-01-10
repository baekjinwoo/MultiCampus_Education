package view;

import java.util.Scanner;

import vo.BoardVo;

public class BoardUpdateView {

	public BoardVo input(){

		Scanner sc=new Scanner(System.in);
		
		System.out.print("수정할 게시물 번호 : ");		int num=sc.nextInt();
		sc.nextLine();
		
		System.out.println("<<  수정 항목 입력  >>");	//수정없으면 엔터
		System.out.print("수정할 제목 : ");			String title=sc.nextLine();
		System.out.print("수정할 내용 : ");			String contents=sc.nextLine();
		System.out.print("수정할 작성자 : ");		String writer=sc.nextLine();
		System.out.print("글 암호 입력 : ");			String password=sc.nextLine();
		
		BoardVo vo=new BoardVo(num, title, contents, writer, password);
		return vo;
	}

}
