package homework;

import java.util.Scanner;

public class hm03 {
	public static void main(String[] args) {

		/*학생의 학번(문자), 이름, 자바점수, 알고리즘 점수, spring점수를 입력받아 
		  학번, 이름, 점수3, 총점, 평균을 인쇄하는 자바프로그램을 작성하시오
		   단, 3명을 연속받아 차례로 출력하며 자리수가 잘 맞추어지도록 printf을 사용하며 평균은 소수이하 2자리까지 계산한다*/
		Scanner sc1=new Scanner(System.in); // 스캐너 명령문
				
		//첫 번째 학생정보 입력
		System.out.print("첫 번째 학생의 학번은? ");
		String num1 = sc1.next();
		System.out.print("                    이름은? ");
		String name1 = sc1.next();
		System.out.print("              자바점수는? ");
		int ja1= sc1.nextInt();
		System.out.print("        알고리즘점수는?");
		int al1 = sc1.nextInt();
		System.out.print("   spring점수는? ");
		int sp1= sc1.nextInt();		
		System.out.println();
		int sum1 = ja1+al1+sp1;
		float aver1= sum1/3;
				
		//두 번재 학생정보 입력
		System.out.print("두 번째 학생의 학번은? ");
		String num2=sc1.next();
		System.out.print("                    이름은? ");
		String name2=sc1.next();
		System.out.print("              자바점수는? ");
		int ja2=sc1.nextInt();
		System.out.print("        알고리즘점수는?");
		int al2=sc1.nextInt();
		System.out.print("   spring점수는? ");
		int sp2=sc1.nextInt();
		System.out.println();
		int sum2= ja2+al2+sp2;
		float aver2=sum2/3;
				
		//세 번째 학생정보 입력
		
		System.out.print("세 번째 학생의 학번은?  ");
		String num3=sc1.next();
		System.out.print("                    이름은? ");
		String name3=sc1.next();
		System.out.print("              자바점수는? ");
		int ja3=sc1.nextInt();
		System.out.print("        알고리즘점수는?");
		int al3=sc1.nextInt();
		System.out.print("   spring점수는? ");
		int sp3=sc1.nextInt();
		System.out.println();
		int sum3=ja3+al3+sp3;
		float aver3=sum3/3;
				
						
		System.out.println("\t\t   <우리반 성적표>\t");
		System.out.println("학번\t 이름\t 자바\t 알고리즘\t spring\t   총점\t 평균");
		System.out.println("------------------------------------------------------");
		System.out.printf("%s\t %s\t %d\t %d\t   %d\t   %d\t %.2f",num1,name1,ja1,al1,sp1,sum1,aver1);
		System.out.println();
		System.out.printf("%s\t %s\t %d\t %d\t   %d\t   %d\t %.2f",num2,name2,ja2,al2,sp2,sum2,aver2);
		System.out.println();
		System.out.printf("%s\t %s\t %d\t %d\t   %d\t   %d\t %.2f",num3,name3,ja3,al3,sp3,sum3,aver3);
		System.out.println();
		System.out.println("------------------------------------------------------");

		/*평균값이 소수점이하 무조건 .00으로 나오는 이유
		ex) 10/3=3으로 정수/정수=정수 	즉, 정수/실수=실수 (10/3.0)
								      실수/정수=실수 (10.0/3)
								      실수/실수=실수 (10.0/3.0) */

		/* 평균값이 소수점이하 무조건 .00으로 나오는 이유
		  System.out.println(10.0/3); 7.0 실수/정수=실수 (10.0/3)
		  System.out.println(10/3.0); 7.0 정수/실수=실수 (10/3.0)
		  System.out.println(10.0/3.0); 7.0  실수/실수=실수 (10.0/3.0)

		  System.out.println(10/3); 7 10/3=3으로 정수/정수=정수 
   		// System.out.println(10.-3); 7.0이고 System.out.println(10-3); 7 참고 */				
	}
}
