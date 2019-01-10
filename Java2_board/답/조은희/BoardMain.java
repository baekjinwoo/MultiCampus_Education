package boardJdbc;

import java.util.Scanner;

import dao.BoardDAO;
import view.BoardDeleteView;
import view.BoardDetailView;
import view.BoardInsertView;
import view.BoardListView;
import view.BoardMemberView;
import view.BoardUpdateView;
import vo.BoardVo;
import vo.MemberVo;

public class BoardMain {

	public static void main(String[] args) {

		while (true) {
			System.out.println("==========게시판 프로그램 입니다============");

			System.out.println("1. 회원 가입");
			System.out.println("2. 게시물 작성");
			System.out.println("3. 게시물 조회");
			System.out.println("4. 게시물 수정");
			System.out.println("5. 게시물 삭제");
			System.out.println("6. 종료");
			System.out.print("번호 입력 : ");

			Scanner sc = new Scanner(System.in);

			int menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("회원가입을 선택하셨습니다.");

				BoardMemberView view = new BoardMemberView();
				MemberVo vo = view.input();

				BoardDAO dao = new BoardDAO();
				int result = dao.insertMember(vo);

				if (result == 0) {
					System.out.println("가입 중 오류");
				} else {
					System.out.println("정상 가입(조회는 DB에서 직접)");
				}

			} else if (menu == 2) {
				System.out.println("게시물 작성을 선택하셨습니다.");

				BoardInsertView view = new BoardInsertView();
				BoardVo vo = view.Input();

				BoardDAO dao = new BoardDAO();
				int result = dao.insertBoard(vo);

				if (result == -1) {
					System.out.println("글 작성 불가능(회원가입 먼저 하세요)");
				} else if (result == 1) {
					System.out.println("정상 글작성");
				} else {
					System.out.println("글 작성 불가능");
				}

			} else if (menu == 3) {
				System.out.println("게시물 조회를 선택하셨습니다.");

				BoardListView view = new BoardListView();
				String str = view.input();

				BoardDAO dao = new BoardDAO();
				String reult = dao.selectBoard(str);

				// 이런 방법으로도 만들 수 있다 (BoardListView와 selextBoard를 수정해야함)
				// ArrayList<BoardVo> list=new BoardDao().selectBoard(str);
				// for(BoardVo vo : list){
				// System.out.println(vo); }

				System.out.print("상세 조회를 하시겠습니까?(y/n) : ");
				String yn = sc.next();

				if (yn.charAt(0) == 'y' || yn.charAt(0) == 'Y') {

					int bdview = new BoardDetailView().input();
					
					BoardDAO dao2=new BoardDAO();
					String result2=dao2.getBoard(bdview);

				} else if (yn.charAt(0) == 'n' || yn.charAt(0) == 'N') {
					System.out.println("조회 취소를 선택하셨습니다.");
				}

			} else if (menu == 4) {
				System.out.println("게시물 수정을 선택하셨습니다.");
				
				BoardUpdateView view=new BoardUpdateView();
				BoardVo vo=view.input();
				
				BoardDAO dao=new BoardDAO();
				
				int result=dao.updateBoard(vo);

			} else if (menu == 5) {
				System.out.println("게시물 삭제를 선택하셨습니다.");
				
				BoardDeleteView view=new BoardDeleteView();
				BoardVo vo=view.input();
				
				BoardDAO dao =new BoardDAO();
				int result=dao.deleteBoard(vo);

			} else {
				System.out.println("프로그램 종료를 선택하셨습니다.");
				return; // return도 되고 break도 된다
			}
		}
	}
}
