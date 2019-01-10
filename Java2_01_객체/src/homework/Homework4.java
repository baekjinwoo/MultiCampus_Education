package homework;

import java.util.Scanner;

public class Homework4 {

	public static void main(String[] args) {
		
		int []month={31,28,31,30,31,30,31,31,30,31,30,31};
		int k=  month.length;
		
		Scanner sc=new Scanner(System.in);
		int in=sc.nextInt();
		
		System.out.println(in+"월은 "+month[in]+"입니다");
		
/*		[문제4] 아래와 같이 12달의 날수를 배열를 만들어 기억시킨후 
		원하는 month을 입력받아 그 달의 날수를 출력하시오

		[참고]
		int []month={31,28,31,30,31,30,31,31,30,31,30,31};

		--입력화면/출력화면--

		원하는 month을 입력하시오 : 3
		3월은 31일입니다.*/
	}

}
