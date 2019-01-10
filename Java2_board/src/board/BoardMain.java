package board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import DAO.BoardDAO;
import VO.BoardVO;
import VO.MemberVO;

public class BoardMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println();
			System.out.println("==게시판 프로그램==");
			System.out.println("1. 회원관리");
			System.out.println("2. 게시물 작성");
			System.out.println("3. 게시물 조회");
			System.out.println("4. 종료");
			System.out.println("5. 게시물 수정");
			System.out.println("6. 게시물 삭제");

			System.out.println("번호 입력: ");
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("회원가입을 선택하셨습니다");

			/*방법1
			 * 	MemberVO vo= new BoardMemberView().input();
				System.out.println("값이 저장되엇다!!");
				int dao = new BoardDAO().insertMember(vo);
			 */
				
			//방법2
				BoardMemberView view=new BoardMemberView();
				MemberVO vo= view.input();
				BoardDAO dao= new BoardDAO();
				int result = dao.insertMember(vo);
				if(result==0){
				System.out.println("가입중 오류");
				}
				else{
				System.out.println("정상가입 완료");
				}
			} else if (menu == 2) {
				System.out.println("게시물 작성을 선택하셨습니다");
				BoardInsertView view=new BoardInsertView();
				//System.out.println("1테스트");
				BoardVO vo= view.input();
				//System.out.println("2테스트");
				BoardDAO dao = new BoardDAO();
				//System.out.println("3테스트");
				int result = dao.insertBoard(vo);
				if(result==1){
					System.out.println("정상적 글작성");
				}
				else{
					System.out.println("글 작성 불가능(회원가입 할 것)");
				}
				
				
			} else if (menu == 3) {
				System.out.println("게시물 조회을 선택하셨습니다");
				BoardListView view=new BoardListView();
				String result= view.input(); //반환된 str문자열
				
	
				//if(result.equals(1)&&result.equals(2)){
				if(result.charAt(0)!='0'){
				BoardDAO dao = new BoardDAO();
				 ArrayList<BoardVO> list = new BoardDAO().getBoardList(result);
					System.out.println("조회된 리스트는 다음과 같습니다.");

					for(BoardVO vo: list){
						System.out.println(vo); //toString생략
					} 
					System.out.println("조회가 완료되었습니다.");
				}
			
				
				else if(result.charAt(0)=='0'){
					System.out.println("11");
					int result2 = new BoardDetailView().input();
					System.out.println("234");
					ArrayList<BoardVO> list = new BoardDAO().getBoard(result2);
					System.out.println("조회된 리스트는 다음과 같습니다.");

					Iterator<BoardVO>iter = list.iterator();
					while(iter.hasNext()){
						BoardVO vo= iter.next();
						System.out.println("번호: "+ vo.getNum());
						System.out.println("비번: "+vo.getPw());
						System.out.println("제목: "+vo.getTitle());
						System.out.println("내용: "+vo.getText());
						System.out.println("작가: "+vo.getWriter());
						System.out.println("시간: "+vo.getEditime());
						System.out.println("조회수: "+vo.getTotal());
						
					}
					System.out.println("조회가 완료되었습니다.");
					
				}
			
			} else if (menu == 4){
				System.out.println("프로그램 종료를 선택하셨습니다");
				return;
				// 반복문 종료: break;도 좋고
				// 메소드 종료: return;도 좋다
				// 강제적 종료: system.exit(0);
				// while에 의해 무한반복하다가 return이나 break를 만나면 종료한다.
			
				
				
			}else if (menu == 5){//update
				System.out.println("게시물을 수정하겠습니까?");
				BoardUpdateView view=new BoardUpdateView();
				BoardVO vo=view.input();
				
				BoardDAO dao=new BoardDAO();
				
				int result=dao.updateBoard(vo);

				
			}else if (menu == 6){//delete
				System.out.println("게시물을 삭제하겠습니까?");
				BoardDAO dao = new BoardDAO();
				int result2 = new BoardDetailView().input();
				int result = dao.deleteBoard(result2);
				
				System.out.println(result +"행이 삭제되었습니다.");
				
				
			}
		}
	}
}

