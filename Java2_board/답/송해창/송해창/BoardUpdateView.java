package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardUpdateView {

public BoardVO input(){

		Scanner sc1 = new Scanner(System.in);
			
		
		System.out.println("�����׸��� �Է����ּ���");
		System.out.print("�Խù� ��ȣ�� �Է��ϼ���");
		int numberr = sc1.nextInt();
		String number = sc1.nextLine(); // ��� �����ϰ� �������� ���ÿ� �Ѿ�� �̰� �����ϱ� �˴ϴ�.
		System.out.println();
		System.out.println("�����Է� : ");
		String title = sc1.nextLine();
		System.out.println("�����Է� : ");
		String story = sc1.nextLine();
		System.out.println("�ۼ����Է� : ");
		String writer = sc1.nextLine();
		System.out.println("�۾�ȣ �Է� : ");
		String pass = sc1.next();
		
	
		BoardVO vo = new BoardVO(numberr, title, story, writer, pass);

		
		return vo;
	
}
}
