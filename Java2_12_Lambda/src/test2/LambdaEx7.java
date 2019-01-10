package test2;

/*@FunctionalInterface
interface Function{
	public int calc(int a,int b);
	default void view1(){ //default를 써서 추상메소드가 아닌 일반메소드를 정의할 수 있다.
		System.out.println("view1 method");
	}
	
	default void view2(){ 
		System.out.println("view2 method");
	}
}

public class LambdaEx7{
	public static void main(String[] args) {
		Function m1 = (a,b) -> a+b;
		Function m2 = (a,b) -> a-b;
		
		int m3 = m1.calc(10, 20) + m2.calc(30, 40);
		System.out.println();
		
		
		m1.view1();
		m1.view2();
		
	}
}
*/


@FunctionalInterface
interface Function{
	public int calc(int a,int b);
	
	default int view1(int a, int b){  //interface안에서 일반메서드를 직접 return받아서 호출할 수 는 있지만 람다의 의미는 아니기때문에 이렇게 사용하지는 않도록 하자.
		return a + b;
	}
}

public class LambdaEx7{
	public static void main(String[] args) {
		Function m1 = (a,b) -> a+b;
		System.out.println(m1.view1(2, 10));
		
	}
}
