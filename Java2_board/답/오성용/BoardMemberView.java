package sqlday7.jdcb.program;

import java.util.Scanner;

// id : 
// 암호 :
// 이름 :
// 이메일 :
// 폰번호 :
public class BoardMemberView {
	
	public MemberVO input(Scanner inputSc){
		System.out.print("- ID : ");
		String id = inputSc.nextLine();
		System.out.print("- 암호 : ");
		String pwd = inputSc.nextLine();
		System.out.print("- 이름 : ");
		String member_name = inputSc.nextLine();
		System.out.print("- 이메일 : ");
		String email = inputSc.nextLine();
		System.out.print("- 폰번호 : ");
		String phone = inputSc.nextLine();
		
		return new MemberVO(id, pwd, member_name, email, phone);
	}
	
}
