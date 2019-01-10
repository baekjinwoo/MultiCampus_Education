package solution;

import java.io.IOException;
import java.util.Scanner;

/* 
[문제6] 2자리의 난수를 발생하여 발생된 숫자를 맞추는 게임 프로그램
 난수발생) 
1. int a=(int)(Math.random()*100) : 0 - 99 사이의 난수
2. ① import java.util.Random;
       ② Random 변수1 = new Random();
       ③ int 변수2 = 변수1.nextInt(최대값); 
                0 ~ (최대값 - 1)사이의 임의의 수

[결과 화면]
*** 난수가 발생하였습니다...맞추어 보세요...*** 

숫자 입력 : 50
컴퓨터의 숫자가 더 큽니다..

숫자 입력 : 90
컴퓨터의 숫자가 더 작습니다..

          :

숫자 입력 : 83
추카추카...xx번만에 맞추셨습니다...


다시할까요(Y/N) 

*/
public class ExamTest06 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);
		int a =(int)(Math.random()*90)+10; //괄호필수
		int count = 0;
		System.out.println("*** 난수가 발생하였습니다... 맞추어 보세요...***");

		while (true) { // while(num<10 || num>99)
			System.out.print("숫자입력 : "); // 정답을 맞출때까지 입력
			int n = sc.nextInt(); // 정답을 맞출때까지 입력
			if (n > a) {
				System.out.println("입력한 값이 더 큽니다");
				count++;
			} else if (n < a) {
				System.out.println("입력한 값이 더 작습니다");
				count++;
			} else {
				System.out.println("추카추카..." + count + "번만에 맞추셨습니다");
				System.out.print("다시할까요(y/n): ");
				String b =sc.next();  //sc.nextLint();을 하게되면 문자열이 작성되기전에 while문이 다시 시작된다
				
				if (b.equals("y")) { //String으로쓸땐 equals값비교 ==참조값 비교
					System.out.println("*** 난수가 발생하였습니다... 맞추어 보세요...***");
					continue;
				} else if (b.equals("n")){
					break;
				}
			}
			
			
		}
	}
}
