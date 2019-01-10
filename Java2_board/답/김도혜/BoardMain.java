package board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import DAO.BoardDAO;
import DAO.MemberDAO;
import view.BoardDeleteView;
import view.BoardDetailView;
import view.BoardInsertView;
import view.BoardListView;
import view.BoardMemberView;
import view.BoardUpdateView;
import vo.BoardVO;
import vo.MemberVO;

public class BoardMain {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("=======게시판 프로그램입니다=======");
			System.out.println("1. 회원 가입 ");
			System.out.println("2. 게시물 작성 ");
			System.out.println("3. 게시물 조회 ");
			System.out.println("4. 게시물 수정 ");
			System.out.println("5. 게시물 삭제 ");
			System.out.println("6. 종료  ");
			System.out.print("번호 입력: ");
			int menu = sc.nextInt();

			if (menu == 1) {
				MemberVO vo = new BoardMemberView().input();
				int d = new MemberDAO().insertMember(vo);
				if (d == 0) {
					System.out.println("가입중 오류");
				} else {
					System.out.println("정상가입(조회는 db에서)");
				}

			} else if (menu == 2) {
				BoardVO vo = new BoardInsertView().input();
				int result = new BoardDAO().insertBoard(vo);
				if (result == -1) {
					System.out.println("회원가입 먼저");
				} else {
					System.out.println("정상 등록");
				}
			} else if (menu == 3) {
				String result = new BoardListView().input();
				ArrayList<BoardVO> al = new BoardDAO().getBoardList(result);

				for (BoardVO vo : al) {
					System.out.println(vo.getSeq() + " " + vo.getTitle() + " " + vo.getWriter());
				}

				// 상세조회
				int select = new BoardDetailView().input();
				BoardVO vo = new BoardDAO().getBoard(select);
				System.out.println(vo);

			} else if (menu == 4) {
				BoardVO vo = new BoardUpdateView().input();
				int result = new BoardDAO().UpdateBoard(vo);
				if (result == 0) {
					System.out.println("암호 오류 -> 업데이트 실패");
				} else {
					System.out.println("업데이트 성공");
				}

			} else if (menu == 5) {
				BoardVO vo = new BoardDeleteView().input();
				int result = new BoardDAO().DeleteBoard(vo);
				if (result == 0) {
					System.out.println("암호 오류 -> 삭제 실패");
				} else {
					System.out.println("삭제 성공");
				}

			} else {
				System.out.println("종료 선택하였습니다.");
				return;
				// 반복문 종료 : break -> 이것도 가능
				// 메소드 종료 : return - (main method)끝내기
			}

		}

	}

}
