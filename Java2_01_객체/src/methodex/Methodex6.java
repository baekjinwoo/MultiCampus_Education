package methodex;

public class Methodex6 {
	public static void view1() {
		System.out.println("static method");
	}

	public static void view2() {
		System.out.println("non-static method");
	}

	
	
	public static void main(String[] args) {
		view1();
		view2();

		// 클래스메서드(static method): 객체없이도 호출이 가능
		Methodex6.view1(); // 또는 view1();
		Methodex6.view2();

		
		//인스턴스메서드(instance method): 반드시 객체를 생성한 후에 호출해야 함
		Methodex6 ob2=new Methodex6();
		ob2.view2();
	}
}
