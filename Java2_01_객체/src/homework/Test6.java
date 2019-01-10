/*[문제6]함수 overloading을 이용하여 다음을 완성하시오
(1)클래스명:Test6
    ① 필드명 : PI:double     (초기값:3.141593, final로 선언)
    ② 메소드 : 
           area(a:int):double       => 원의넓이=반지름*반지름*PI
           area(a:int, b:int):double     => 사각형의넓이=가로*세로
           area(a:int, b:int, c:int):doble     => 사다리꼴의 넓이=(밑변 + 윗변 )*높이/2 
(2)조건
     1)main()함수에서 
       public static void  main(String[] args){
             Test6 ob=new Test6();
             //나머지 완성하시오
       }
     2)각각의 area(3),area(4,5),area(3,4,7) 메서드를 호출하여 
        결과값을 구한다

[결과화면]
원의넓이 : 28.274337
사각형의넓이 : 20.0
사다리꼴의넓이 : 24.5*/

package homework;

public class Test6 {

	final double PI = 3.141593;
	
	public double Oarea(int a) {
		return a * a * PI;
	}

	public double Darea(int a, int b) {
		return a * b;
	}

	public double Zarea(int a, int b, int c) {
		return ((a + b) * c) / 2.0;
	}

	public static void main(String[] args) {
		Test6 ob = new Test6();
	
		System.out.println("원의 넓이:"+ob.Oarea(3));
		System.out.println("사각형의 넓이:"+ob.Darea(4, 5));
		System.out.println("사다리꼴의 넓이:"+ob.Zarea(3, 4, 7));
		
		
		
	}
}
