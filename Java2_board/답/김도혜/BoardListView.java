package view;

import java.util.Scanner;

public class BoardListView {
	Scanner sc = new Scanner(System.in);
	String result = null;
	
	public String input(){
		
		System.out.println("1. ������ ��ȸ   2. ���� ��ȸ");
		String select = sc.nextLine();
		
		if(select.equals("1")){
			System.out.print("������ ��ȣ �Է�> ");
			result = sc.next();			
		}else if(select.equals("2")){
			System.out.print("�˻��� �Է�> ");
			result = sc.next();
		}
		
		return result;
	}
	
	
}
