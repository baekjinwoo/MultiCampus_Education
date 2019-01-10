package homework;

	/*<출력결과> OOP문제
	사각형에 색을 아름답게 칠합니다.
	사각형을 10, 10에서 그립니다
	타원형에 색을 아름답게 칠합니다.
	타원형을 20, 20에서 그립니다
	원그리자
	선그리자
	사각형에 색을 아름답게 칠합니다.
	사각형을 10, 10에서 그립니다
	타원형에 색을 아름답게 칠합니다.
	타원형을 20, 20에서 그립니다
	원그리자
	선그리자
			
	inteface :ShapeTable (color메서드, draw메소드))
	abstract : Shape(추상 color, draw)
	생성자, this()사용
	Circle , Rectangle , Ellipse 클래스들을 사용한다
	Shape배열도 사용한다  */

interface ShapeTable{
	void color();
	void draw();
}

abstract class Shape implements ShapeTable {
	protected int x=0; //10
	protected int y=0; //10
	
	public abstract void color( );
	public abstract void draw();
		
	public Shape(){
		this.x+=10;
		this.y+=10;
	}
}

class Rectangle extends Shape implements ShapeTable{
	@Override
	public void color() { System.out.println("사각형에 색을 아름답게 칠합니다");	}

	@Override
	public void draw() { System.out.printf("사각형은 %d,%d에서 그립니다\n",this.x,this.y);
	}	
}

class Ellipse extends Shape implements ShapeTable{
	@Override
	public void color() { System.out.println("타원형에 색을 아릅답게 칠합니다");}

	@Override
	public void draw() {System.out.printf("타원형은 %d,%d에서 그립니다\n",this.x+10,this.y+10);	}
}


class Circle extends Shape implements ShapeTable{
	@Override
	public void color() {	}
	
	@Override
	public void draw() { System.out.println("원그리자");
						System.out.println("선그리자");}
}

public class hm25 {
	public static void main(String[] args) {
		Shape[] s=new Shape[3];
		s[0]=new Rectangle();
		s[1]=new Ellipse();
		s[2]=new Circle();

		s[0].color();
		s[0].draw();
		s[1].color();
		s[1].draw();
		
		s[2].draw();
		
		s[0].color();
		s[0].draw();
		s[1].color();
		s[1].draw();
		
		s[2].draw();
	}
}

/* 또 다른 풀이법 1
 * interface ShapeTable {
  	public void color();
  	public void draw();
	}

	abstract class Shape {
 	protected int x = 0;//10
 	protected int y = 0;//10
 	Shape(){ 
  	this(0, 0);  // this.x = 0;  //this.y = 0;
 	}
 	
 	Shape(int x, int y){ //10,10
  		this.x = x;
  		this.y = y;
 	}
 	public abstract void color();
 	public abstract void draw();
	}

	class Circle extends Shape implements ShapeTable{
 	public void color(){System.out.println("원그리자");}
 	public void draw(){System.out.println("선그리자");}
	}

	class Rectangle extends Shape implements ShapeTable{
 	Rectangle(int x, int y){ super(x,y);} //10,10
 
 	public void draw(){ System.out.println("사각형을 " + this.x +", " + this.y+"에서 그립니다");}
 	public void color(){ System.out.println("사각형에 색을 아름답게 칠합니다.");}
	}

	class Ellipse extends Shape implements ShapeTable{
 	Ellipse(int x, int y){ super(x,y);}
 	public void draw(){ System.out.println("타원형을 " + this.x +", " + this.y+"에서 그립니다"); }
 	public void color(){ System.out.println("타원형에 색을 아름답게 칠합니다."); }
	}

public class hm25 {
 	public static void main(String[] args) {
     
   Shape[] s=new Shape[3];
   s[0] = new Rectangle(10,10);
   s[1] = new Ellipse(20,20);
   s[2] = new Circle();
   //s[0].color();//r.color();
   
   for(int i=0;i<s.length;i++){
	   s[i].color();
	   s[i].draw(); 
	      }
   		}
	}									*/







