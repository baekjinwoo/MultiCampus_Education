package semi;

import java.util.Scanner;

import vo.BoardVO;
import vo.MemberVO;

public class BoardView {
	public void write() {

		Scanner sc1 = new Scanner(System.in);

		System.out.println("게시물 작성");
		System.out.print("제목 : ");
		String title = sc1.nextLine();
		System.out.print("내용 입력 : ");
		String contents = sc1.nextLine();
		System.out.print("작성자 : ");
		String writer = sc1.nextLine();
		System.out.print("글비밀번호 : ");
		String password = sc1.nextLine();

		BoardVO bvo = new BoardVO(title, contents, writer, password);
		BoardDAO dao = new BoardDAO();
		dao.contentsWrite(bvo);

		System.out.println("게시물 작성 완료!!");

	}
	
	public void detailView(){
		Scanner sc1 = new Scanner(System.in);

		System.out.println("상세히 보고자 하는 게시글의 제목을 입력해주세요...");
		System.out.print("제목 : ");
		String detail = sc1.nextLine();
		BoardDAO dao = new BoardDAO();
		dao.detailView(detail);
	}

	public void pageview() { // 페이지 입력받고 5개씩 보여줌 ㅎ

		Scanner sc1 = new Scanner(System.in);

		System.out.println("검색하고자 하는 페이지를 입력해주세요 ㅎㅎ...");
		System.out.print("페이지 : ");
		int page = sc1.nextInt();

		BoardVO bvo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		dao.pageview(page);

	}

	public void search() { // 제목 혹은 내용입력

		Scanner sc1 = new Scanner(System.in);

		System.out.println("검색하고자 하는 글의 키워드를 입력해주세요 ㅎㅎ...");
		System.out.print("키워드 : ");
		String keyWord = sc1.next();

		BoardVO bvo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		dao.search(keyWord);

	}

	public void update() {
		Scanner sc1 = new Scanner(System.in);

		System.out.println("게시물 수정");
		System.out.println("작성할 때 사용한 ID를 입력하세요");
		String writer = sc1.nextLine();
		BoardDAO dao = new BoardDAO();
		dao.searchForUpdate(writer);
		if (dao.count == 1) {
			dao.count = 0;
		} else {
			System.out.println("수정할 게시물의 제목을 적어주세요.");
			String iftitle = sc1.nextLine();
			dao.search(iftitle);
			if (dao.count == 1) {
				System.out.println("제목을 잘못 입력했습니다.");
				dao.count = 0;
				return;
			} else {
				System.out.println("수정할 내용을 입력하고, 게시글 작성시 작성했던 비밀번호를 입력해주세요.");
				System.out.print("제목 : ");
				String title = sc1.nextLine();
				System.out.print("내용 입력 : ");
				String contents = sc1.nextLine();
				System.out.println("게시글 비밀번호 입력 : ");
				String password = sc1.nextLine();
				if (title != null && contents != null) {
					BoardVO bvo = new BoardVO(title, contents, writer, password);
					dao.update(bvo);
				} else {
					System.out.println("수정할 제목 및 내용을 입력해주세요!! ");
				}
			}

		}

	}

	public void delete() {
		Scanner sc1 = new Scanner(System.in);

		System.out.println("게시물 삭제");
		System.out.println("작성할 때 사용한 ID를 입력하세요");
		String writer = sc1.nextLine();
		BoardDAO dao = new BoardDAO();
		dao.searchForUpdate(writer);
		if (dao.count == 1) {
			dao.count = 0;
		} else {
			System.out.println("삭제할 게시물의 제목을 적어주세요.");
			String iftitle = sc1.nextLine();
			dao.search(iftitle);
			if (dao.count == 1) {
				System.out.println("제목을 잘못 입력했습니다.");
				dao.count = 0;
				return;
			} else{
				System.out.println("해당 게시물의 비밀번호를 입력해주세요!");
				System.out.println("게시글 비밀번호 입력 : ");
				String password = sc1.nextLine();
				dao.delete(password);
			}
		}

	}
}
