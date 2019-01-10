package OverloadEx; //함수중복 == 메서드 오버로딩

//Overload Method(중복함수) : 같은 이름의 함수를 여러번 구현
//1.반드시 메서드의 이름이 동일
//2.매개변수의 타입이 다르거나 갯수가 달라야함
//이유 : 메서드의 이름 절약
public class OverloadEx1 {
	int x = 10;
	int y = 20;

	public int max() {
		return (x > y) ? x : y;

	}
	
	
	public int max(int x, int y) {
		return (x > y) ? x : y;

	}

	public double max(double x, double y) {
		return (x > y) ? x : y;

	}

	public static void main(String[] args) { // 메서드명은 같고, 인자의 type이 다르다. 이를 "오버로딩"이라 한다
	OverloadEx1 ob=new OverloadEx1();
	System.out.println(ob.max());
	System.out.println(ob.max(50,20));
	System.out.println(ob.max(10.5,90.3));
	
	}
}
