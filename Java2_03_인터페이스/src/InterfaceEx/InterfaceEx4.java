package InterfaceEx;


// class에서 interface를 상속받을때 키워드는 implements
// interface에서 interface를 상속받을때 키워드는 extends

interface InterA{
	
}

interface InterB{
	
}

interface InterC extends InterA, InterB{ // implements로 인터페이스  여러개를 상속받을 수 없다.
										 // extends로 인터페이스 여러개를 상속O 
}

public class InterfaceEx4 {
	public static void main(String[] args) {
		
		
		
	}
}
