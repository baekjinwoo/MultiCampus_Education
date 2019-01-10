package sqlday7.jdcb.program;

import java.util.Scanner;

public class BoardListView {

	public String input(){
		Scanner inputSc = new Scanner(System.in);
		System.out.println("- 1. 페이지 조회");
		System.out.println("- 2. 조건 조회");
		int selNum = Integer.parseInt(inputSc.nextLine());
		String option = null;
		// 2 , title , content, writer 포함되어 있으면 다 찾아옴.
		if(selNum == 1){
			// 페이지당 3개씩
			System.out.print("= 페이지 번호 입력 : ");
			option = inputSc.nextLine();
		} else{
			System.out.print("= 검색어 입력 : ");
			option = inputSc.nextLine();
		}
		
		return option;
	}
}
