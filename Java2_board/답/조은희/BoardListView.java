package view;

import java.util.Scanner;

public class BoardListView {

	/*
	 * 1. ��������ȸ 2. ���� ��ȸ
	 * 
	 * ��ȣ �Է� : 1 ������ ��ȣ : 1
	 * 
	 * ��ȣ �Է� 2 �˻��� �Է� : �ڹ� -> ����/�ۼ���/���� �� ã�ƶ�
	 */

	public String input() {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. ������ ��ȸ");
			System.out.println("2. ���� ��ȸ");
			System.out.print("��ȣ �Է� : ");		int num = sc.nextInt();

			if (num == 1) {
				System.out.print("������ ��ȣ �Է� : ");
				String page = sc.next();
				String str=num+":"+page;
				return str;
			} else if (num == 2) {
				System.out.print("�˻��� �Է� : ");
				String check = sc.next();
				String str=num+":"+check;
				return str;
			} else {
				System.out.println("�Է� �����Դϴ�.(1-2 �� ������ �ּ���)");
			}
		}

	}

}
