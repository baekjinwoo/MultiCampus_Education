package view;

import static java.lang.System.exit;
import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

import biz.MemberBiz;
import vo.MemberVo;

public class MemberMain {
	MemberVo ob = null; 
	MemberBiz biz = null;
	Scanner sc = null;

	public MemberMain() {
		ob = new MemberVo(); //ob라는 객체를 하나 생성.
		biz = new MemberBiz();
		sc = new Scanner(in);
	}

	public void menu() {
		int n = 0;
		String name = null;
		while (true) {
			out.print("1.추가 2.삭제 3.전체보기 4.찾기 5.종료 \n선택(1~5): ");
			n = sc.nextInt();

			switch (n) {
			case 1:					
				out.print("이름을 입력 : ");		ob.setName(sc.next());
				out.print("연락처 입력 : ");		ob.setPhone(sc.next());

				biz.insertMember(ob);	
				break;						

			case 2:
				out.print("삭제할 이름을 입력 : ");	name = (sc.next());
				biz.deleteMember(name);
				break;

			case 3:
				biz.getMemberList();
				break;

			case 4:
				out.print("찾을이름을 입력 : ");	name = (sc.next());
				biz.getMember(name);
				break;
			case 5:
				sc.close();
				exit(0);
				break;
			
			default:
				out.println("입력오류!!\n");
			}
		}
	}

	public static void main(String[] args) {
		new MemberMain().menu();
	}
}
