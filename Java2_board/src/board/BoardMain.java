package board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import DAO.BoardDAO;
import VO.BoardVO;
import VO.MemberVO;

public class BoardMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println();
			System.out.println("==�Խ��� ���α׷�==");
			System.out.println("1. ȸ������");
			System.out.println("2. �Խù� �ۼ�");
			System.out.println("3. �Խù� ��ȸ");
			System.out.println("4. ����");
			System.out.println("5. �Խù� ����");
			System.out.println("6. �Խù� ����");

			System.out.println("��ȣ �Է�: ");
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("ȸ�������� �����ϼ̽��ϴ�");

			/*���1
			 * 	MemberVO vo= new BoardMemberView().input();
				System.out.println("���� ����Ǿ���!!");
				int dao = new BoardDAO().insertMember(vo);
			 */
				
			//���2
				BoardMemberView view=new BoardMemberView();
				MemberVO vo= view.input();
				BoardDAO dao= new BoardDAO();
				int result = dao.insertMember(vo);
				if(result==0){
				System.out.println("������ ����");
				}
				else{
				System.out.println("������ �Ϸ�");
				}
			} else if (menu == 2) {
				System.out.println("�Խù� �ۼ��� �����ϼ̽��ϴ�");
				BoardInsertView view=new BoardInsertView();
				//System.out.println("1�׽�Ʈ");
				BoardVO vo= view.input();
				//System.out.println("2�׽�Ʈ");
				BoardDAO dao = new BoardDAO();
				//System.out.println("3�׽�Ʈ");
				int result = dao.insertBoard(vo);
				if(result==1){
					System.out.println("������ ���ۼ�");
				}
				else{
					System.out.println("�� �ۼ� �Ұ���(ȸ������ �� ��)");
				}
				
				
			} else if (menu == 3) {
				System.out.println("�Խù� ��ȸ�� �����ϼ̽��ϴ�");
				BoardListView view=new BoardListView();
				String result= view.input(); //��ȯ�� str���ڿ�
				
	
				//if(result.equals(1)&&result.equals(2)){
				if(result.charAt(0)!='0'){
				BoardDAO dao = new BoardDAO();
				 ArrayList<BoardVO> list = new BoardDAO().getBoardList(result);
					System.out.println("��ȸ�� ����Ʈ�� ������ �����ϴ�.");

					for(BoardVO vo: list){
						System.out.println(vo); //toString����
					} 
					System.out.println("��ȸ�� �Ϸ�Ǿ����ϴ�.");
				}
			
				
				else if(result.charAt(0)=='0'){
					System.out.println("11");
					int result2 = new BoardDetailView().input();
					System.out.println("234");
					ArrayList<BoardVO> list = new BoardDAO().getBoard(result2);
					System.out.println("��ȸ�� ����Ʈ�� ������ �����ϴ�.");

					Iterator<BoardVO>iter = list.iterator();
					while(iter.hasNext()){
						BoardVO vo= iter.next();
						System.out.println("��ȣ: "+ vo.getNum());
						System.out.println("���: "+vo.getPw());
						System.out.println("����: "+vo.getTitle());
						System.out.println("����: "+vo.getText());
						System.out.println("�۰�: "+vo.getWriter());
						System.out.println("�ð�: "+vo.getEditime());
						System.out.println("��ȸ��: "+vo.getTotal());
						
					}
					System.out.println("��ȸ�� �Ϸ�Ǿ����ϴ�.");
					
				}
			
			} else if (menu == 4){
				System.out.println("���α׷� ���Ḧ �����ϼ̽��ϴ�");
				return;
				// �ݺ��� ����: break;�� ����
				// �޼ҵ� ����: return;�� ����
				// ������ ����: system.exit(0);
				// while�� ���� ���ѹݺ��ϴٰ� return�̳� break�� ������ �����Ѵ�.
			
				
				
			}else if (menu == 5){//update
				System.out.println("�Խù��� �����ϰڽ��ϱ�?");
				BoardUpdateView view=new BoardUpdateView();
				BoardVO vo=view.input();
				
				BoardDAO dao=new BoardDAO();
				
				int result=dao.updateBoard(vo);

				
			}else if (menu == 6){//delete
				System.out.println("�Խù��� �����ϰڽ��ϱ�?");
				BoardDAO dao = new BoardDAO();
				int result2 = new BoardDetailView().input();
				int result = dao.deleteBoard(result2);
				
				System.out.println(result +"���� �����Ǿ����ϴ�.");
				
				
			}
		}
	}
}

