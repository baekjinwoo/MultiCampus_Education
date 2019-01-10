package basic09;

import java.util.Scanner;

//예외처리란, 개발자가 수정할 수 있는 에러를 사전에 예방하는 것. 비정상적인 종료를 막는다.
public class ExceptionEx {
	public static void main(String[] args) {
//		 try {} : 혹시 에러가 날 가능성이 있는 부분을 try{}로 감싼다.
//		 catch{} : 만약 에러가 났을때, 처리할 부분을 적어주는 것
//		 finally{}: 무조건 해야할 부분을 적어주는 것. 예를들면 GC가 제거하지못하는 네트워크를 소멸자가 끊어주는 명령어를 작성(생략가능)
//		try->catch->finally 순서대로 한다								
						
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("숫자하나");

			int i = sc.nextInt();
			System.out.print("숫자 둘");
			
			int j = sc.nextInt();
			int k = i / j;
			System.out.println(k);
		
		} catch (Exception e) { // Exception은 내장클래스. 예외클래스의 조상이다.
			System.out.println("에러가 났습니다.");
			// System.out.println(e.getMessage());
			e.printStackTrace();
		
		} finally {
			System.out.println("굳-드");
		}
	}
}
