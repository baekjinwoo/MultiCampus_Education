package sqlday7.jdcb.program;

import java.util.Scanner;

public class BoardListView {

	public String input(){
		Scanner inputSc = new Scanner(System.in);
		System.out.println("- 1. ������ ��ȸ");
		System.out.println("- 2. ���� ��ȸ");
		int selNum = Integer.parseInt(inputSc.nextLine());
		String option = null;
		// 2 , title , content, writer ���ԵǾ� ������ �� ã�ƿ�.
		if(selNum == 1){
			// �������� 3����
			System.out.print("= ������ ��ȣ �Է� : ");
			option = inputSc.nextLine();
		} else{
			System.out.print("= �˻��� �Է� : ");
			option = inputSc.nextLine();
		}
		
		return option;
	}
}
