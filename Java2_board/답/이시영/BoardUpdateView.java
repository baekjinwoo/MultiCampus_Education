package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardUpdateView {
	public BoardVO input() {
		Scanner sc=new Scanner(System.in);
		BoardVO vo=new BoardVO();
		
		System.out.print("������ �Խù� ��ȣ �Է� : ");
		vo.setNum(Integer.parseInt(sc.nextLine()));
		
		System.out.println("������ ������ �Է����ּ���. (���� ���ʿ�� �׳� ���� �Է�)");
		System.out.print("���� : ");
		vo.setText(sc.nextLine());
		System.out.print("���� : ");
		vo.setTitle(sc.nextLine());
		System.out.print("�ۼ��� : ");
		vo.setWmember(sc.nextLine());
		System.out.print("��ȣ : ");
		vo.setPwd(sc.next());
		
		return vo;
	}
}
