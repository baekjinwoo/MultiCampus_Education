package view;

import java.util.Scanner;

public class BoardListView {
	
	public String input() {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		System.out.println();
		System.out.println("1. 페이지 조회");
		System.out.println("2. 조건 조회");
		System.out.print("번호 입력 : ");
		int search = key.nextInt();
		String result = "";
		if (search == 1) {
			System.out.print("페이지 번호 입력 : ");
			result = key.next();
		} else if (search == 2) {
			System.out.print("검색어 입력 : ");
			result = key.next();
		} else {
			System.out.println("잘못 입력");
		}
		return result;
	}
	
		
}
