package sqlday7.jdcb.program;

import java.util.Scanner;

// id : 
// ��ȣ :
// �̸� :
// �̸��� :
// ����ȣ :
public class BoardMemberView {
	
	public MemberVO input(Scanner inputSc){
		System.out.print("- ID : ");
		String id = inputSc.nextLine();
		System.out.print("- ��ȣ : ");
		String pwd = inputSc.nextLine();
		System.out.print("- �̸� : ");
		String member_name = inputSc.nextLine();
		System.out.print("- �̸��� : ");
		String email = inputSc.nextLine();
		System.out.print("- ����ȣ : ");
		String phone = inputSc.nextLine();
		
		return new MemberVO(id, pwd, member_name, email, phone);
	}
	
}
