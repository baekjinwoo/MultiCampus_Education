package homework;

import java.util.Scanner;

public class hm05 {
	public static void main(String[] args) {
		/*(문제) i해가 윤년인가? 
		 지구가 한 바퀴 도는대 걸리는 공존시간 365.2422	 4년이면(0.2422*4=0.96...) =~ 거의1
		 4년에 한번 윤년
		 100년에 한번이 평년
		 400년에 한번 윤년*/
		
		/*<문제분석>
		 윤년
		 4로 나누어 떨어지고
		 100으로 나누어 안떨어지거나
		 400으로 나누어떨어지거나*/
		
		/*<순서도>
		 년도입력
		 	 윤년인지 물어
		 결과출력
		 i%4==0 && i%100!=0 || i%400==0*/
		
		/*<코딩>
		 String aa=(i%4==0&& i%100!=0|| i%400==0)?"윤년":"평년";
		 System.out.println(aa); */
		
		Scanner sc=new Scanner(System.in);
		System.out.print("년도를 작성하시오: ");
		String dab =sc.nextLine();
		int i=Integer.parseInt(dab);

		String yun4=(i%4==0)?"4년마다 윤년이다":"평년이다"; //4배
		System.out.println(yun4);
		
		String yun100=(i%100==0)?"100년마다 윤년이다":"평년이다"; //100배
		System.out.println(yun100);
		
		String yun400=(i%400==0)?"400년마다 윤년이다":"평년이다"; //400배
		System.out.println(yun400);
	}
}
