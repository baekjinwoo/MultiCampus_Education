package sqlday7.jdcb.program;

import java.util.Scanner;

public class BoardInsertView {

	public BoardVO input(){
		Scanner inputSc = new Scanner(System.in);
		System.out.print("- ���� : ");
		String title = inputSc.nextLine();
		System.out.print("- ���� : ");
		String contents = inputSc.nextLine();
		System.out.print("- �ۼ��� : ");
		String writer_name = inputSc.nextLine();
		System.out.print("- �۾�ȣ : ");
		String writer_pwd = inputSc.nextLine();
		
		return new BoardVO(title, contents, writer_name, writer_pwd);
	}
}
