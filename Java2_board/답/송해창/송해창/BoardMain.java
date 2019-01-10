package board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.BoardDAO;
import view.BoardDetailView;
import view.BoardInsertView;
import view.BoardListView;
import view.BoardMemberView;
import view.BoardUpdateView;
import vo.BoardVO;
import vo.MemberVO;

public class BoardMain {

	@SuppressWarnings("null")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BoardVO detailVO = null;
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("===게시판 프로그램입니다===");
			System.out.println("1. 회원가입");
			System.out.println("2. 게시물 작성");
			System.out.println("3. 게시물 조회");
			System.out.println("4. 게시물 상세조회");
			System.out.println("5. 게시물 수정");
			System.out.println("6. 게시물 삭제");
			System.out.println("7. 종료");
			System.out.println("번호 입력 : ");
			// 게시판 사이트
			// 10개씩 : 번호 제목 작성자
			// 상세 내용 조회 / 수정 / 삭제
			// CRUD

			Scanner sc1 = new Scanner(System.in);

			int menu = sc1.nextInt();

			if (menu == 1) {
				BoardMemberView view = new BoardMemberView();

				MemberVO vo = view.input();

				BoardDAO dao = new BoardDAO();
				int result = dao.insertMember(vo);

				if (result == 0) {
					System.out.println("가입 중 오류");
				} else {
					System.out.println("정상 가입(조회는 db에서 직접");
				}

				System.out.println("입력하신 정보가 성공적으로 추가되었습니다.");
				break;
			} else if (menu == 2) {
				BoardInsertView view = new BoardInsertView();
				BoardVO vo = view.input();
				BoardDAO dao = new BoardDAO();
				System.out.println(vo);
				int result = dao.insertBoard(vo);

				if (result == -1) {
					System.out.println("글 작성이 불가능합니다.(회원가입 먼저 하세요)");
				} else if (result == 1) {
					System.out.println("정삭적으로 글을 작성하실 수 있습니다.");
				} else {
					System.out.println("글 작성 불가능(복합적인 이유가 있을 수 있습니다.)");
				}

				System.out.println("게시물 작성 선택하셨습니다.");
			} else if (menu == 3) {

				String result = new BoardListView().input();
				// result가 검색어인지 숫자인지 어떻게 판단함? 그거는 boarddao에서 판단함.

				ArrayList<BoardVO> blist = new BoardDAO().getBoardList(result);
				System.out.println("조회된 리스트는 다음과 같습니다");
				for (BoardVO vo : blist) {
					System.out.println(vo); // (vo.toString() //
											// 패키지명.클래스명@16자리객체주소값
				}
				System.out.println("조회 완료되었습니다.");

			} else if (menu == 4) {

				BoardDetailView view = new BoardDetailView();
				int result = view.input();

				BoardDAO dao = new BoardDAO();
				detailVO = dao.getBoard(result);
				detailVO.getBoard();

			} else if (menu == 5) {

				BoardUpdateView view = new BoardUpdateView();

				BoardVO vo = view.input();
				
				if (vo.getTitle().equals("")) {
					vo.setTitle(detailVO.getTitle());
				}
				if (vo.getStory().equals("")) {
					vo.setStory(detailVO.getStory());
				}
				if (vo.getWriter().equals("")) {
					vo.setWriter(detailVO.getWriter());
				}
				

				BoardDAO dao = new BoardDAO();

				int result = dao.updateBoard(vo);

				if (result == -1) {
					System.out.println("수정 안됬습니다.");
				} else {
					System.out.println("수정됬습니다..");

				}

			} else if (menu == 6) {

				System.out.println("게시물 삭제 선택하였습니다.");
				System.out.println("삭제할 게시물 번호 입력");
				int numberr = sc1.nextInt();

				System.out.println("삭제할 게시물 암호 입력해라");
				int del = sc1.nextInt();

				BoardDAO dao = new BoardDAO();

				int result = dao.deleteBoard(numberr, del);

				if (result == -1) {
					System.out.println("삭제 안됬습니다.");
				} else {
					System.out.println("삭제됬습니다.");

				}

			} else {
				System.out.println("프로그램 종료 선택하셨습니다.");
				break;
				// 반복문 종료 : break, 메서드 종료 return
			} // else
		} // while

	}// main
}// class

/*
 * Scanner sc = new Scanner(System.in); Connection con1 = null;
 * Class.forName("oracle.jdbc.driver.OracleDriver"); con1 =
 * DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr",
 * "hr");
 */