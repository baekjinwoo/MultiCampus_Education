package board;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardVO detailVO = null;
		while (true) {
			System.out.println("==============");
			System.out.println(" �Խ��� ���� ���α׷�");
			System.out.println("==============");
			System.out.println("1. ȸ�� ����");
			System.out.println("--------------");
			System.out.println("2. �Խù� �ۼ�");
			System.out.println("--------------");
			System.out.println("3. �Խù� ��ȸ");
			System.out.println("--------------");
			System.out.println("4. �Խù� �� ��ȸ");
			System.out.println("--------------");
			System.out.println("5. �Խù� ����");
			System.out.println("--------------");
			System.out.println("6. �Խù� ����");
			System.out.println("--------------");
			System.out.println("7. ����");
			System.out.println("==============");
			System.out.println();
			System.out.print("��ȣ �Է� : ");
			
			Scanner key = new Scanner(System.in);
			int menu = key.nextInt();
			
			if (menu == 1) {
				System.out.println();
				System.out.println("[ȸ�� ����] �����Ͽ����ϴ�.");
				BoardMemberView view = new BoardMemberView();
				MemberVO vo = view.input();
				BoardDAO dao = new BoardDAO();
				int result = dao.insertMember(vo);
				if (result == 0) {
					System.out.println("������ ����");
				} else {
					System.out.println("�Է��Ͻ� ������ ���������� �߰��Ǿ����ϴ�.");
				}
			} else if (menu == 2) {
				System.out.println();
				System.out.println("[�Խù� ���] �����Ͽ����ϴ�.");
				BoardInsertView view = new BoardInsertView();
				BoardVO vo = view.input();
				BoardDAO dao = new BoardDAO();
				int result = dao.insertBoard(vo);
				if (result == -1) {
					System.out.println("��ȸ���� �ۼ��� �Ұ��� �մϴ�.");
				} else if (result == 1) {
					System.out.println("�ۼ��� �Ϸ��Ͽ����ϴ�.");
				} else {
					System.out.println("�ۼ��� �����Ͽ����ϴ�.");
				}
			} else if (menu == 3) {
				System.out.println();
				System.out.println("[�Խù� ��ȸ] �����Ͽ����ϴ�.");
				String result = new BoardListView().input();
				ArrayList<BoardVO> list = new BoardDAO().getBoardList(result);
				System.out.println("��ȸ�� ����Ʈ �Դϴ�.");
				for (BoardVO vo : list) {
					System.out.println(vo);
				}
				System.out.println("��ȸ�� �Ϸ�Ǿ����ϴ�.");
				
			} else if (menu == 4){
				System.out.println();
				System.out.println("[�Խù� �� ��ȸ]�� �����Ͽ����ϴ�.");	
				BoardDetailView view = new BoardDetailView();
				int result = view.input();
				BoardDAO dao = new BoardDAO();
				detailVO = dao.getBoard(result); 
				detailVO.getBoard();
				
				System.out.println("��ȸ�� ����� ������ �����ϴ�.");
				
			} else if (menu == 5){
				System.out.println();
				System.out.println("[�Խù� ����]�� �����Ͽ����ϴ�.");

				System.out.print("������ �Խù� ��ȣ�� �Է��ϼ��� : ");
				int num = key.nextInt();
				
				BoardUpdateView view = new BoardUpdateView();
				BoardVO vo = view.input();
				if (vo.getTitle().equals("")) {
					vo.setTitle(detailVO.getTitle());
				}
				if (vo.getMain().equals("")) {
					vo.setMain(detailVO.getMain());
				}
				if (vo.getWriter().equals("")) {
					vo.setWriter(detailVO.getWriter());
				}
				BoardDAO dao = new BoardDAO();
				
				int result = dao.updateBoard(num, vo);
				if (result == 1) {
					System.out.println("�Խù� ������ �Ϸ� �ǿ����ϴ�.");
				} else {
					System.out.println("�Խù� ������ �����߽��ϴ�.");
				}
			} else if (menu == 6){
				System.out.println();
				System.out.println("[�Խù� ����]�� �����Ͽ����ϴ�.");
				System.out.print("������ �Խù� ��ȣ�� �Է��ϼ��� : ");
				int num = key.nextInt();
				
				System.out.print("������ �Խù��� ��ȣ�� �Է��Ͽ� �ּ��� : "); 
				int del = key.nextInt();
				
				BoardDAO dao = new BoardDAO();
				int result = dao.deleteBoard(num, del);
				
				if (result == -1) {
					System.out.println("�߸��� ��ȣ�Դϴ�.");
				} else if (result == 1) {
					System.out.println("�Խù� ������ �Ϸ�Ǿ����ϴ�.");
				} else {
					System.out.println("�Խù� ������ �����Ͽ����ϴ�.");
				}
			} else if (menu == 7){
				System.out.println();
				System.out.println("[���α׷� ����]�� �����Ͽ����ϴ�.");
				System.out.println("<���α׷�>�� �����մϴ�.");
				break;
			} else {
				System.out.println("�߸� �Է� �Ͽ����ϴ�.");
			} //else
		} //while
	} // main

} // class
