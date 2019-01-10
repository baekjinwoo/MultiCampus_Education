package sqlday7.jdcb.program;

import java.util.Scanner;

public class BoardDetailView {
	
	public int input(){
		Scanner inputSc = new Scanner(System.in);
		System.out.println("");
		System.out.println("<<< 상세 조회 기능입니다 >>>");
		System.out.print("- 게시물 번호 : ");
		int wnum = inputSc.nextInt();
		
		return wnum;
	}
}
