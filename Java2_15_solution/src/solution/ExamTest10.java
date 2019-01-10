package solution;

import java.util.Scanner;

/*[문제10] 가위, 바위, 보 게임
컴퓨터가(com) 난수 1~3중 하나를 발생하고 가위(1), 바위(2), 보(3)로 사용한다
사용자가(user) 1~3중 입력하여 승패를 결정한다

[실행결과]
가위(1), 바위(2), 보(3) 입력 : 2

컴퓨터 : 보         사용자 : 가위     결과 : You Win!!

컴퓨터 : 가위     사용자 : 보         결과 : You Lose!!

컴퓨터 : 바위     사용자 : 바위     결과 : You Draw!!

*/
public class ExamTest10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = (int) (Math.random() * 3) + 1; // 3-1을 곱한다. //1~3범위
		int n = 0;

		while (true) {
			System.out.print("가위(1), 바위(2), 보(3) 입력: ");
			n = sc.nextInt();
			if (n >= 1 && n <= 3) {
				if (r > n) {
					System.out.println("\n컴퓨터 : " + r + "\t" + "사용자 : " + n + "\t" + "결과 : " + "You Win!!"); break;
				} else if (r < n) {
					System.out.println("\n컴퓨터 : " + r + "\t" + "사용자 : " + n + "\t" + "결과 : " + "You Lose!!"); break;
				} else {
					System.out.println("\n컴퓨터 : " + r + "\t" + "사용자 : " + n + "\t" + "결과 : " + "You Draw!!"); break;
				}
			} else if (!(n >= 1 && n <= 3)) {
				System.out.println("\n잘못입력하셧습니다");
			}

		}
	}
}
