package solution;

import java.util.Scanner;

/* [문제1]
10보다 작은 자연수 중에서 3또는 5의 배수는 3,5,6,9 이고 이것을 모두 더하면 23이다.
1000보다 작은 자연수 중에서 3또는 5의 배수를 모두 더하면 얼마일까요?

[결과화면]
합 : 233168
*/
public class ExamTest01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum=0;
		
		for(int n=0; n<=1000; n++){
			if(n%3==0 || n%5==0){
				sum+= n;
			}
		}
		System.out.println("합 : " + sum);
	}
}
