package basic08;

import java.util.Scanner;

class Boomo{
	public void car(){
		System.out.println("부모차타고 드라이브한다");
	}
}
class Jasik extends Boomo{
	public void car(){ //재정의(오버라이딩): 이름이 같고 부모의 내용에서 업그레이드가 되었기 때문에
	//public void car2(){
		System.out.println("자녀차타고 여행가자");
	}
}

public class Overriding {
	public static void main(String[] args) {
	// ==> 다형성 : 하나의 메소드가 다양한 방식으로 동작이 가능한 것으로, overrode, overriding이 있다.
	//1.오버로딩(overloading)					오버라이딩(overriding)
	//(메소드&필드)중복, 가독성을 높이기 위해				재정의 
	//이름이 같고 매개변수 개수, 반환타입이 다르다		이름이 같고 매개변수 개수,반환타입도 같다
	// (printf메서드가 그 예이다)				(기존에 있던 내용에서 부모보다 자녀가 업그레이드 되야함=>새로운 것으로 만드는 것)


	//#항상 오버라이딩은 상속이라는 전제하에 가능하다.		
	//오버라이딩은 버전을 업그레이드를 하는 개발과정에서 사용한다. 위에는 1.0 아래는 2.0
			
		Boomo b1=new Boomo();
		Jasik j1=new Jasik();
		b1.car();
		j1.car();
		//j1.car2();
		
		Boomo b2=new Jasik();
		b2.car();
//부모가 원래였으면 자식의 소유중에 부모차를 타야되는대 오버라이딩을 통해서 자식의 것도 접근이 가능. 따라서, 부모가 자식차 타고 간다.

		/*2.  1:드라이브 2:여행	(오버라이딩)(방법1)
			Scanner sc=new Scanner(System.in);
			int ii=sc.nextInt();
			
			if(ii==1){
				Boomo b3=new Boomo();
				b3.car();}
			if(ii==2){
				Boomo b3=new Jasik();
				b3.car();	}*/  
			
		//3. 1:드라이브 2.여행 (오버라이딩) (방법2) 
			Scanner sc=new Scanner(System.in);
			System.out.print("1:드라이브  2:여행");
			int aa=sc.nextInt();
			Boomo b3=null;
			switch(aa){
			case 1:
				b3=new Boomo();
				break;
			case 2:
				b3=new Jasik();
				break;
			}
			b3.car();	 					

	}
}
