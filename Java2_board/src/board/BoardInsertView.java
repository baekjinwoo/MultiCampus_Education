package board;

import java.util.Scanner;

import VO.BoardVO;

public class BoardInsertView {
	public BoardVO input(){
		Scanner sc= new Scanner(System.in);
		
		System.out.println("������ �Է��Ͻÿ�:");
		String title= sc.nextLine();
		
		System.out.println("�����Է�:");
		String text= sc.next();
		
		System.out.println("�ۼ��� �Է�:");
		String writer= sc.next();
		
		System.out.println("�� ��ȣ �Է�:");
		System.out.println("(�����Է������� table������, pw�� ���ڸ�(1~5�ڸ�))");
		String pw= sc.next();
		
		BoardVO vo=new BoardVO(title,text,writer,pw);
		return vo;
	}
}
