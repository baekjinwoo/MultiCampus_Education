package board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import DAO.BoardDAO;
import DAO.MemberDAO;
import view.BoardDeleteView;
import view.BoardDetailView;
import view.BoardInsertView;
import view.BoardListView;
import view.BoardMemberView;
import view.BoardUpdateView;
import vo.BoardVO;
import vo.MemberVO;

public class BoardMain {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("=======�Խ��� ���α׷��Դϴ�=======");
			System.out.println("1. ȸ�� ���� ");
			System.out.println("2. �Խù� �ۼ� ");
			System.out.println("3. �Խù� ��ȸ ");
			System.out.println("4. �Խù� ���� ");
			System.out.println("5. �Խù� ���� ");
			System.out.println("6. ����  ");
			System.out.print("��ȣ �Է�: ");
			int menu = sc.nextInt();

			if (menu == 1) {
				MemberVO vo = new BoardMemberView().input();
				int d = new MemberDAO().insertMember(vo);
				if (d == 0) {
					System.out.println("������ ����");
				} else {
					System.out.println("������(��ȸ�� db����)");
				}

			} else if (menu == 2) {
				BoardVO vo = new BoardInsertView().input();
				int result = new BoardDAO().insertBoard(vo);
				if (result == -1) {
					System.out.println("ȸ������ ����");
				} else {
					System.out.println("���� ���");
				}
			} else if (menu == 3) {
				String result = new BoardListView().input();
				ArrayList<BoardVO> al = new BoardDAO().getBoardList(result);

				for (BoardVO vo : al) {
					System.out.println(vo.getSeq() + " " + vo.getTitle() + " " + vo.getWriter());
				}

				// ����ȸ
				int select = new BoardDetailView().input();
				BoardVO vo = new BoardDAO().getBoard(select);
				System.out.println(vo);

			} else if (menu == 4) {
				BoardVO vo = new BoardUpdateView().input();
				int result = new BoardDAO().UpdateBoard(vo);
				if (result == 0) {
					System.out.println("��ȣ ���� -> ������Ʈ ����");
				} else {
					System.out.println("������Ʈ ����");
				}

			} else if (menu == 5) {
				BoardVO vo = new BoardDeleteView().input();
				int result = new BoardDAO().DeleteBoard(vo);
				if (result == 0) {
					System.out.println("��ȣ ���� -> ���� ����");
				} else {
					System.out.println("���� ����");
				}

			} else {
				System.out.println("���� �����Ͽ����ϴ�.");
				return;
				// �ݺ��� ���� : break -> �̰͵� ����
				// �޼ҵ� ���� : return - (main method)������
			}

		}

	}

}
