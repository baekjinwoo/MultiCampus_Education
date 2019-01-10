package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardUpdateView {
	public BoardVO input() {
		Scanner sc=new Scanner(System.in);
		BoardVO vo=new BoardVO();
		
		System.out.print("수정할 게시물 번호 입력 : ");
		vo.setNum(Integer.parseInt(sc.nextLine()));
		
		System.out.println("수정할 내용을 입력해주세요. (수정 불필요시 그냥 엔터 입력)");
		System.out.print("제목 : ");
		vo.setText(sc.nextLine());
		System.out.print("내용 : ");
		vo.setTitle(sc.nextLine());
		System.out.print("작성자 : ");
		vo.setWmember(sc.nextLine());
		System.out.print("암호 : ");
		vo.setPwd(sc.next());
		
		return vo;
	}
}
