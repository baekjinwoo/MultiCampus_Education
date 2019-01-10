package Shape;

public class Rectangle extends Shape {

	public Rectangle() {
		super();
	}

	public Rectangle(int data1, int data2) {
		super(data1, data2);
	}
	
	@Override
	public double getSize() { //사각형의 넓이
		return (double)(super.getData1()*super.getData2());
	}
}
