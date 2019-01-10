package sqlday7.jdcb.program;

import java.util.Scanner;

public class BoardInsertView {

	public BoardVO input(){
		Scanner inputSc = new Scanner(System.in);
		System.out.print("- 제목 : ");
		String title = inputSc.nextLine();
		System.out.print("- 내용 : ");
		String contents = inputSc.nextLine();
		System.out.print("- 작성자 : ");
		String writer_name = inputSc.nextLine();
		System.out.print("- 글암호 : ");
		String writer_pwd = inputSc.nextLine();
		
		return new BoardVO(title, contents, writer_name, writer_pwd);
	}
}
