package Homework;

import java.util.Scanner;

//2. 아래처럼 정삼각형의 모양을 출력하시오.
//아래 형태는 3줄인 경우입니다.
//3, 5, 7, 9 등 홀수줄로 생성하는 것만 가능한 것으로 간주합니다

public class HomeworkEx2 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int a=sc.nextInt();
				for(int i=1; i<=a; i++){
					for(int j=a; j>i; j--){
						System.out.print(" ");
					}
					for(int k=1; k<=(i*2)-1; k++){
						System.out.print("*");
					}
				System.out.println();
		}
	}
}
