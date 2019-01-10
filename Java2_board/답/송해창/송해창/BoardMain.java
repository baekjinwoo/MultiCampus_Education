package board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.BoardDAO;
import view.BoardDetailView;
import view.BoardInsertView;
import view.BoardListView;
import view.BoardMemberView;
import view.BoardUpdateView;
import vo.BoardVO;
import vo.MemberVO;

public class BoardMain {

	@SuppressWarnings("null")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BoardVO detailVO = null;
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("===�Խ��� ���α׷��Դϴ�===");
			System.out.println("1. ȸ������");
			System.out.println("2. �Խù� �ۼ�");
			System.out.println("3. �Խù� ��ȸ");
			System.out.println("4. �Խù� ����ȸ");
			System.out.println("5. �Խù� ����");
			System.out.println("6. �Խù� ����");
			System.out.println("7. ����");
			System.out.println("��ȣ �Է� : ");
			// �Խ��� ����Ʈ
			// 10���� : ��ȣ ���� �ۼ���
			// �� ���� ��ȸ / ���� / ����
			// CRUD

			Scanner sc1 = new Scanner(System.in);

			int menu = sc1.nextInt();

			if (menu == 1) {
				BoardMemberView view = new BoardMemberView();

				MemberVO vo = view.input();

				BoardDAO dao = new BoardDAO();
				int result = dao.insertMember(vo);

				if (result == 0) {
					System.out.println("���� �� ����");
				} else {
					System.out.println("���� ����(��ȸ�� db���� ����");
				}

				System.out.println("�Է��Ͻ� ������ ���������� �߰��Ǿ����ϴ�.");
				break;
			} else if (menu == 2) {
				BoardInsertView view = new BoardInsertView();
				BoardVO vo = view.input();
				BoardDAO dao = new BoardDAO();
				System.out.println(vo);
				int result = dao.insertBoard(vo);

				if (result == -1) {
					System.out.println("�� �ۼ��� �Ұ����մϴ�.(ȸ������ ���� �ϼ���)");
				} else if (result == 1) {
					System.out.println("���������� ���� �ۼ��Ͻ� �� �ֽ��ϴ�.");
				} else {
					System.out.println("�� �ۼ� �Ұ���(�������� ������ ���� �� �ֽ��ϴ�.)");
				}

				System.out.println("�Խù� �ۼ� �����ϼ̽��ϴ�.");
			} else if (menu == 3) {

				String result = new BoardListView().input();
				// result�� �˻������� �������� ��� �Ǵ���? �װŴ� boarddao���� �Ǵ���.

				ArrayList<BoardVO> blist = new BoardDAO().getBoardList(result);
				System.out.println("��ȸ�� ����Ʈ�� ������ �����ϴ�");
				for (BoardVO vo : blist) {
					System.out.println(vo); // (vo.toString() //
											// ��Ű����.Ŭ������@16�ڸ���ü�ּҰ�
				}
				System.out.println("��ȸ �Ϸ�Ǿ����ϴ�.");

			} else if (menu == 4) {

				BoardDetailView view = new BoardDetailView();
				int result = view.input();

				BoardDAO dao = new BoardDAO();
				detailVO = dao.getBoard(result);
				detailVO.getBoard();

			} else if (menu == 5) {

				BoardUpdateView view = new BoardUpdateView();

				BoardVO vo = view.input();
				
				if (vo.getTitle().equals("")) {
					vo.setTitle(detailVO.getTitle());
				}
				if (vo.getStory().equals("")) {
					vo.setStory(detailVO.getStory());
				}
				if (vo.getWriter().equals("")) {
					vo.setWriter(detailVO.getWriter());
				}
				

				BoardDAO dao = new BoardDAO();

				int result = dao.updateBoard(vo);

				if (result == -1) {
					System.out.println("���� �ȉ���ϴ�.");
				} else {
					System.out.println("��������ϴ�..");

				}

			} else if (menu == 6) {

				System.out.println("�Խù� ���� �����Ͽ����ϴ�.");
				System.out.println("������ �Խù� ��ȣ �Է�");
				int numberr = sc1.nextInt();

				System.out.println("������ �Խù� ��ȣ �Է��ض�");
				int del = sc1.nextInt();

				BoardDAO dao = new BoardDAO();

				int result = dao.deleteBoard(numberr, del);

				if (result == -1) {
					System.out.println("���� �ȉ���ϴ�.");
				} else {
					System.out.println("��������ϴ�.");

				}

			} else {
				System.out.println("���α׷� ���� �����ϼ̽��ϴ�.");
				break;
				// �ݺ��� ���� : break, �޼��� ���� return
			} // else
		} // while

	}// main
}// class

/*
 * Scanner sc = new Scanner(System.in); Connection con1 = null;
 * Class.forName("oracle.jdbc.driver.OracleDriver"); con1 =
 * DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr",
 * "hr");
 */