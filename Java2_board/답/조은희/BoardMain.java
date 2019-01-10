package boardJdbc;

import java.util.Scanner;

import dao.BoardDAO;
import view.BoardDeleteView;
import view.BoardDetailView;
import view.BoardInsertView;
import view.BoardListView;
import view.BoardMemberView;
import view.BoardUpdateView;
import vo.BoardVo;
import vo.MemberVo;

public class BoardMain {

	public static void main(String[] args) {

		while (true) {
			System.out.println("==========�Խ��� ���α׷� �Դϴ�============");

			System.out.println("1. ȸ�� ����");
			System.out.println("2. �Խù� �ۼ�");
			System.out.println("3. �Խù� ��ȸ");
			System.out.println("4. �Խù� ����");
			System.out.println("5. �Խù� ����");
			System.out.println("6. ����");
			System.out.print("��ȣ �Է� : ");

			Scanner sc = new Scanner(System.in);

			int menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("ȸ�������� �����ϼ̽��ϴ�.");

				BoardMemberView view = new BoardMemberView();
				MemberVo vo = view.input();

				BoardDAO dao = new BoardDAO();
				int result = dao.insertMember(vo);

				if (result == 0) {
					System.out.println("���� �� ����");
				} else {
					System.out.println("���� ����(��ȸ�� DB���� ����)");
				}

			} else if (menu == 2) {
				System.out.println("�Խù� �ۼ��� �����ϼ̽��ϴ�.");

				BoardInsertView view = new BoardInsertView();
				BoardVo vo = view.Input();

				BoardDAO dao = new BoardDAO();
				int result = dao.insertBoard(vo);

				if (result == -1) {
					System.out.println("�� �ۼ� �Ұ���(ȸ������ ���� �ϼ���)");
				} else if (result == 1) {
					System.out.println("���� ���ۼ�");
				} else {
					System.out.println("�� �ۼ� �Ұ���");
				}

			} else if (menu == 3) {
				System.out.println("�Խù� ��ȸ�� �����ϼ̽��ϴ�.");

				BoardListView view = new BoardListView();
				String str = view.input();

				BoardDAO dao = new BoardDAO();
				String reult = dao.selectBoard(str);

				// �̷� ������ε� ���� �� �ִ� (BoardListView�� selextBoard�� �����ؾ���)
				// ArrayList<BoardVo> list=new BoardDao().selectBoard(str);
				// for(BoardVo vo : list){
				// System.out.println(vo); }

				System.out.print("�� ��ȸ�� �Ͻðڽ��ϱ�?(y/n) : ");
				String yn = sc.next();

				if (yn.charAt(0) == 'y' || yn.charAt(0) == 'Y') {

					int bdview = new BoardDetailView().input();
					
					BoardDAO dao2=new BoardDAO();
					String result2=dao2.getBoard(bdview);

				} else if (yn.charAt(0) == 'n' || yn.charAt(0) == 'N') {
					System.out.println("��ȸ ��Ҹ� �����ϼ̽��ϴ�.");
				}

			} else if (menu == 4) {
				System.out.println("�Խù� ������ �����ϼ̽��ϴ�.");
				
				BoardUpdateView view=new BoardUpdateView();
				BoardVo vo=view.input();
				
				BoardDAO dao=new BoardDAO();
				
				int result=dao.updateBoard(vo);

			} else if (menu == 5) {
				System.out.println("�Խù� ������ �����ϼ̽��ϴ�.");
				
				BoardDeleteView view=new BoardDeleteView();
				BoardVo vo=view.input();
				
				BoardDAO dao =new BoardDAO();
				int result=dao.deleteBoard(vo);

			} else {
				System.out.println("���α׷� ���Ḧ �����ϼ̽��ϴ�.");
				return; // return�� �ǰ� break�� �ȴ�
			}
		}
	}
}
