package basic07;

/*1. 상속 ingeritance
	- 100% 상속받아야만 한다 (선택권x)
	- 자녀의 재산은 부모보다 같거나 많다.
	- 재사용이 좋아서 사용한다
	
	- 부모클래스 parent class (= 기본클래스 base class)
	- 자녀클래스 child class (= 파생클래스 derived class)  */	

class Animal{
	String alive;
	public void move(){
		System.out.println("나 잘 움직여!!!");
	}
	
}
class Bird extends Animal{ //상속
	public void sing(){
		System.out.println("나는 노래도 잘하지");
	}
}

public class Ingeritance01 {
	public static void main(String[] args) {
	Animal a1=new Animal();
	Bird b1=new Bird();
	a1.move();
	b1.sing();
	b1.move(); //객체.메소드
	b1.alive="잘~"; //객체.속성=값
	//결론적으로 상속은 feild와 method가 다 적용가능하다.
	}
}





















