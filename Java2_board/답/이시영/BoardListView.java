package view;

import java.util.Scanner;

import vo.BoardVO;

public class BoardListView {
	public String input() {

		Scanner sc = new Scanner(System.in);

		System.out.println("1. ������ ��ȸ ");
		System.out.println("2. ���� ��ȸ ");
		System.out.print("��ȣ �Է� : ");

		int menu = sc.nextInt();
		String result = null;

		if (menu == 1) {
			System.out.print("������ ��ȣ �Է� : ");
			result = sc.next();
		}

		else if (menu == 2) {
			System.out.print("�˻��� �Է� : ");
			result = sc.next();
		}
		return result;

	}
}
