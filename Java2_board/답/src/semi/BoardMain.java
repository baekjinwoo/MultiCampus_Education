package semi;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		MemberView bmv = new MemberView();
		BoardView bv = new BoardView();
		
		while (true) {
			System.out.println("�١ڡ١ڡ١ڡ١ڰԽ��� ���α׷��Դϴ١١ڡ١ڡ١�");
			System.out.println("��  1. ȸ�� ����");
			System.out.println("�� 2. �Խù��ۼ�");
			System.out.println("�� 3. �Խù���ȸ");
			System.out.println("�� 4. �Խù�����");
			System.out.println("�� 5. �Խù�����");
			System.out.println("�� 6. ����");
			System.out.print("��ȣ �Է� : ");

			int menu = key.nextInt();
			if (menu == 1) {
				System.out.println("ȸ�� ���� �޴��� �����ϼ̽��ϴ�.");
				bmv.input();
			} else if (menu == 2) {
				System.out.println("�Խù� �ۼ� �޴��� �����ϼ̽��ϴ�");
				bv.write();
			} else if (menu == 3) {
				System.out.println("�Խù� ��ȸ �޴��� �����ϼ̽��ϴ�");
				System.out.println("�Խù� ������ ��ȸ : 1�Է�, ����,�������� ��ȸ : 2�Է�");
				int searchKey = key.nextInt();
				if (searchKey == 1) {
					bv.pageview();
					System.out.println("�Խñ��� �� ��ȸ �Ͻðڽ��ϱ�? yes : 1 , no : 2");
					int detailkey = key.nextInt();
					if (detailkey == 1) {
						bv.detailView();
					}
				} else{
					bv.search();
					System.out.println("�Խñ��� �� ��ȸ �Ͻðڽ��ϱ�? yes : 1 , no : 2");
					int detailkey = key.nextInt();
					if (detailkey == 1) {
						bv.detailView();
					}
				}
			} else if (menu == 4) {
				System.out.println("�Խù� ���� �޴��� �����ϼ̽��ϴ�");
				bv.update();
			} else if (menu == 5) {
				System.out.println("�Խù� ���� �޴��� �����ϼ̽��ϴ�");
				bv.delete();
			} else{
				System.out.println("���α׷� ���Ḧ �����ϼ̽��ϴ�");
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ� �ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				return;
				//�ݺ��� ���� : break;
				//�޼ҵ� ���� : return;
			}
		}
	}

}
