package sqlday7.jdcb.program;

import java.util.Scanner;

public class BoardDetailView {
	
	public int input(){
		Scanner inputSc = new Scanner(System.in);
		System.out.println("");
		System.out.println("<<< �� ��ȸ ����Դϴ� >>>");
		System.out.print("- �Խù� ��ȣ : ");
		int wnum = inputSc.nextInt();
		
		return wnum;
	}
}
