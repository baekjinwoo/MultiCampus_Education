package methodex;

//Call by Value: 값을 전달하는 방식 
public class MethodEx3 {

	public static void show1(int a, char b, double c, float d) {
		System.out.println(a + " " + b + " " + c + " " + d);
	}

	public static int show2(int a, int b, int c) {
		int result = (a + b + c);
		return (a + b + c);
	}

	public static double show3(int a, int b, int c) {
		return (a + b + c) / 3.0; // 정수/정수= 정수, 정수/실수= 실수
		// return (double)(a+b+c)/3;
	}

	public static int show4(int a,int b,int c) {

		int result = (a + b + c);
		if (result >= 60) {
			System.out.print("\npass이다 ");
		} else
			System.out.print("\nfail이다 ");

		return (a + b + c);
	}

	public static void main(String[] args) {
		show1(10, 'A', 10.5, 100.3f);

		System.out.println("합계:" + show2(95, 85, 73));
		System.out.printf("평균: %.2f", show3(95, 85, 73)); // 소수점 2자리
		System.out.print("결과:" + show4(95, 85, 73)); // 평균이 60이상 "pass", 미만
														// "fail"

	}

}
