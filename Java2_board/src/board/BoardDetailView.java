package board;

import java.util.Scanner;

import VO.BoardVO;

public class BoardDetailView {
	public int input(){
		Scanner sc = new Scanner(System.in);
		BoardVO vo= new BoardVO();
		System.out.print("상세조회 게시물 번호 입력 : ");
		String a= sc.next();
		int in=Integer.parseInt(a);

		return in;
	}
}
