package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardUpdateView {

public BoardVO input(){

		Scanner sc1 = new Scanner(System.in);
			
		
		System.out.println("수정항목을 입력해주세요");
		System.out.print("게시물 번호를 입력하세요");
		int numberr = sc1.nextInt();
		String number = sc1.nextLine(); // 계속 제목하고 내용으로 동시에 넘어가서 이거 넣으니까 됩니다.
		System.out.println();
		System.out.println("제목입력 : ");
		String title = sc1.nextLine();
		System.out.println("내용입력 : ");
		String story = sc1.nextLine();
		System.out.println("작성자입력 : ");
		String writer = sc1.nextLine();
		System.out.println("글암호 입력 : ");
		String pass = sc1.next();
		
	
		BoardVO vo = new BoardVO(numberr, title, story, writer, pass);

		
		return vo;
	
}
}
