package Staticex;

class Test {
	int x;
	int y;
	static int z;

	static{
		System.out.println("static 초기화 영역"); //객체와 상관없이 맨 처음에 한 번만 호출한다. 
												//객체와 상관이 없고 두번을 만들든 세번을 만들든 한번만 호출된다.
	}
	
	Test(int x, int y, int z1) {
		this.x = x;
		this.y = y;
		z = z1;
	System.out.println("객체의 초기화 영역"); //객체 ob1만들때 한번 실행하고, 객체 ob2만들때 또 한번 실행한다. 두 번 실행.
	}

	public void view() {
		System.out.println(x + " " + y + " " + z);
	}
}

public class StaticEx1 {

	public static void main(String[] args) {
		Test ob1 = new Test(2, 5, 7); 
		Test ob2 = new Test(3, 6, 3);
		ob1.view();
		ob2.view();

	}

}
