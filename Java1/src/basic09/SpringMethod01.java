package basic09;

import java.util.Scanner;

//equal과 CompareTo를 이용한 비교
public class SpringMethod01 {
	public static void main(String[] args) {
		//String클래스 내에 정의된 생성자와 메서드의 목록 
		// 로그인과 패스워드는 바보,온달
		// 반드시 꼭 확실히 같아야
		// equals, compareTo==0 (p.469)
		// 앞>뒤 :양수   //앞<뒤: 음수// 앞=뒤: 같으면 0 
						
		Scanner sc=new Scanner(System.in);
		System.out.println("Login ID 입력 :");
		String s1=sc.next();
		System.out.println("Password 입력 : ");
		String s2=sc.next();
				
		if(s1.equals("babo")&&s2.compareTo("ondal")==0){ //equals나 compareTo 둘중하나쓰기
			System.out.println("회원이시군요");
		}
		else{
			System.out.println("누구냐~넌~");
		}
	}
}
