package view;

import java.util.Scanner;

public class BoardDetailView {
	public int input(){
		Scanner sc=new Scanner(System.in);
		
		System.out.print("상세 조회 할 게시물 번호 입력 : ");
		int detail=sc.nextInt();
		
		return detail;
	}
}
