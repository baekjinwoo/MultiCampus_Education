package board;

import java.util.Scanner;

import VO.BoardVO;

public class BoardListView {
	public String input() { //return타입 String으로 바꿧음
		Scanner sc = new Scanner(System.in);
		BoardVO vo = new BoardVO();
		System.out.println("(1)페이지 조회 \t(2)조건조회 \t (3)상세조회");
		
		
		
		int search = sc.nextInt();
		String str = null;
		if (search == 1) {
			System.out.print("페이지 번호입력: ");
			str = sc.next();
		}
		else if (search == 2) {
			System.out.print("(제목, 내용, 작성자 포함)검색어 입력: ");
			str = sc.next();
			if (str == vo.getTitle() || str == vo.getText() || str == vo.getWriter()) {
			}
		} // else-if-end
		
		else if (search ==3){
			String a = String.valueOf(0);
			
			str= a;
		}
		return str; // return을 if 밖에 둠으로써 반환가능
	}// input-end
}
