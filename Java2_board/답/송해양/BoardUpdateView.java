package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardUpdateView {
	
	public BoardVO input() {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		System.out.println();
		System.out.println("�����׸��� �Է����ּ���.\n(������ ���ʿ��� �� Enter ���)");
		System.out.print("1. ������ ������ �Է��ϼ��� : ");
		String title = key.nextLine();
		System.out.print("2. ������ ������ �Է��ϼ��� : ");
		String main = key.nextLine();
		System.out.print("3. ������ �ۼ��ڸ� �Է��ϼ��� : ");
		String writer = key.nextLine();
		System.out.print("4. ���� ��ȣ�� �Է��ϼ��� : ");
		String pw = key.next();
		
		BoardVO vo = new BoardVO(title, main, writer, pw);
		return vo;
		
	}
	
}
