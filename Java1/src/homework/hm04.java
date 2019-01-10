package homework;

import java.util.Scanner;

public class hm04 {
	public static void main(String[] args) {
		//(1)년도를 입력받아 짝수하면 "코코"보러가고 홀수면 "신과함께 보러가자를 출력하는 자바 프로그램을 작성하시오
		/*Scanner sc=new Scanner(System.in);
				
		System.out.print("년도를 입력하시오: ");
		int year1=sc.nextInt(); //String썻는대 오류뜸. 문자는 나눌수가 없음.
		System.out.println((year1%2==0)?"짝수니까 코코보자":"홀수니까 신과함께보자");*/
						
///////////////////////////////////////////////////////////////////////////////
		
		//(2)년도를 입력받아 짝수하면 "코코"보러가고 홀수면 "신과함께 보러가자를 출력하는 자바 프로그램을 작성하시오
		//따옴표가 붙어진 상태의 다 문자로 받은다음에 필요할때만 숫자따옴표를 때자 
				
		Scanner sc=new Scanner(System.in);
				
		System.out.print("년도를 입력하시오: ");
		String i=sc.nextLine(); //"2018"
		
		//객체.메소드
		int year1=Integer.parseInt(i); //"2018"->2018
		//"2018,34"-->2018.34 //Double.parseDouble(s)

		String result=(year1%2==0)?"코코":"신과함께";
		System.out.println(result);

		
		
	}
}
