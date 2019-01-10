package view;

import java.util.Scanner;

public class BoardDetailView {

	public int input(){
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("검색할 게시물 번호 : ");		int num=sc.nextInt();
		
		return num;
	}	
}
