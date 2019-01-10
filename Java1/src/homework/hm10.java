package homework;

import java.util.Scanner;

public class hm10 {
	public static void main(String[] args) {
	//윤년처리를 메서드를 이용해서 연도를 입력받아 윤년여부를 판별하는 자바 프로그램을 작성하시오.
		Scanner sc=new Scanner(System.in);
		System.out.print("연도를 입력하시오: ");
		int year=sc.nextInt();
		year1(year);
		//System.out.println(year1(year));
	}
											//if{ return "윤년" } else {return "평년"}으로 메인메소드에 3형식으로 풀어도된다.
	public static int year1(int year){ //public static void year1(int y)로 return없이 2형식으로 풀어도된다.
		if(year%4==0&&year%100!=0||year%400==0) 
			System.out.print("윤년입니다");
			//return "윤년";
		else 
			System.out.print("평년입니다");
			//return "평년";
		return year;
	}
}
