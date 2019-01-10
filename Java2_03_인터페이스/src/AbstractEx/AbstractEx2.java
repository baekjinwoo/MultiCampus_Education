package AbstractEx;

abstract class Shape {

	abstract public void onDraw();

	abstract public void onErase();
}

// --------------------------------------------------------------------------------------------------------
class Rectangle extends Shape {

	@Override
	public void onDraw() {
		System.out.println("사각형을 그린다.");
	}
	@Override
	public void onErase() {
		System.out.println("사각형을 지운다.");
	}
}
// --------------------------------------------------------------------------------------------------------
class Circle extends Shape {
	@Override
	public void onDraw() {
		System.out.println("원을 그린다.");
	}
	@Override
	public void onErase() {
		System.out.println("원을 지운다.");
	}
}
public class AbstractEx2 {
	public static void main(String[] args) {
		Shape ob = new Rectangle();
		ob.onDraw();
		ob.onErase();
		
		ob = new Circle();
		ob.onDraw();
		ob.onErase();

/*		Shape ob1 = new Rectangle();
		Shape ob2 = new Rectangle();
		ob1.onDraw();
		ob1.onErase();
		ob2.onDraw();
		ob2.onErase();
*/
				
	}
}
