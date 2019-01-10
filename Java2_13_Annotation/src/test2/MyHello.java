package test2;

public class MyHello {

	@MyAnnotation
	public void hello(){
		System.out.println("Hello");
	}

	public void hello2(){ //어노테이션 선언되지 않음
		System.out.println("Hello2");
	}
}
