package view;

import java.util.Scanner;

public class BoardDetailView {
	
	public int input() {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		System.out.println();
		System.out.print("조회하실 게시물 번호를 입력하세요 : ");
		int number = key.nextInt();
		
		return number;
		
	}
	
}
