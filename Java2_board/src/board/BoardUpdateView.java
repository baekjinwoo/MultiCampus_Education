package board;
import java.util.Scanner;

import VO.BoardVO;

public class BoardUpdateView {
	public BoardVO input() {
Scanner sc=new Scanner(System.in);
		
		System.out.print("������ �Խù� ��ȣ : ");		int num=sc.nextInt();
		sc.nextLine();
		
		System.out.println("<<  ���� �׸� �Է�  >>");	//���������� ����
		System.out.print("������ ���� : ");			String title=sc.nextLine();
		System.out.print("������ ���� : ");			String contents=sc.nextLine();
		System.out.print("������ �ۼ��� : ");		String writer=sc.nextLine();
		System.out.print("�� ��ȣ �Է� : ");			String password=sc.nextLine();
		
		BoardVO vo=new BoardVO(num, title, contents, writer, password);
		return vo;
	}
}
