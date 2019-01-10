package test1;

public class DeprecatedTest {
	
	@Deprecated //앞으로 사용하지 말아야 할 메서드이다 //실행하는데 문제는 없다  //안드로이드에서 사용
	public void print(){
		System.out.println("print");
	}
	public void show(){
		System.out.println("show");
	}
	
	public static void main(String[] args) {
		DeprecatedTest ob = new DeprecatedTest();
		ob.print();
		ob.show();
		
		
		
		
		
		
		
	}
}
