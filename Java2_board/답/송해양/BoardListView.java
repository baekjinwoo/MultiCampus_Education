package view;

import java.util.Scanner;

public class BoardListView {
	
	public String input() {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		System.out.println();
		System.out.println("1. ������ ��ȸ");
		System.out.println("2. ���� ��ȸ");
		System.out.print("��ȣ �Է� : ");
		int search = key.nextInt();
		String result = "";
		if (search == 1) {
			System.out.print("������ ��ȣ �Է� : ");
			result = key.next();
		} else if (search == 2) {
			System.out.print("�˻��� �Է� : ");
			result = key.next();
		} else {
			System.out.println("�߸� �Է�");
		}
		return result;
	}
	
		
}
