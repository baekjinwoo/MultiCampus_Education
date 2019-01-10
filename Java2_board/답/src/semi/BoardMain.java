package semi;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		MemberView bmv = new MemberView();
		BoardView bv = new BoardView();
		
		while (true) {
			System.out.println("☆★☆★☆★☆★게시판 프로그램입니다☆★☆★☆★");
			System.out.println("☞  1. 회원 가입");
			System.out.println("☞ 2. 게시물작성");
			System.out.println("☞ 3. 게시물조회");
			System.out.println("☞ 4. 게시물수정");
			System.out.println("☞ 5. 게시물삭제");
			System.out.println("☞ 6. 종료");
			System.out.print("번호 입력 : ");

			int menu = key.nextInt();
			if (menu == 1) {
				System.out.println("회원 가입 메뉴를 선택하셨습니다.");
				bmv.input();
			} else if (menu == 2) {
				System.out.println("게시물 작성 메뉴를 선택하셨습니다");
				bv.write();
			} else if (menu == 3) {
				System.out.println("게시물 조회 메뉴를 선택하셨습니다");
				System.out.println("게시물 페이지 조회 : 1입력, 제목,내용으로 조회 : 2입력");
				int searchKey = key.nextInt();
				if (searchKey == 1) {
					bv.pageview();
					System.out.println("게시글을 상세 조회 하시겠습니까? yes : 1 , no : 2");
					int detailkey = key.nextInt();
					if (detailkey == 1) {
						bv.detailView();
					}
				} else{
					bv.search();
					System.out.println("게시글을 상세 조회 하시겠습니까? yes : 1 , no : 2");
					int detailkey = key.nextInt();
					if (detailkey == 1) {
						bv.detailView();
					}
				}
			} else if (menu == 4) {
				System.out.println("게시물 수정 메뉴를 선택하셨습니다");
				bv.update();
			} else if (menu == 5) {
				System.out.println("게시물 삭제 메뉴를 선택하셨습니다");
				bv.delete();
			} else{
				System.out.println("프로그램 종료를 선택하셨습니다");
				System.out.println("☆★☆★☆★☆★☆★☆ ★☆★☆★☆★☆★☆★☆★");
				return;
				//반복문 종료 : break;
				//메소드 종료 : return;
			}
		}
	}

}
