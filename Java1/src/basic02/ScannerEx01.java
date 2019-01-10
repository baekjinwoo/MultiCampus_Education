package basic02;

import java.util.Scanner;

public class ScannerEx01 {
	public static void main(String[] args) {
		//Scanner (콘솔창에 키보드"입력"외 2개)
		Scanner mola=new Scanner(System.in);

		System.out.print("\n1번: ");
		int chat = mola.nextInt();
		System.out.print(chat+"\n");
		
		System.out.print("2번: ");
		String majayong=mola.next();
		System.out.print(majayong+"\n");
		
		System.out.print("3번: ");
		Double kk=mola.nextDouble();
		System.out.print(kk);
		
		System.out.println("문자하나 넣어주세요=");
		char c1000=mola.next().charAt(0); //Char의 단어 abcd초기화시 0번지인 a만 출력가능.
		String s1=mola.next(); // String의 단어 abcd 초기화시 번지수상관없이 전체 출력가능.
		
		System.out.println(c1000);
		System.out.println(s1);
	}
}
