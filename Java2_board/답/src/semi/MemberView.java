package semi;

import java.util.Scanner;

import vo.MemberVO;

public class MemberView {
	public void input() {
		Scanner sc1 = new Scanner(System.in);

		System.out.println("회원 가입을 위한 정보를 입력해주세요 ㅎㅎ...");
		System.out.print("id : ");
		String id = sc1.next();
		System.out.print("암호 : ");
		String pwd = sc1.next();
		System.out.print("이름 : ");
		String name = sc1.next();
		System.out.print("이메일 : ");
		String email = sc1.next();
		System.out.print("폰번호 : ");
		String phone = sc1.next();

		MemberVO vo = new MemberVO(id, pwd, name, email, phone);
		MemberDAO dao = new MemberDAO();
		dao.insetMember(vo);

	}
}
