package solution;

import java.util.Random;

/*[문제3]50개의 난수를 만들어서 다음과 같이 출력하시오
   조건1) 30 - 75 사이의 수 일것
   조건2) 1줄에 6개씩 표시하시오  
   
[결과 화면]   
12      72      74      0       20      89
84      83      53      0       95      53
68      55      89      6       20      68
17      9       75      56      17      85
62      33      7       34      85      28
28      55      95      31      69      22
30      92      1       16      88      80
64      55      71      12      29      72
20      41
합=2420
*/
public class ExamTest03 {
	public static void main(String[] args) {
		//한줄에 6개씩 50개
		//Random rd = new Random();
		//int n = rd.nextInt(45);
		
		//int n2= (int)((Math.random()*45)+35);  35~79사이의 난수(계산법은 79-35=45를 곱하고, 35를 더한다) 
		//int n3= (int)((Math.random()*16)+65); 65~80사이의 난수 ==> 0~0.9999 =>0~15.999 =>65~80
		
		int sum = 0;
		int[] bae = new int[50];
		int jul = bae.length;

		for (int i = 0; i < jul; i++) {
			
			if (i % 6 == 0) {
				System.out.println();
			}
			
			int n = (int) (Math.random() * 46) + 30; // 30~75
			System.out.print(n + " ");
			sum += n;

			
		}
		System.out.println("\n합계" + sum);

	}
}
