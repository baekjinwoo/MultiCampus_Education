package view;

import java.util.Scanner;

public class BoardDetailView {
	public int input(){
		Scanner sc=new Scanner(System.in);
		
		System.out.print("�� ��ȸ �� �Խù� ��ȣ �Է� : ");
		int detail=sc.nextInt();
		
		return detail;
	}
}
