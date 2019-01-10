package Recursion;

import java.util.Scanner;


//피보나치 수열 (등차수열) 1 1 2 3 5 8 13 ....
//1. 피보나치-for문
/*public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("값을 입력하세요: ");
		int in =sc.nextInt();
		
		int first =1;
		int second =1;
		int tmp=0;
		
		  for(int i = 3 ; i <= in ; i++){
			   tmp = first + second;
			   first = second;
			   second = tmp;
		  }
		  System.out.println(tmp);
	}
}*/


//2. 피보나치- 재귀함수
public class Fibonacci {
	public static int fibon(int n) {
		if (n == 1 || n == 2) {
			return 1; 
		} else {
			return fibon(n - 1) + fibon(n - 2); //O(2n)이고, 꼬리순환이다(메서드의 끝에서 이전값을 반복)
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("값을 입력하세요: ");
		int in =sc.nextInt();
        System.out.println(new Fibonacci().fibon(in)); //2.1) 최종값만 출력
		
        for(int i=3; i<=in; i++){
        	System.out.println(i+"번째의 수열값= "+new Fibonacci().fibon(i)); //2.2) 각 행마다 출력
		 }
	}
}
