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
		while (true) {
			System.out.println("게시판 프로그램입니다.");
			System.out.println("1. 회원가입");
			System.out.println("2. 게시물 작성");
			System.out.println("3. 게시물 조회");
			System.out.println("4. 게시물 수정");
			System.out.println("5. 게시물 삭제");
			System.out.println("6. 종료");
			System.out.print("번호 입력 : ");

			Scanner key = new Scanner(System.in);
			int menu = key.nextInt();

			if (menu == 1) {
				BoardMemberView view = new BoardMemberView();
				MemberVO vo = view.input();

				BoardDAO dao = new BoardDAO();
				int result = dao.insertMember(vo);

				if (result == 0) {
					System.out.println("회원가입 중 오류 발생");
				} else {
					System.out.println("회원가입 완료(조회는 DB에서)");
				}

			} else if (menu == 2) {
				BoardInsertView view = new BoardInsertView();
				BoardVO vo = view.input();

				BoardDAO dao = new BoardDAO();
				int result = dao.insertBoard(vo);

				if (result == -1) {
					System.out.println("회원가입을 해주세요.");
				} else if (result==1) {
					System.out.println("게시물 작성 완료");
				} else {
					System.out.println("게시물 작성 중 오류 발생");
				}
				
			} else if (menu == 3) {
				String result = new BoardListView().input();
				
				ArrayList<BoardVO> list = new BoardDAO().getBoardList(result);
				
				System.out.println("==조회된 리스트==");
				
				for(BoardVO vo:list) {
					System.out.println(vo);
				}
				
				System.out.println("==조회 완료==");
				System.out.println();
				System.out.println("1. 게시물 상세조회");
				System.out.println("2. 처음으로 돌아가기");
				System.out.print("번호 입력 : ");
				menu=key.nextInt();
				
				if(menu==1) {
					int detail=new BoardDetailView().input();
					
					BoardVO vo = new BoardDAO().getBoard(detail);
					
					System.out.println("번호 : "+vo.getNum());
					System.out.println("제목 : "+vo.getTitle());
					System.out.println("내용 : "+vo.getText());
					System.out.println("작성자 : "+vo.getWmember());
					System.out.println("시간 : "+vo.getWtime());
					System.out.println("조회수 : "+vo.getCnt()+"\n");
					
				} else if(menu==2) {
					System.out.println("처음으로 돌아기를 선택하셨습니다.\n");
				}
				
			} else if (menu == 4) {
				BoardVO vo= new BoardUpdateView().input();
				
				int result = new BoardDAO().updateBoard(vo);
				
				if(result==0) {
					System.out.println("암호 오류");
				} else {
					System.out.println("게시물이 수정되었습니다.");
				}
				
			} else if (menu == 5) {
				System.out.print("삭제할 글 번호 입력 : ");
				int num=key.nextInt();
				System.out.print("암호 입력 : ");
				String pwd=key.next();
				
				int result = new BoardDAO().deleteBoard(num, pwd);
				
				if(result==0) {
					System.out.println("암호 오류");
				} else {
					System.out.println("게시물이 삭제되었습니다.");
				}
				
			} else if (menu == 6) {
				System.out.println("종료를 선택하셨습니다.");
				return; // 메서드 종료
			} // else
		} // while
	} // main

} // class
