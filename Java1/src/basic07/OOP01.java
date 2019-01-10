package basic07;

/*
		1. 객체지향 (p230) OOL, OOP 
		
		절차형언어: 순서대로 해야해야만 하지않으면 안되는 언어(C언어)
		객체지향언어: 객체란, 물건이라할 수 있는대 순서는 상관없이 그 객체자체가 중요한 객체위주의 언어 
			- 코드의 재사용성이 높다
			- 코드의 관리성이 높다				    
		
		<과정: 설계(정의)->제작(생성)->사용>	
		 	  
		  설계법: class=설계도.....> ex) class{ color door whell} 
		  생성: new Car()....> 클래스 그대로 heap메모리에 생성되고 저장되는것을 생성이라고 한다.
		 	        ....> 메모리에 color, door, wheel 등이 만들어진다. 클래스의 설계도에서 만들어진 이러한 결과물들을 객체=object(=인스턴스라고 한다)
		 	        ....> Car myCar=new Car()라고 작성하면 stack메모리에 myCar가 만들어지고 myCar가 객체가 저장된 heap메모리의 번지수를 알게되어 찾아갈 수 있게된다. 이를 객체참조변수라 한다
		 	        ....> Car myCar2=new Car()라고 하면, 또다른 번지수의 myCar와 객체들이 저장된다.
		 	 
		   사용: (1)객체.속성 (2)객체.속성=값 (3)객체.메소드
		 	   	
				myCar.color="black" 이라고 쓰면, heap메모리의 color객체안에 "black"이 들어간다						
		 	  	myCar.door=4; heap메모리안의 door객체안에 4를 저장
		 	  	myCar.run(); 달리기 실행
		 	  	Sysout(myCar.door); door의 개수가 출력된다. */


public class OOP01 {
	public static void main(String[] args) {
		//2. (제작, 생성)	
		Car myCar=new Car();
		
		//3. (사용)
		myCar.color="black"; //객체.속성=값을 통해 저장
		myCar.door=4;
		
			
	}
}

//1. 객체 활용(설계, 정의)
//- 사용자 정의 클래스와 main클래스를 제외하면 내장클래스가 있다. ex) System
//- 자바에 없는 새로운 것을 정의하는 아래와 같은 클래스를 "사용자 정의 클래스".(user-defined class) 
class Car{ 
	String color;
	int door;
}