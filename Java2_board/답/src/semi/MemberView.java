package semi;

import java.util.Scanner;

import vo.MemberVO;

public class MemberView {
	public void input() {
		Scanner sc1 = new Scanner(System.in);

		System.out.println("ȸ�� ������ ���� ������ �Է����ּ��� ����...");
		System.out.print("id : ");
		String id = sc1.next();
		System.out.print("��ȣ : ");
		String pwd = sc1.next();
		System.out.print("�̸� : ");
		String name = sc1.next();
		System.out.print("�̸��� : ");
		String email = sc1.next();
		System.out.print("����ȣ : ");
		String phone = sc1.next();

		MemberVO vo = new MemberVO(id, pwd, name, email, phone);
		MemberDAO dao = new MemberDAO();
		dao.insetMember(vo);

	}
}
