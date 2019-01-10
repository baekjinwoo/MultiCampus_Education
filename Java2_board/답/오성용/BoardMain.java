package sqlday7.jdcb.program;

import java.util.ArrayList;
import java.util.Scanner;

// JDBC 게시판 프로그램입니다.
// 1. 회원가입 -> 회원정보 키보드 입력 - MEMBER 저장
//2. 게시물 작성 -> 게시물내용 키보드 입력 - BOARD 저장
//3. 회원가입 -> 페이지 번호 입력 10개 게시물 조회
//				검색 제목, 내용

public class BoardMain {

	public static void main(String[] args) {
		while(true){
			System.out.println();
			System.out.println("=== 게시판 프로그램입니다 ===");
			System.out.println("1. 회원가입");
			System.out.println("2. 게시물 작성");
			System.out.println("3. 게시물 조회");
			System.out.println("4. 종료");
			System.out.println("5. 게시물 수정");
			System.out.println("6. 게시물 삭제");
			System.out.print("번호 입력 : ");
			Scanner key = new Scanner(System.in);
			int menu = Integer.parseInt(key.nextLine());
			if(menu == 1){
				System.out.println("+ 회원가입 선택하셨습니다.");
				MemberVO vo = new BoardMemberView().input(key);
				int result = new BoardDAO().insertMember(vo);
				if(result == 0)
					System.out.println("<<< 회원가입 실패 : 아이디가 중복됩니다 >>>");
				else
					System.out.println("<<< 회원가입 성공 >>>");
			}
			else if(menu == 2){
				System.out.println("+ 게시물 작성 선택하셨습니다.");
				BoardVO vo = new BoardInsertView().input();
				int result = new BoardDAO().insertBoard(vo);
				if(result == -1)
					System.out.println("<<< 글 작성 불가능 (회원가입 하세요) >>>");
				else if(result == 1)
					System.out.println("<<< 글 작성 완료 >>>");
				else
					System.out.println("<<< 글 작성 불가능 >>>");
			}
			else if(menu == 3){
				System.out.println("+ 게시물 조회 선택하셨습니다.");
				String queryFlag = new BoardListView().input();
				ArrayList<BoardVO> voList = new BoardDAO().getBoardList(queryFlag);
				if(voList.isEmpty())
					System.out.println("<<< 조건을 만족하는 게시물이 없습니다. >>>");
				else{
					for (BoardVO vo : voList) {
						System.out.println(vo);
					}
					int detailSeq = new BoardDetailView().input();
					BoardVO detailVO = new BoardDAO().getBoard(detailSeq);
					if(detailVO == null)
						System.out.println("<<< 상세조회 실패 >>>");
					else
						System.out.println(detailVO.toStringDetail());
				}
			}
			else if(menu == 4){
				System.out.println("프로그램 종료 선택하셨습니다.");
				key.close();
				return;
			}
			else if(menu == 5){
				System.out.println("+ 게시물 수정 선택하셨습니다.");
				BoardVO modVo = new BoardUpdateView().input();
				int updateResult = new BoardDAO().updateBoard(modVo);
				if(updateResult < 0)
					System.out.println("<<< 수정할 사항이 없습니다 >>>");
				else if(updateResult == 0)
					System.out.println("<<< 패스워드 불일치 >>>");
				else
					System.out.println("<<< 게시물 수정 완료 >>>");
			}
			else if(menu == 6){
				System.out.println("+ 게시물 삭제 선택하셨습니다.");
				int delFlag = -1;
				String delIdPw = new BoardDeleteView().input();
				int delSeq = Integer.parseInt(delIdPw.split("::")[0]);
				BoardDAO delDAO = new BoardDAO();
				if(delDAO.checkPw(delIdPw))
					delFlag = delDAO.deleteBoard(delSeq);
				
				if(delFlag < 0)
					System.out.println("<<< 패스워드 불일치 >>>");
				else if(delFlag == 0)
					System.out.println("<<< 게시물 삭제 실패 >>>");
				else
					System.out.println("<<< 게시물 삭제 완료 >>>");
			}
		}
	}

}
