package constructorEx;

import java.util.Scanner;

/*  클래스명 : ConstructorEx4
 *   x : int
 *   y : int
 *  
 *   +ConstructorEx4()             -- 입력받기
 *   +calc():int                   -- x * y 를 리턴
 *   +display():void	           -- 출력하기
 */

public class ConstructorEx4 {
	private int x;
	private int y;

	public ConstructorEx4(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public int calc() { 
		return x*y;
	}

	public void display() {
		System.out.println(calc());
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("첫번째 정수를 입력하시오: ");
		int in1=sc.nextInt();
		System.out.print("두번째 정수를 입력하시오: ");
		int in2=sc.nextInt();
		
		ConstructorEx4 ob = new ConstructorEx4(in1, in2);
		System.out.print("사각형의 넓이 X*Y: ");
		ob.display();
		

	
	}
}

/*
 * [문제] 사각형의 넓이
 * 
 * 가로를 입력 : 5 세로를 입력 : 4
 * 
 * 사각형의 넓이 : 20
 */
