package sqlday7.jdcb.program;

import java.util.Scanner;

public class BoardDeleteView {
	
	public String input(){
		Scanner inputSc = new Scanner(System.in);
		System.out.print("�Խù� ��ȣ : ");
		String resSeq = inputSc.nextLine();
		System.out.print("�Խù� ��ȣ : ");
		String resPwd = inputSc.nextLine();
		
		return resSeq + "::" + resPwd;
	}
}
