package view;

import java.util.Scanner;

import vo.BoardVo;

public class BoardInsertView {

	Scanner sc=new Scanner(System.in);
	
	public BoardVo Input(){
		
		System.out.print("���� �Է� : ");			String title=sc.nextLine();
		System.out.print("�۳��� �Է� : ");			String contents=sc.nextLine();
		System.out.print("�ۼ��� �Է� : ");			String writer=sc.next();
		System.out.print("�� ��ȣ �Է� : ");			String pw=sc.next();
		
		BoardVo vo=new BoardVo(title, contents, writer, pw);

		return vo;

	}
	
	
}
