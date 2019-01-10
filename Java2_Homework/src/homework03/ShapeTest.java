package homework03;

abstract class Shape{
	private int width;
	private int height;
	private String color;
	public Shape() {
		super();
	}
	public Shape(int width, int height, String color) {
		super();
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public double getArea(){
		return width*height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}

interface Resize{
	public void Resize(int size);
}

class Triangle extends Shape implements Resize{

	public Triangle() {
		super();
	}

	public Triangle(int width, int height, String color) {
		super(width, height, color);
	}
	public double getArea(){
		return (super.getWidth()*super.getHeight())/2;
	}

	@Override
	public void Resize(int size) {
		super.setHeight(getHeight()+size);
	}
}

class Rectangle extends Shape implements Resize{

	public Rectangle() {
		super();
	}

	public Rectangle(int width, int height, String color) {
		super(width, height, color);
	}
	public double getArea(){
		return super.getWidth()*super.getHeight();
	}

	@Override
	public void Resize(int size) {
		super.setWidth(getWidth()+size);
	}
}

public class ShapeTest {
	public static void main(String[] args) {
		Shape shape[] = new Shape[6];
		
		shape[0] = new Triangle(7,5,"Blue");
		shape[1] = new Rectangle(4,6,"Blue");
		shape[2] = new Triangle(6,7,"Red");
		shape[3] = new Rectangle(8,3,"Red");
		shape[4] = new Triangle(9,8,"White");
		shape[5] = new Rectangle(5,7,"White");
		
		System.out.println("기본정보");
		for(Shape m : shape){
			String name = m.getClass().toString();
			//System.out.println(m.getClass().getSimpleName() + "\t" + m.getArea() + "\t" + m.getColor());
			System.out.println(name.substring(17)+ "\t" + m.getArea() + "\t" + m.getColor());
		}
		for(Shape m : shape){
			if(m instanceof Triangle){
				((Triangle) m).Resize(5);
			}
			else if(m instanceof Rectangle){
				((Rectangle) m).Resize(5);
			}
		}
		
		System.out.println("사이즈를 변경 후 정보");
		for(Shape m : shape){
			String name = m.getClass().toString();
			System.out.println(name.substring(17) + "\t" + m.getArea() + "\t" + m.getColor());
		}
	}
	
}
