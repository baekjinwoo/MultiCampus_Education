package view;

import java.util.Scanner;

public class BoardDetailView {
	Scanner sc = new Scanner(System.in);

	
	public int input(){
		
		System.out.print("상세조회 게시물 번호 입력> ");
		int s = sc.nextInt();
		
		return s;
	}
	
	
}
