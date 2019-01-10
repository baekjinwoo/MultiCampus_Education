package sqlday7.jdcb.program;

import java.util.Scanner;

public class BoardDeleteView {
	
	public String input(){
		Scanner inputSc = new Scanner(System.in);
		System.out.print("게시물 번호 : ");
		String resSeq = inputSc.nextLine();
		System.out.print("게시물 암호 : ");
		String resPwd = inputSc.nextLine();
		
		return resSeq + "::" + resPwd;
	}
}
