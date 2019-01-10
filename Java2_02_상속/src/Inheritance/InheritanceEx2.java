package Inheritance;

class ParentEx /*extends Object*/{ 
	public ParentEx(){
		super(); //ParentEx에 super가 있는 이유는 생략가능한 extends Object가 있기 때문이다.
		System.out.println("parent class");
	}
}

class ChildEx extends ParentEx{
	public ChildEx(){
		super(); //생략가능
		System.out.println("child class");
	}
}

public class InheritanceEx2 {

	public static void main(String[] args) {
		ChildEx ob=new ChildEx();
		
	}

}
