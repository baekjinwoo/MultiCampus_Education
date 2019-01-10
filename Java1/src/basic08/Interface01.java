package basic08;

/*1. 인터페이스는 추상클래스와의 사촌관계이다. 선언은 할 수 있는대 구현을 할 수 없다.
		interface Animal{ void soom(); }

		//인터페이스+인터페이스 이름			 
		//메소드에 선언만있고, 구현(중괄호)이없다. =>추상메소드와 같아서 구현은 자식클래스 메소드에 다 적는다

		class Moolkoki{}
		
		class Shark extends Moolkoki implements Animal{
			public void soom(){ //필수로 soom을 구현시켜줘야한다
				System.out.println("숨쉬자");
			}
		}
		//class Shark extends Animal,Moolkoki{}
		//다중 상속X인 이유는 Diamond Problem때문이다. 이를 대처하기 위해 인터페이스를 쓴다.*/	


//2. 인터페이스 연습하기
interface Ant{
	void il();
	void go();
	public void run();
}
interface Black {
	void color();
}

interface White extends Black{	
}

class spider{
}

class Interface01 extends spider implements Ant,White{ 
//Black는 상속되어있다. 또한 인터페이스는 extends하나 안하나 연결되어있다
	public void il(){
		System.out.println("일한다");
	}
	public void go(){
				
	}
	public void run(){
				
	}
	public void color(){
		System.out.println("빨간맛~~");
	}
}								
