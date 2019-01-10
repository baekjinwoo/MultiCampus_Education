package basic08;

//1. 상속	
class Parent1{}
class Child2 extends Parent1{}

//2. 다형성 (오버라이딩 : 다양한 기능) 
public class Polymorphism01 {
	public static void main(String[] args) {
	//3. 객체의 형변환
	Parent1 p1=new Parent1();
	Child2 c1=new Child2();
			
	//Parent1 p2=c1;
	Parent1 p2=new Child2();
			
	//Child c2=p1;
	//Child c2=new Parent1(); 
	//성립할 수 없는 객체의 형변환으로써, 
	//자식클래스가 가지고있는 인스턴스가 부모클래스의 인스턴스로는 부족하기 떄문에 X 
	//(다시말해서, 부모와 자식간의 재산으로 해석하면 된다) 따라서 부모클래스만 앞에 쓰인다.
			
	Parent1 p3=c1;
	Child2 c3=(Child2)p3; //컴파일에러x 실행에러x (new Child();)
	Child2 c4=(Child2)p1; //컴파일에러x 실행에러o (new Parent1();)
						//이와같이 추적을 통해서 에러를 찾아야 한다.
	}
}  										
