package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardInsertView {
	public BoardVO input() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("������ �Է��Ͻÿ� : ");
		String title=sc.nextLine();
		
		System.out.print("������ �Է��Ͻÿ� : ");
		String text=sc.nextLine();
		
		System.out.print("�̸��� �Է��Ͻÿ� : ");
		String wmember=sc.next();
		
		System.out.print("�� ��ȣ�� �Է��Ͻÿ� : ");
		String pwd=sc.next();
		
		BoardVO vo=new BoardVO(title, text, wmember, pwd);
		
		return vo;
		
	}
}
