package board;

import java.util.Scanner;

import VO.BoardVO;

public class BoardListView {
	public String input() { //returnŸ�� String���� �مf��
		Scanner sc = new Scanner(System.in);
		BoardVO vo = new BoardVO();
		System.out.println("(1)������ ��ȸ \t(2)������ȸ \t (3)����ȸ");
		
		
		
		int search = sc.nextInt();
		String str = null;
		if (search == 1) {
			System.out.print("������ ��ȣ�Է�: ");
			str = sc.next();
		}
		else if (search == 2) {
			System.out.print("(����, ����, �ۼ��� ����)�˻��� �Է�: ");
			str = sc.next();
			if (str == vo.getTitle() || str == vo.getText() || str == vo.getWriter()) {
			}
		} // else-if-end
		
		else if (search ==3){
			String a = String.valueOf(0);
			
			str= a;
		}
		return str; // return�� if �ۿ� �����ν� ��ȯ����
	}// input-end
}
