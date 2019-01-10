package solution;

import java.io.IOException;
import java.util.Scanner;

/*
[문제4]년도를 입력받아 윤년/평년 구하기
(공식) 
①년도를 4로 나누어 떨어져야 함 
②년도를 100으로나누어 떨어지지 않거나 년도를 400으로 나누어 떨어져야 함
③ ①과 ②은 둘다 만족해야 함
[예시] 4(윤년), 100(평년), 400(윤년)임 


[결과 화면]
년도 입력 : 2000
윤년

년도 입력 : 2001
평년

년도 입력 : 2004
윤년
*/
public class ExamTest04 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc= new Scanner(System.in);
		System.out.print("년도 입력: ");
		int year = sc.nextInt();

		if(year%4==0 && year%100!=0 || year%400==0){
			System.out.println("윤년");
		}
		else {
			System.out.println("평년");
		}
		sc.close();
		
	}
}
