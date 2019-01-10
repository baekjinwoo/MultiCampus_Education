package homework;

import java.util.Scanner;

public class hm16 {
	public static void main(String[] args) {
	/* 문제.if문 사용하기
	 * 시간을 초로 입력받아 "00시간00분00초"로 출력하는 자바프로그램을 구현하시오
	 * (단, 시간이 0시간이거나 분이 0분이면 출력결과에서는 출력되어서는 안됩니다.
	 * 
	 * ex)15789가 들어온 경우:   4시간23분9초
	 *    12456이 들어온 경우:  3시간 27분 36초
	 *    0이나 음수가 들어온 경우:  시간은 0이상의 정수를 입력해야 합니다를 출력.
	 * */ 
	
	//풀이방법(1)
		Scanner sc=new Scanner(System.in);
		System.out.print("초단위 시간을 입력하시오(초): ");
		String ss=sc.nextLine();
		int ss1=Integer.parseInt(ss);
				
		int hour=ss1/3600; //몫
		int min=(ss1%3600)/60; //나머지
		int sec=(ss1%3600)%60; //나머지

		String ss2= ("정답은  "+hour+"시"+min+"분"+sec+"초입니다");
		
		if(hour>0&&min>0&&sec>0)
			System.out.println(ss2);
		else
			System.out.print("시간은 0이상의 정수를 입력해야합니다");	
				
		//풀이방법(2)
		/*if(seconds<=0)
			System.out.println("시간은 0보다 큰 정수를 입력하시오");
				
		else if (seconds<60)//1분보다 작을경우
			System.out.println(seconds+"초");
					
		else if(seconds<3600) //1시간보다 작을경우
			min=seconds/60;
			seconds=seconds-min*60;
			System.out.println(min+"분"+seconds+"초");   
		else//1시간보다 클경우
			hour=seconds/60/60; */
	}
}
