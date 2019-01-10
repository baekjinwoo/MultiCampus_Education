package view;
import java.util.Scanner;

import vo.BoardVO;

public class BoardUpdateView {
	Scanner sc = new Scanner(System.in);
	
	public BoardVO input(){
		
		System.out.print("수정 항목 번호 입력 >> ");
		int seq = Integer.parseInt(sc.nextLine());
		System.out.print("제목 입력 >> ");
		String title = sc.nextLine();
		System.out.print("내용 입력 >> ");
		String contents = sc.nextLine();
		System.out.print("작성자 입력 >> ");
		String writer = sc.nextLine();
		System.out.print("글암호 입력 >> ");
		String pw = sc.nextLine();

		BoardVO vo = new BoardVO(seq, title, contents, writer, pw);
		
		return vo;
	}
	
}
