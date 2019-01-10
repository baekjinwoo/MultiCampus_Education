package homework;

import java.util.Random;
import java.util.Scanner;

public class hm06 {
	public static void main(String[] args) {
		/*(문제) 문자열"yes" "no" "wait a minute"를 준비해놓고 
		  질문 입력시 임의로 선택답변하는 자바 프로그램을 작성하시오
		 ex) are you Student? yes~	  */
		
		Scanner sc=new Scanner(System.in);
		System.out.print("질문을 해주세요: ");
		String munja=sc.nextLine();
		
		Random rd1=new Random();
		int dap=rd1.nextInt(3)+1;//1,2,3 
		String ss=(dap==0)?"yes":((dap==1)?"no":"wait a minute"); 
			//String 변수를 yes,no로 초기화해서 그 변수를 넣을 필요없이 다이렉트로 넣어라.
		System.out.println(ss);
	}
}
