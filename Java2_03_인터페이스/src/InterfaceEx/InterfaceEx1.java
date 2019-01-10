package InterfaceEx;

//인터페이스-----------------------------------------------------------------------------------------------
interface Shape{
	/*final*/ int r=10; //인터페이스의 모든 변수는 final이기에 생략가능
	/*abstract*/ public void draw(); //인터페이스의 모든 메서드는 abstract이기에 생략가능
	/*abstract*/ public void erase();
	}
class Circle implements Shape{
	@Override
	public void draw(){ //인터페이스를 사용할때도 강제 재정의(강제 오버라이딩)
		System.out.println("반지름이 "+r+"인 원을 그린다.");	
	}
	@Override
	public void erase(){
		System.out.println("원을 지운다.");
	}
}


public class InterfaceEx1 {
	public static void main(String[] args) {
		Shape ob = new Circle();
		ob.draw();
		ob.erase();
	}
}

/*//추상클래스-----------------------------------------------------------------------------------------------
abstract class Shape{
	final int r=10;
	abstract public void draw();
	abstract public void erase();
	}
class Circle extends Shape{
	@Override
	public void draw(){ //추상클레스를 사용할때는 강제 재정의(강제 오버라이딩)
		System.out.println("반지름이 "+r+"인 원을 그린다.");	
	}
	@Override
	public void erase(){
		System.out.println("원을 지운다.");
	}
}


public class InterfaceEx1 {
	public static void main(String[] args) {
		Shape ob = new Circle();
		ob.draw();
		ob.erase();
	}
}
*/
/*//일반클래스-----------------------------------------------------------------------------------------------
class Shape{
	final int r=10;
	public void draw(){}
	public void erase(){}
	}
class Circle extends Shape{
	@Override
	public void draw(){
		System.out.println("반지름이 "+r+"인 원을 그린다.");	
	}
	@Override
	public void erase(){
		System.out.println("원을 지운다.");
	}
}

public class InterfaceEx1 {
	public static void main(String[] args) {
		Shape ob = new Circle();
		ob.draw();
		ob.erase();
	}
}*/
