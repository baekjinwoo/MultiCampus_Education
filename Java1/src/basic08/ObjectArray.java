package basic08;


//추상클래스(Abstract)는 가독성과 다형성의 장점이 있다.
//추상클래스는 공통된 것을 묶어주는 역할이라고 해석되는 것 같고
//인터페이스는 다중상속의 역할이라고 해석할 수 있다
abstract class Fruit{
	public void mat(){ //메소드
	System.out.print("맛잇겟다");
	}
	public abstract void eat(); 
	//추상메소드이고, 추상메소드가 있으면 클래스도 추상클래스여야한다.
}

class Apple extends Fruit{
	public void eat(){
		System.out.println("사과는 맛잇어");	
	}
}

class Bae extends Fruit{
	public void eat(){
		System.out.println("배는 맛없어");
	}
}

class Gam extends Fruit{
	public void eat(){
		System.out.println("감은 무슨맛이지");
	}
}

/////////////////////////////////////////////////////////////////////////

//객체를 배열로 넣은 것		
public class ObjectArray {
	public static void main(String[] args) {
		Fruit f[]=new Fruit[3]; 
		f[0]=new Apple();
		f[1]=new Bae();
		f[2]=new Gam();
				
		f[0].eat();
		f[1].eat();
		f[2].eat();
								
		for(int i=0;i<3;i++){
			f[i].eat();
			f[i].mat(); //객체.메소드
		}
	}
}
				
//		/* 앞전의 오버라이딩코드이다
//		if(ii==1){
//			Boomo b3=new Boomo();
//			b3.car();}
//		if(ii==2){
//			Boomo b3=new Jasik();
//			b3.car(); 	}  			
	

//	/*Fruit f1=new Apple();
//	 Fruit f2=new Bae();
//	 Fruit f3=new Gam();
						 
//	 f1.eat();
//	 f2.eat();
//	 f3.eat();   

//	현재 오버라이딩코드의 객체선언과 기본상속코드 객체선언에서 차이점은
//	 오버라이딩코드에서는 if라는 조건문을 통해서 ii가 1일때 b3을 만들고 ii가2일때 다시 만드는 개념
//	 기본상속코드는 그러한 조건이 없으니까 한 객체를 선언하고 생성하는대에 중복될 수 없다. 
