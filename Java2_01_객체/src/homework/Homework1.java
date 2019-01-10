package homework;

/*[문제1] main()함수에서 각각 호출하고 계산된 결과를 return 받아서 
        main()에서 출력하시오
파일명:Test1.java
호출함수 : sum(3,5):int   sub(7,2):int   mul(4,5):int   div(7,3):double

더하기 : 8
빼  기 : 5
곱하기 : 20
나누기 : 2.33
------------------------------------------------------------------
*/

public class Homework1 {
	
	public int sum(int a, int b) {

		return a + b;
	}

	public int sub(int a, int b) {

		return a - b;
	}

	public int mul(int a, int b) {

		return a * b;
	}

	public int div(int a, int b) {

		return a / b;
	}

	public static void main(String[] args) {
		Homework1 h = new Homework1();
		System.out.println(h.sum(3, 5));
		System.out.println(h.sub(7, 2));
		System.out.println(h.mul(4, 5));
		System.out.println(h.div(7, 3));
	
	}
}
