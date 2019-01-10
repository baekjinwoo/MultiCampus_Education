package view;

import java.util.Scanner;

public class BoardListView {

	/*
	 * 1. 페이지조회 2. 조건 조회
	 * 
	 * 번호 입력 : 1 페이지 번호 : 1
	 * 
	 * 번호 입력 2 검색어 입력 : 자바 -> 내용/작성자/제목 다 찾아라
	 */

	public String input() {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. 페이지 조회");
			System.out.println("2. 조건 조회");
			System.out.print("번호 입력 : ");		int num = sc.nextInt();

			if (num == 1) {
				System.out.print("페이지 번호 입력 : ");
				String page = sc.next();
				String str=num+":"+page;
				return str;
			} else if (num == 2) {
				System.out.print("검색어 입력 : ");
				String check = sc.next();
				String str=num+":"+check;
				return str;
			} else {
				System.out.println("입력 오류입니다.(1-2 중 선택해 주세요)");
			}
		}

	}

}
