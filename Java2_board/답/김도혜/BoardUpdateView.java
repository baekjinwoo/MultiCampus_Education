package view;
import java.util.Scanner;

import vo.BoardVO;

public class BoardUpdateView {
	Scanner sc = new Scanner(System.in);
	
	public BoardVO input(){
		
		System.out.print("���� �׸� ��ȣ �Է� >> ");
		int seq = Integer.parseInt(sc.nextLine());
		System.out.print("���� �Է� >> ");
		String title = sc.nextLine();
		System.out.print("���� �Է� >> ");
		String contents = sc.nextLine();
		System.out.print("�ۼ��� �Է� >> ");
		String writer = sc.nextLine();
		System.out.print("�۾�ȣ �Է� >> ");
		String pw = sc.nextLine();

		BoardVO vo = new BoardVO(seq, title, contents, writer, pw);
		
		return vo;
	}
	
}
