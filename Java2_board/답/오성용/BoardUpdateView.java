package sqlday7.jdcb.program;

import java.util.Scanner;

public class BoardUpdateView {
	
	public BoardVO input(){
		Scanner inputSc = new Scanner(System.in);
		System.out.print("�Խù� ��ȣ : ");int mId = Integer.parseInt(inputSc.nextLine());
		System.out.print("���� : ");	String mTitle = inputSc.nextLine();
		System.out.print("���� : ");	String mContent = inputSc.nextLine();
		System.out.print("�ۼ��� : ");	String mWriter = inputSc.nextLine();
		System.out.print("�۾�ȣ �Է� : ");	String mPwd = inputSc.nextLine();
		
		return new BoardVO(mId, mTitle, mContent, null, mWriter, mPwd, 0);
	}
}
