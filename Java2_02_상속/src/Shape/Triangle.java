package Shape;

public class Triangle extends Shape {
	
	public Triangle() {
		super();
	}

	public Triangle(int data1, int data2) {
		super(data1, data2);
	}

	@Override
	public double getSize(){
		return (double)(super.getData1() * super.getData2())/2;
	}
}
