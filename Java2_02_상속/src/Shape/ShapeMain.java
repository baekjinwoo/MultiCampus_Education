package Shape;

public class ShapeMain {

	public static void main(String[] args) {
		Shape ob = new Rectangle(4,7);
		System.out.println("사각형의 넓이:"+ob.getSize()); //오버라이드에 의해 부모클래스에서 자식클래스의 메서드를 호출
		
		ob = new Triangle(4,7);
		System.out.println("삼각형의 넓이:"+ob.getSize());

		//--------------------------------------------
		
		Rectangle ob1 = new Rectangle(4,5);
		System.out.println("사각형의 넓이: "+ob1.getSize());
		
		Triangle ob2 = new Triangle(3,7);
		System.out.println("삼각형의 넓이: "+ ob2.getSize());
	}
}
