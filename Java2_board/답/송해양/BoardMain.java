package board;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardVO detailVO = null;
		while (true) {
			System.out.println("==============");
			System.out.println(" 게시판 관리 프로그램");
			System.out.println("==============");
			System.out.println("1. 회원 가입");
			System.out.println("--------------");
			System.out.println("2. 게시물 작성");
			System.out.println("--------------");
			System.out.println("3. 게시물 조회");
			System.out.println("--------------");
			System.out.println("4. 게시물 상세 조회");
			System.out.println("--------------");
			System.out.println("5. 게시물 수정");
			System.out.println("--------------");
			System.out.println("6. 게시물 삭제");
			System.out.println("--------------");
			System.out.println("7. 종료");
			System.out.println("==============");
			System.out.println();
			System.out.print("번호 입력 : ");
			
			Scanner key = new Scanner(System.in);
			int menu = key.nextInt();
			
			if (menu == 1) {
				System.out.println();
				System.out.println("[회원 가입] 선택하였습니다.");
				BoardMemberView view = new BoardMemberView();
				MemberVO vo = view.input();
				BoardDAO dao = new BoardDAO();
				int result = dao.insertMember(vo);
				if (result == 0) {
					System.out.println("가입중 오류");
				} else {
					System.out.println("입력하신 정보가 성공적으로 추가되었습니다.");
				}
			} else if (menu == 2) {
				System.out.println();
				System.out.println("[게시물 등록] 선택하였습니다.");
				BoardInsertView view = new BoardInsertView();
				BoardVO vo = view.input();
				BoardDAO dao = new BoardDAO();
				int result = dao.insertBoard(vo);
				if (result == -1) {
					System.out.println("비회원은 작성이 불가능 합니다.");
				} else if (result == 1) {
					System.out.println("작성을 완료하였습니다.");
				} else {
					System.out.println("작성을 실패하였습니다.");
				}
			} else if (menu == 3) {
				System.out.println();
				System.out.println("[게시물 조회] 선택하였습니다.");
				String result = new BoardListView().input();
				ArrayList<BoardVO> list = new BoardDAO().getBoardList(result);
				System.out.println("조회된 리스트 입니다.");
				for (BoardVO vo : list) {
					System.out.println(vo);
				}
				System.out.println("조회가 완료되었습니다.");
				
			} else if (menu == 4){
				System.out.println();
				System.out.println("[게시물 상세 조회]를 선택하였습니다.");	
				BoardDetailView view = new BoardDetailView();
				int result = view.input();
				BoardDAO dao = new BoardDAO();
				detailVO = dao.getBoard(result); 
				detailVO.getBoard();
				
				System.out.println("조회된 결과는 다음과 같습니다.");
				
			} else if (menu == 5){
				System.out.println();
				System.out.println("[게시물 수정]을 선택하였습니다.");

				System.out.print("수정할 게시물 번호를 입력하세요 : ");
				int num = key.nextInt();
				
				BoardUpdateView view = new BoardUpdateView();
				BoardVO vo = view.input();
				if (vo.getTitle().equals("")) {
					vo.setTitle(detailVO.getTitle());
				}
				if (vo.getMain().equals("")) {
					vo.setMain(detailVO.getMain());
				}
				if (vo.getWriter().equals("")) {
					vo.setWriter(detailVO.getWriter());
				}
				BoardDAO dao = new BoardDAO();
				
				int result = dao.updateBoard(num, vo);
				if (result == 1) {
					System.out.println("게시물 수정이 완료 되였습니다.");
				} else {
					System.out.println("게시물 수정에 실패했습니다.");
				}
			} else if (menu == 6){
				System.out.println();
				System.out.println("[게시물 삭제]를 선택하였습니다.");
				System.out.print("삭제할 게시물 번호를 입력하세요 : ");
				int num = key.nextInt();
				
				System.out.print("삭제할 게시물의 암호를 입력하여 주세요 : "); 
				int del = key.nextInt();
				
				BoardDAO dao = new BoardDAO();
				int result = dao.deleteBoard(num, del);
				
				if (result == -1) {
					System.out.println("잘못된 암호입니다.");
				} else if (result == 1) {
					System.out.println("게시물 삭제를 완료되었습니다.");
				} else {
					System.out.println("게시물 삭제를 실패하였습니다.");
				}
			} else if (menu == 7){
				System.out.println();
				System.out.println("[프로그램 종료]를 선택하였습니다.");
				System.out.println("<프로그램>을 종료합니다.");
				break;
			} else {
				System.out.println("잘못 입력 하였습니다.");
			} //else
		} //while
	} // main

} // class
