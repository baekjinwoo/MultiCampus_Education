package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardDeleteView {
	Scanner sc = new Scanner(System.in);

	public BoardVO input(){
		
		System.out.print("������ �Խù� ��ȣ �Է�>> ");
		int seq = sc.nextInt();
		System.out.print("�۾�ȣ �Է�>> ");
		String pw = sc.next();
		
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setPw(pw);
		
		return vo;
	}
	
	
}
