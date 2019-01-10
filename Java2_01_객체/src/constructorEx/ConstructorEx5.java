package constructorEx;

import java.util.Scanner;

/*
[문제] 생성자에서 두수를 입력받아 큰수와 작은수를 출력하시오
show()메서드에서 maxValue(), minValue()를 호출할것

클래스명 : Max
-a:int
-b:int
+Max()
+maxValue():int
+minValue():int
+show():void

[출력]
Input a: 5
Input b: 3

큰수 : 5
작은수: 3
 */

class Max {
	private int a;
	private int b;
//	int temp1;
//	int temp2;

	public Max(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int maxValue() {
		return (a>b)?a:b;
	}

	public int minValue() {
		return (a>b)?b:a;
	}

	public void show() {
		System.out.println("큰수는 "+maxValue());
		System.out.println("작은수는 "+minValue());
	}

}

public class ConstructorEx5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수를 입력하시오: ");
		int in1=sc.nextInt();
		System.out.print("두번째 수를 입력하시오: ");
		int in2=sc.nextInt();
		Max m= new Max(in1,in2);
				
		m.show();

		// Max m=new Max();
	}
}








