package sqlday7.jdcb.program;

import java.util.ArrayList;
import java.util.Scanner;

// JDBC �Խ��� ���α׷��Դϴ�.
// 1. ȸ������ -> ȸ������ Ű���� �Է� - MEMBER ����
//2. �Խù� �ۼ� -> �Խù����� Ű���� �Է� - BOARD ����
//3. ȸ������ -> ������ ��ȣ �Է� 10�� �Խù� ��ȸ
//				�˻� ����, ����

public class BoardMain {

	public static void main(String[] args) {
		while(true){
			System.out.println();
			System.out.println("=== �Խ��� ���α׷��Դϴ� ===");
			System.out.println("1. ȸ������");
			System.out.println("2. �Խù� �ۼ�");
			System.out.println("3. �Խù� ��ȸ");
			System.out.println("4. ����");
			System.out.println("5. �Խù� ����");
			System.out.println("6. �Խù� ����");
			System.out.print("��ȣ �Է� : ");
			Scanner key = new Scanner(System.in);
			int menu = Integer.parseInt(key.nextLine());
			if(menu == 1){
				System.out.println("+ ȸ������ �����ϼ̽��ϴ�.");
				MemberVO vo = new BoardMemberView().input(key);
				int result = new BoardDAO().insertMember(vo);
				if(result == 0)
					System.out.println("<<< ȸ������ ���� : ���̵� �ߺ��˴ϴ� >>>");
				else
					System.out.println("<<< ȸ������ ���� >>>");
			}
			else if(menu == 2){
				System.out.println("+ �Խù� �ۼ� �����ϼ̽��ϴ�.");
				BoardVO vo = new BoardInsertView().input();
				int result = new BoardDAO().insertBoard(vo);
				if(result == -1)
					System.out.println("<<< �� �ۼ� �Ұ��� (ȸ������ �ϼ���) >>>");
				else if(result == 1)
					System.out.println("<<< �� �ۼ� �Ϸ� >>>");
				else
					System.out.println("<<< �� �ۼ� �Ұ��� >>>");
			}
			else if(menu == 3){
				System.out.println("+ �Խù� ��ȸ �����ϼ̽��ϴ�.");
				String queryFlag = new BoardListView().input();
				ArrayList<BoardVO> voList = new BoardDAO().getBoardList(queryFlag);
				if(voList.isEmpty())
					System.out.println("<<< ������ �����ϴ� �Խù��� �����ϴ�. >>>");
				else{
					for (BoardVO vo : voList) {
						System.out.println(vo);
					}
					int detailSeq = new BoardDetailView().input();
					BoardVO detailVO = new BoardDAO().getBoard(detailSeq);
					if(detailVO == null)
						System.out.println("<<< ����ȸ ���� >>>");
					else
						System.out.println(detailVO.toStringDetail());
				}
			}
			else if(menu == 4){
				System.out.println("���α׷� ���� �����ϼ̽��ϴ�.");
				key.close();
				return;
			}
			else if(menu == 5){
				System.out.println("+ �Խù� ���� �����ϼ̽��ϴ�.");
				BoardVO modVo = new BoardUpdateView().input();
				int updateResult = new BoardDAO().updateBoard(modVo);
				if(updateResult < 0)
					System.out.println("<<< ������ ������ �����ϴ� >>>");
				else if(updateResult == 0)
					System.out.println("<<< �н����� ����ġ >>>");
				else
					System.out.println("<<< �Խù� ���� �Ϸ� >>>");
			}
			else if(menu == 6){
				System.out.println("+ �Խù� ���� �����ϼ̽��ϴ�.");
				int delFlag = -1;
				String delIdPw = new BoardDeleteView().input();
				int delSeq = Integer.parseInt(delIdPw.split("::")[0]);
				BoardDAO delDAO = new BoardDAO();
				if(delDAO.checkPw(delIdPw))
					delFlag = delDAO.deleteBoard(delSeq);
				
				if(delFlag < 0)
					System.out.println("<<< �н����� ����ġ >>>");
				else if(delFlag == 0)
					System.out.println("<<< �Խù� ���� ���� >>>");
				else
					System.out.println("<<< �Խù� ���� �Ϸ� >>>");
			}
		}
	}

}
