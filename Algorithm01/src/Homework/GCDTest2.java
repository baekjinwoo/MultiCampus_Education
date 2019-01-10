package Homework;

import java.util.Scanner;

//최대공약수2 재귀함수
public class GCDTest2 {
	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.print("수를 입력하세요: ");
	int a=sc.nextInt();
	int b=sc.nextInt();
	
	int result= new GCDTest2().gcd(a,b);
	System.out.println("최대공약수는  "+result);
	}
	
	
	
	
	public static int gcd(int max, int min){ //두 개수 매개변수
		//1. 큰 수 판단
		if(max<min){
			int temp=max;
			max=min;
			min=temp;
		}
		//2. 큰- 작은:
		if(max==min){
			return min;
		}
		else{
			return gcd(max-min, min);
		}
		//2-1. 0이면 종료(두 수가같으면): 최대공약수 리턴
		
		//2-2. 0아니면(두 수가 다르면) gcd메소드 재귀호출; gcd메소드(max-min,min)재귀호출
		
	}
}
