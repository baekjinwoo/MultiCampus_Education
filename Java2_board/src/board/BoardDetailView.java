package board;

import java.util.Scanner;

import VO.BoardVO;

public class BoardDetailView {
	public int input(){
		Scanner sc = new Scanner(System.in);
		BoardVO vo= new BoardVO();
		System.out.print("����ȸ �Խù� ��ȣ �Է� : ");
		String a= sc.next();
		int in=Integer.parseInt(a);

		return in;
	}
}
