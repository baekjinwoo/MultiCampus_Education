package solution;

import java.util.Scanner;

/*[문제12]초를 입력하여 분과 초를 출력하시오
0이 입력될때 까지 계속 반복한다
음수가 입력되면 다시 입력을 받는다

[실행결과]
초 입력 : 250
[4]분 [10]초 입니다

초입력 : -84
초입력 : -12
초입력 : 123
[2]분 [3]초 입니다
초입력 : 0
프로그램을 종료합니다
*/
public class ExamTest12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sec;
		int min;

		// 조건
		while(true){ //무한루프가 아니라면?
			System.out.print("초 입력: ");
			int n = sc.nextInt();
		if (n > 0){
			System.out.println("[" + n / 60 + "]분 " + "[" + (n % 60) + "]초 입니다"); break; // [몫]분 [나머지]초 입니다
		}
		else if (n < 0) {
			continue;
		}
		else {//n==0일떄,
			System.out.println("프로그램을 종료합니다");
			break;
			}
		}
		sc.close();
	}
}
