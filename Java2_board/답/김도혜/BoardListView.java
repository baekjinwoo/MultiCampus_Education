package view;

import java.util.Scanner;

public class BoardListView {
	Scanner sc = new Scanner(System.in);
	String result = null;
	
	public String input(){
		
		System.out.println("1. 페이지 조회   2. 조건 조회");
		String select = sc.nextLine();
		
		if(select.equals("1")){
			System.out.print("페이지 번호 입력> ");
			result = sc.next();			
		}else if(select.equals("2")){
			System.out.print("검색어 입력> ");
			result = sc.next();
		}
		
		return result;
	}
	
	
}
