package sqlday7.jdcb.program;

import java.util.Scanner;

public class BoardUpdateView {
	
	public BoardVO input(){
		Scanner inputSc = new Scanner(System.in);
		System.out.print("게시물 번호 : ");int mId = Integer.parseInt(inputSc.nextLine());
		System.out.print("제목 : ");	String mTitle = inputSc.nextLine();
		System.out.print("내용 : ");	String mContent = inputSc.nextLine();
		System.out.print("작성자 : ");	String mWriter = inputSc.nextLine();
		System.out.print("글암호 입력 : ");	String mPwd = inputSc.nextLine();
		
		return new BoardVO(mId, mTitle, mContent, null, mWriter, mPwd, 0);
	}
}
