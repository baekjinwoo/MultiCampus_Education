package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardListView {
	public String input() {

		Scanner sc = new Scanner(System.in);

		System.out.println("1. 페이지 조회 ");
		System.out.println("2. 조건 조회 ");
		System.out.print("번호 입력 : ");

		int menu = sc.nextInt();
		String result = null;

		if (menu == 1) {
			System.out.print("페이지 번호 입력 : ");
			result = sc.next();
		}

		else if (menu == 2) {
			System.out.print("검색어 입력 : ");
			result = sc.next();
		}
		return result;

	}
}
