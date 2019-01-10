package homework;

import java.util.Random;
import java.util.Scanner;

public class hm17 {
	public static void main(String[] args) {
	/* 문제.
	 * 영어문자열을 입력받아 해당 문자열중 임의로 3개의 문자를 무작위로 출력하시오.
	 * (중복출력가능) ex) APPLE, EPA
	 * */
		Scanner sc=new Scanner(System.in);
		System.out.print("영어 문자열을 입력하세요: ");
		String ss=sc.nextLine();
		Random rd=new Random();
			
			
	/*풀이방법1.
	 * 	int a=rd.nextInt(ss.length()); //임의의 번지수
		int a2=rd.nextInt(ss.length());
		int a3=rd.nextInt(ss.length());
		
		int b1=rd.nextInt(a); //임의의번지수를 랜덤함수의 변수에 저장
		int b2=rd.nextInt(a);
		int b3=rd.nextInt(a);
				
		System.out.print(a); //임의의 번지수 출력
		System.out.print(""+a2);
		System.out.println(""+a3);
				
		System.out.print(ss.charAt(b1)); //저장된 하나의 랜덤함수 변수를 정수화해서 출력
		System.out.print(" "+ss.charAt(b2)); 
		System.out.print(" "+ss.charAt(b3)); */

	//풀이방법2.		
		int dap1=ss.charAt(rd.nextInt(ss.length())); 
		int dap2=ss.charAt(rd.nextInt(ss.length()));
		int dap3=ss.charAt(rd.nextInt(ss.length())); 
		System.out.print(dap1+"\t");
		System.out.print(dap2+"\t");
		System.out.print(dap3);

	}
}