/* 또 다른 풀이법 2
interface ShapeTable{
	void color();
	void draw();
}

abstract class Shape{
	protected int x = 0; //10
	protected int y = 0; //10
	Shape(){
		System.out.println("도형그리기 시작");
	}
	Shape(int x, int y){
		this();
		this.x = x;
		this.y = y;
	}
	abstract void color(int x,int y);
	abstract void draw(int x,int y);
}
//생성자, this()사용

//Circle , Rectangle, Ellipse클래스 사용
class Circle extends Shape implements ShapeTable{
	Circle(int x,int y){
		super(x,y);
		draw(x,y);
		color(x,y);
		draw();
		color();
	}
	
	public void color() {
		System.out.println("원형에 색을 아름답게 칠합니다");
	}
	public void draw() {
		System.out.println("원그리자");
	}
	
	void color(int x, int y) {
		System.out.println("원형에 "+x+", "+y+"에서 칠합니다");
	}
	void draw(int x, int y) {
		System.out.println("원형에 "+x+", "+y+"에서 그립니다");
	}
	
}

class Rectangle extends Shape implements ShapeTable{
	Rectangle(int x,int y){
		super(x,y);
		draw(x,y);
		color(x,y);
		draw();
		color();
	}
	public void color() {
		System.out.println("사각형에 색을 아름답게 칠합니다");
	}
	public void draw() {
		System.out.println("선그리자");
	}
	void color(int x, int y) {
		System.out.println("사각형에 "+x+", "+y+"에서 칠합니다");
	}
	void draw(int x, int y) {
		System.out.println("사각형에 "+x+", "+y+"에서 그립니다");
	}
}

class Ellipse extends Shape implements ShapeTable{
	Ellipse(int x,int y){
		super(x,y);
		draw(x,y);
		color(x,y);
		draw();
		color();
	}
	public void color() {
		System.out.println("타원형에 색을 아름답게 칠합니다");
	}
	public void draw() {
		System.out.println("타원그리자");
	}
	void color(int x, int y) {
		System.out.println("타원형에 "+x+", "+y+"에서 칠합니다");
	}
	void draw(int x, int y) {
		System.out.println("타원형에 "+x+", "+y+"에서 그립니다");
	}
}

public class hm25 {
	public static void main(String[] args) {
		Shape[] shapeAry = new Shape[3];
		shapeAry[0] = new Circle(30,30);
		System.out.println();
		shapeAry[1] = new Rectangle(10, 10);
		System.out.println();
		shapeAry[2] = new Ellipse(20, 20);
	}//main
}



/* 또 다른 풀이법 3
interface ShapeTable{
	void color();
	void draw(int x, int y);
}

abstract class Shape{
	protected int x = 0;
	protected int y = 0;

	public void Shape(){
		System.out.println("선 그리자");
	}
	
	public abstract void color();
	public abstract void draw(int x, int y);
}


class Elipse extends Shape implements ShapeTable{
	@Override
	public void draw(int x, int y)	{
		this.x = x;
		this.y = y;
		System.out.printf("타원형을 %d, %d에서 그립니다\n", this.x, this.y);
	}
	
	public void color() {
		// TODO Auto-generated method stub
		System.out.println("타원형에 색을 아름답게 칠합니다.");
	}
}

class Rectangle extends Shape implements ShapeTable{
	public void draw(int x, int y)	{
		this.x = x;
		this.y = y;
		System.out.printf("사각형을 %d, %d에서 그립니다\n", this.x, this.y);
	}
	
	@Override
	public void color() {
		// TODO Auto-generated method stub
		System.out.println("사각형에 색을 아름답게 칠합니다.");
	}
}


class Circle extends Shape implements ShapeTable{
	public void draw(int x, int y)	{
		System.out.println("원 그리자");

	}
	@Override
	public void color() {
		
	}
}



public class hm25 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] sp = new Shape[3];
		
		sp[0] = new Rectangle();
		sp[0].color();
		sp[0].draw(10, 10);
		
		sp[1] = new Elipse();
		sp[1].color();
		sp[1].draw(20, 20);
		sp[1].Shape();
		
		sp[2] = new Circle();
		sp[2].draw(0, 0);
		
	}
}*/
