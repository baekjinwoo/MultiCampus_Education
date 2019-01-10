package semi;

import java.util.Scanner;

import vo.BoardVO;
import vo.MemberVO;

public class BoardView {
	public void write() {

		Scanner sc1 = new Scanner(System.in);

		System.out.println("�Խù� �ۼ�");
		System.out.print("���� : ");
		String title = sc1.nextLine();
		System.out.print("���� �Է� : ");
		String contents = sc1.nextLine();
		System.out.print("�ۼ��� : ");
		String writer = sc1.nextLine();
		System.out.print("�ۺ�й�ȣ : ");
		String password = sc1.nextLine();

		BoardVO bvo = new BoardVO(title, contents, writer, password);
		BoardDAO dao = new BoardDAO();
		dao.contentsWrite(bvo);

		System.out.println("�Խù� �ۼ� �Ϸ�!!");

	}
	
	public void detailView(){
		Scanner sc1 = new Scanner(System.in);

		System.out.println("���� ������ �ϴ� �Խñ��� ������ �Է����ּ���...");
		System.out.print("���� : ");
		String detail = sc1.nextLine();
		BoardDAO dao = new BoardDAO();
		dao.detailView(detail);
	}

	public void pageview() { // ������ �Է¹ް� 5���� ������ ��

		Scanner sc1 = new Scanner(System.in);

		System.out.println("�˻��ϰ��� �ϴ� �������� �Է����ּ��� ����...");
		System.out.print("������ : ");
		int page = sc1.nextInt();

		BoardVO bvo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		dao.pageview(page);

	}

	public void search() { // ���� Ȥ�� �����Է�

		Scanner sc1 = new Scanner(System.in);

		System.out.println("�˻��ϰ��� �ϴ� ���� Ű���带 �Է����ּ��� ����...");
		System.out.print("Ű���� : ");
		String keyWord = sc1.next();

		BoardVO bvo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		dao.search(keyWord);

	}

	public void update() {
		Scanner sc1 = new Scanner(System.in);

		System.out.println("�Խù� ����");
		System.out.println("�ۼ��� �� ����� ID�� �Է��ϼ���");
		String writer = sc1.nextLine();
		BoardDAO dao = new BoardDAO();
		dao.searchForUpdate(writer);
		if (dao.count == 1) {
			dao.count = 0;
		} else {
			System.out.println("������ �Խù��� ������ �����ּ���.");
			String iftitle = sc1.nextLine();
			dao.search(iftitle);
			if (dao.count == 1) {
				System.out.println("������ �߸� �Է��߽��ϴ�.");
				dao.count = 0;
				return;
			} else {
				System.out.println("������ ������ �Է��ϰ�, �Խñ� �ۼ��� �ۼ��ߴ� ��й�ȣ�� �Է����ּ���.");
				System.out.print("���� : ");
				String title = sc1.nextLine();
				System.out.print("���� �Է� : ");
				String contents = sc1.nextLine();
				System.out.println("�Խñ� ��й�ȣ �Է� : ");
				String password = sc1.nextLine();
				if (title != null && contents != null) {
					BoardVO bvo = new BoardVO(title, contents, writer, password);
					dao.update(bvo);
				} else {
					System.out.println("������ ���� �� ������ �Է����ּ���!! ");
				}
			}

		}

	}

	public void delete() {
		Scanner sc1 = new Scanner(System.in);

		System.out.println("�Խù� ����");
		System.out.println("�ۼ��� �� ����� ID�� �Է��ϼ���");
		String writer = sc1.nextLine();
		BoardDAO dao = new BoardDAO();
		dao.searchForUpdate(writer);
		if (dao.count == 1) {
			dao.count = 0;
		} else {
			System.out.println("������ �Խù��� ������ �����ּ���.");
			String iftitle = sc1.nextLine();
			dao.search(iftitle);
			if (dao.count == 1) {
				System.out.println("������ �߸� �Է��߽��ϴ�.");
				dao.count = 0;
				return;
			} else{
				System.out.println("�ش� �Խù��� ��й�ȣ�� �Է����ּ���!");
				System.out.println("�Խñ� ��й�ȣ �Է� : ");
				String password = sc1.nextLine();
				dao.delete(password);
			}
		}

	}
}
