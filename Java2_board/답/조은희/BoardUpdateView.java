package view;

import java.util.Scanner;

import vo.BoardVo;

public class BoardUpdateView {

	public BoardVo input(){

		Scanner sc=new Scanner(System.in);
		
		System.out.print("������ �Խù� ��ȣ : ");		int num=sc.nextInt();
		sc.nextLine();
		
		System.out.println("<<  ���� �׸� �Է�  >>");	//���������� ����
		System.out.print("������ ���� : ");			String title=sc.nextLine();
		System.out.print("������ ���� : ");			String contents=sc.nextLine();
		System.out.print("������ �ۼ��� : ");		String writer=sc.nextLine();
		System.out.print("�� ��ȣ �Է� : ");			String password=sc.nextLine();
		
		BoardVo vo=new BoardVo(num, title, contents, writer, password);
		return vo;
	}

}
