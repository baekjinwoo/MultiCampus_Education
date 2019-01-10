package Recursion;

import java.util.Scanner;

//factorial: 구글< 자연수 : 현재값과 현재보다 작은 값의 곱
//1!=1 2!=2*1 3!=3*2*1 
//10!=10*9*8*....*1

//1. 팩토리얼 : 반복문
/*public class Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("값을 입력하세요: ");
		int mul=1; int in = sc.nextInt();
		
		for(int i =1; i<=in;i++){ //10!
			mul*=i;
			System.out.println("i : "+ mul);
		}
	}
}*/


//2. 팩토리얼 : 재귀함수
public class Factorial {
	public static int facto(int n){
		int result = 1;
		if(n==1){
			return result;
		}
		else{
			result= n*facto(n-1); //함수자체 facto(n-1)를 호출할 수 없는 이유는, 자신을 반복해서 호출하면서 함수안에 연산들도 이루어져야 하기 때문에 
			return result;		 //(이전수행의 결과를 받아와야 연산할수 잇기때문에. 필요로 하기 때문에)
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("값을 입력하세요: ");
		int input = sc.nextInt();
		System.out.println(input+"! = "+new Factorial().facto(input));
		
		
	}
}

