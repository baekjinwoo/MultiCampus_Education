package homework;

import java.util.Scanner;

public class hm15 {
	public static void main(String[] args) {
		/* 문제.
		 * switch문의 이상한 성격을 역이용하여 매달의 날짜수를 출력하시오
		 * (단, 12번 물어보는 것은 가능하나 출력관계작업은 3번 해야한다)
		 */
		Scanner sc=new Scanner(System.in);
		System.out.print("달월을 입력하시오:(월) ");
		String ss1=sc.nextLine();
		int ss2=Integer.parseInt(ss1);
		
		String ss3="null";
		switch(ss2){
		case 2: ss3="28일";	break;
		
		case 4:	case 6: case 9:	case 11: ss3="30일"; break;
						
		case 1:
		case 3:
		case 5: 
		case 7:	
		case 8:	
		case 10:	
		case 12: ss3="31일";
				 break;
		default: 
		}
		System.out.println("해당 월은"+ss3+" 입니다");
	}
}
