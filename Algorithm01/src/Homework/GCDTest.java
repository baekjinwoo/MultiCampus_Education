/*
 	1. 재귀호출문제
 	두 자연수 최대공약수 구하기
 	int i=12, j=18일때 => 반복문/ 재귀호출
  
 * */ 
/*최소공약수엿음
 * public class HomeworkEx1 {
	public static void main(String[] args) {
		
		int i=12;
		int j=18;
		int result=0;
		
		if((i/2)%2==0 && (j/2)%2==0){
			result = (i/2)/2 * (j/2)/2;
		}
		else if((i/2)%3==0 && (j/2)%3==0){
			result = (i/2)/3 * (j/2)/3;
		}
		else if(i%2==0 && j%2==0){
			result = (i/2)* (j/2);
		}
		else if(i%3==0 && j%3==0){
			result = (i/3) * (j/3);
			
		}
		System.out.println(result);
			
	}
}
*/

package Homework;

import java.util.Scanner;

//great common divisor
//최대공약수1 공식
public class GCDTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 수 입력: ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		int count=0;
		//a의 약수를 구해라
		for(int i=1; i<=a; i++){ //sysout
			if(a%i==0){
				count++;
				System.out.println(i+"는약수");
			}
		}
		System.out.println("약수의 개수는"+count);
		
		
		/*//a의 약수를 구해라(시간성능 줄이기)
				System.out.println("1는 약수");
				for(int i=2; i<a; i++){ //sysout
					if(a%i==0){
						System.out.println(i+"는약수");
					}
				}
				System.out.println(a+"는 약수");*/
		
		
//최대공약수 구하기 에러코드1------------------------------------------
/*		//a,b의 공약수
		if(a<b){ a=b; }
		for( int i=1; i<=a; i++){
			if(a%i==0 && b%i ==0){
				System.out.println(i+"는 약수");
			}
		}
		
		int gcd=0;
		if(a<b){a=b;}
		for( int i=1; i<=a; i++){
			if(a%i==0 && b%i ==0){
				System.out.println(i+"는 약수");
				gcd=i;
			}
		}
		System.out.println("최대공약수는 "+gcd);
		
		
//최대공약수 구하기 에러코드2------------------------------------------
		int max=a, min=b, temp;
		while(true){ //두수 뺀 : 0
			if(max<min){
				temp=max;
				max=min;
				min=temp;
			}
			max= max-min; //또는 빼지말고 max==min
			System.out.println(max+","+min); //검증용
			if(max==0){ //큰수-작은수=0될때까지 반복한다
				gcd=min;
				break;
			}
		}//while-end
	System.out.println("최대공약수는 "+gcd);*/
	

		
//최대공약수 구하기 정상코드------------------------------------------
		int gcd=0;
	
		while(a!=0){ //두수 뺀 : 0
			if(a<b){
				gcd=a;
				a=b;	
				b=gcd;
			}
			a=a-b;
		}
		System.out.println("최대공약수는 "+b);
		}
	}
