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
		while (true) {
			System.out.println("�Խ��� ���α׷��Դϴ�.");
			System.out.println("1. ȸ������");
			System.out.println("2. �Խù� �ۼ�");
			System.out.println("3. �Խù� ��ȸ");
			System.out.println("4. �Խù� ����");
			System.out.println("5. �Խù� ����");
			System.out.println("6. ����");
			System.out.print("��ȣ �Է� : ");

			Scanner key = new Scanner(System.in);
			int menu = key.nextInt();

			if (menu == 1) {
				BoardMemberView view = new BoardMemberView();
				MemberVO vo = view.input();

				BoardDAO dao = new BoardDAO();
				int result = dao.insertMember(vo);

				if (result == 0) {
					System.out.println("ȸ������ �� ���� �߻�");
				} else {
					System.out.println("ȸ������ �Ϸ�(��ȸ�� DB����)");
				}

			} else if (menu == 2) {
				BoardInsertView view = new BoardInsertView();
				BoardVO vo = view.input();

				BoardDAO dao = new BoardDAO();
				int result = dao.insertBoard(vo);

				if (result == -1) {
					System.out.println("ȸ�������� ���ּ���.");
				} else if (result==1) {
					System.out.println("�Խù� �ۼ� �Ϸ�");
				} else {
					System.out.println("�Խù� �ۼ� �� ���� �߻�");
				}
				
			} else if (menu == 3) {
				String result = new BoardListView().input();
				
				ArrayList<BoardVO> list = new BoardDAO().getBoardList(result);
				
				System.out.println("==��ȸ�� ����Ʈ==");
				
				for(BoardVO vo:list) {
					System.out.println(vo);
				}
				
				System.out.println("==��ȸ �Ϸ�==");
				System.out.println();
				System.out.println("1. �Խù� ����ȸ");
				System.out.println("2. ó������ ���ư���");
				System.out.print("��ȣ �Է� : ");
				menu=key.nextInt();
				
				if(menu==1) {
					int detail=new BoardDetailView().input();
					
					BoardVO vo = new BoardDAO().getBoard(detail);
					
					System.out.println("��ȣ : "+vo.getNum());
					System.out.println("���� : "+vo.getTitle());
					System.out.println("���� : "+vo.getText());
					System.out.println("�ۼ��� : "+vo.getWmember());
					System.out.println("�ð� : "+vo.getWtime());
					System.out.println("��ȸ�� : "+vo.getCnt()+"\n");
					
				} else if(menu==2) {
					System.out.println("ó������ ���Ʊ⸦ �����ϼ̽��ϴ�.\n");
				}
				
			} else if (menu == 4) {
				BoardVO vo= new BoardUpdateView().input();
				
				int result = new BoardDAO().updateBoard(vo);
				
				if(result==0) {
					System.out.println("��ȣ ����");
				} else {
					System.out.println("�Խù��� �����Ǿ����ϴ�.");
				}
				
			} else if (menu == 5) {
				System.out.print("������ �� ��ȣ �Է� : ");
				int num=key.nextInt();
				System.out.print("��ȣ �Է� : ");
				String pwd=key.next();
				
				int result = new BoardDAO().deleteBoard(num, pwd);
				
				if(result==0) {
					System.out.println("��ȣ ����");
				} else {
					System.out.println("�Խù��� �����Ǿ����ϴ�.");
				}
				
			} else if (menu == 6) {
				System.out.println("���Ḧ �����ϼ̽��ϴ�.");
				return; // �޼��� ����
			} // else
		} // while
	} // main

} // class
