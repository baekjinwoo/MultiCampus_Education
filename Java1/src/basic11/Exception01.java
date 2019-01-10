package basic11;

import java.util.Scanner;

public class Exception01 {
	public static void main(String[] args) {
		// 1. 개발자가 직접 에러처리
		try {
			Scanner sc1 = new Scanner(System.in);
			System.out.print("숫자하나:");
			String a1 = sc1.nextLine();
			int i = Integer.parseInt(a1);
			System.out.print("숫자둘:");
			String a2 = sc1.nextLine();
			int j = Integer.parseInt(a2);
			if (j == 0) {
				System.out.println("0으로 나눌 수 없다!");
				throw new ArithmeticException("오잉"); // throw는 개발자가 직접 에러를 처리해주는
			}
			int k = i / j;
			System.out.println(k);
		} catch (NumberFormatException e) { // 숫자입력여부만 체크한다. //컴파일러한테 에러를 처리부탁하는 것
			System.out.println("숫자로 입력하세요");
		}
		/*
		 * catch(ArithmeticException e){ //0입력여부만 체크한다 System.out.println(
		 * "0이 아닌 값으로 입력하세요"); } //이와같이 간단한 예외처리는 catch(Exception e){}만 하면되고
		 * 자세하게 하려면 위와같이 작성하면 된다.
		 */
		catch (Exception e) {
			// System.out.println("에러났다는~~~");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("굳-드");
		}
	}

}
