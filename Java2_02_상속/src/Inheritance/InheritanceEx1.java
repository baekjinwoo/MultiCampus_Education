package Inheritance;

class SuperEx {
	public void show() {
		System.out.println("super show method");
	}
}

class SubEx extends SuperEx { // 자식
	public void show() {
		super.show();
		System.out.println("sub show method");
	}
}

public class InheritanceEx1 {
	public static void main(String[] args) {
		SubEx ob = new SubEx();
		
		ob.show(); //메서드 명이 같을때, 내것이 있으면 내 것이 출력되고 내것이 없으면 부모것이 출력된다.
	}
}
//------------------------------------------------

/*class SuperEx {
	public void show1() {
		System.out.println("show1 method");
	}
}

class SubEx extends SuperEx { // 자식
	public void show2() {
		System.out.println("show2 method");
	}
}

public class InheritanceEx4 {
	public static void main(String[] args) {
		SubEx ob=new SubEx();
		
		ob.show1();
		ob.show2();
		
	}
}
*/