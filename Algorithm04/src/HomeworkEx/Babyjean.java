package HomeworkEx;

import java.util.Scanner;

/*[문제]베이진 게임

0~9 사이의 숫자 카드에서 임의의 카드 6장을 뽑았을때 3장의 카드가 연속적인 번호를 갖는 경우를 run이라고 하고
3장의 카드가 동일한 번호를 갖는 경우를 triplet 이라고 한다 
그리고 6장의 카드가 run 과 triplet 로만 구성된 경우를 baby-gin으로 부른다 
6자리의 숫자를 입력받아 baby-gin 여부를 판단하는 프로그램을 작성하시오 

676767  <--  두개의 triplet 이므로 baby-gin(666,777)

054060  <--  한개의 run과 한개의 triplete 이므로 baby-gin임   (456, 000)
101123  <-- 아님

*/

public class Babyjean {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for (int i = 0; i < a; i++) {
			int in = (int) (Math.random() * 9);
			System.out.println("결국 못풀었음. 다음에 다시 풀어볼 것");
		}
		
		for(int i=0; i<a; i++){
			
		}
		
		
		
		
	}
}
