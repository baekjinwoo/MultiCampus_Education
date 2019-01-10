package Homework;

import java.util.Scanner;

//3. 4. 소수 
//소수 : 1과 자신수로만 나누어 떨어지는 수( % --> 0)
//입력 10 50

public class HomeworkEx4 {
	public static void main(String[] args) {

//기본_소수구하기
/*		Scanner sc = new Scanner(System.in);
		System.out.println("소수를 구할 범위(두 정수)를 입력하시오");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int tmp=0;
		int count=0;
		long startTime= System.currentTimeMillis();

outer: for(int i=a; i<=b; i++){//범위전체를 출력
			tmp=0;//반복을 시작할때마다 0으로 초기화
			for(int j=1; j<=i; j++){//소수출력
				if(i%j==0){
					tmp++;
				}
			}//for
			if(tmp==2){
				System.out.println(i+"소수이다");
				count++;
			}
			else{
				System.out.println(i+"소수가 아니다");
			}
		}//for outer
	System.out.println("총 소수의 개수는="+count);
	long endTime= System.currentTimeMillis();
	System.out.println((endTime-startTime)+"ms소요");*/

		
		
//간략하게_소수구하기
		Scanner sc = new Scanner(System.in);
		System.out.println("소수를 구할 범위(두 정수)를 입력하시오");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int tmp=0;
		int count=0;
		long startTime= System.currentTimeMillis();
		
		if(a<=2 && b>=2){
			System.out.println("2는 소수입니다");
		}
		if(a<=3 && b>=3){
			System.out.println("3은 소수입니다");
		}
		int modifiedNumber=5;
		if(a>modifiedNumber){
			modifiedNumber=a;
		}
		for(int i = modifiedNumber; i<=b; i++){
			boolean primeNum = true;
			if((i%2==0)||(i%3==0)){
				primeNum=false; //소수가 아니면 false라고 판단하도록
			}
			else{
				for(int j=6;j<=Math.sqrt(i)+1;j=j+6){
					if(i%(j-1)==0|| i%(j+1)==0){
						primeNum=false;
						break;
					}//if
				}//for
			}//else
		if(primeNum==true){
			System.out.println(i+"소수이다");
			}
		}
		System.out.println("총 소수의 수는="+count);
		long endTime= System.currentTimeMillis();
	System.out.println((endTime-startTime)+"ms소요");
	
	
//내가 짠 코드
/*	Scanner sc = new Scanner(System.in);
	System.out.println("소수를 구할 범위(두 정수)를 입력하시오");
	int a = sc.nextInt();
	int b = sc.nextInt();

	for (int i = a; i < b; i++) {
		int count = 0;
		for (int j = 1; j <= i; j++) {
			if (i % j == 0) //%==0일때
				count += 1;
		}
		if (count == 2)
			System.out.println(i +"는 약수이다");
	}*/
	}
}
