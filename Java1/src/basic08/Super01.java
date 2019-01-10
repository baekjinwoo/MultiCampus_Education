package basic08;

//super() 조상클래스의 생성자
class Parent{
	int page; //필드
	public void jangsoo(){ //메소드
		System.out.println("우리가족은 장수가족");
	}
	public Parent(){
		System.out.println("부모나이 출력이 없네"); //생성자. 
	}
	public Parent(int page){
		//생성자 (위의 메소드와 생성자는 오버로딩관계) 자녀 객체생성시 상속관계에 
		//의해 부모부터 실행하는데 부모나이가 없으니 위에 생성자를 실행한다
		this.page=page; //this.
		System.out.println("부모나이"+this.page);
	}
}

class Child extends Parent{ //상속관계
	int cage;
	public Child(int cage){ //생성자
		super(60);
		//자식클래스의 생성자에서 super이란 조상클래스를 작성하는대(부모쪽에 넣고자 하는 인자가 없으면 생략하면된다), 인자가 있다면 있는 생성자로 찾아가서 실행한다
		
		this.cage=cage;
		System.out.println("자녀나이: "+this.cage);
		super.jangsoo(); 
		
		//객체.메소드로 부모의 메소드를 호출할 수 있는 상속생성자
		//따라서 super생성자는 (1)super(); (2)super.부모메소드;로써 사용한다
	}
}	
public class Super01 { //처음 클래스명을 super라고 줫을뿐이지 super생성자라는 별개.
	public static void main(String[] args) {
		Child c1=new Child(30); 
		//new->상속에서의 생성자를 호출하게되면 부모쪽에서 실행한 다음에 자녀쪽에서 실행한다.
		//따라서, 자녀를 찍든 부모를 찍든 무조건 부모부터 실행하게된다. 
	}
}
