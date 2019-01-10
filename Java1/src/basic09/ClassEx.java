package basic09;

/*(p.368)의 예제문제를 풀 때, 설계도를 그리면서 해석하고 풀 것.
		// tv의 new ->생성자 -> super() ->부모클래스 -> Buy클래스
		// computer의 new ->생성자 ->super() ->부모클래스 ->Buy클래스 */
//클래스 ==> 설계도
class Product{
	int price;
	int bonuspoint;
		
	Product(int price){
		this.price=price;
		bonuspoint=(int)(price/10.0);
	}
}

class Tv extends Product{
	Tv(){
		super(100);
	}
	public String toString(){return "Computer";}
}

class Computer extends Product{
	Computer(){
		super(200);
	}
	public String toString(){return"Tv";} //object메소드의 toString()오버라이딩(업그레이드)해서 썻다(이름같고, 매개변수없고)
}

			
				class Buyer{
			int money=1000;
			int bonusPoint=0;
			void buy(Product p){
				if(money<p.price){
					System.out.println("잔액이 부족합니다");
					return;
				}
			money-=p.price;
			bonusPoint+=p.bonuspoint;
			System.out.println(p+"를 구입하셧습니다"); 
			// 객체.toString()에서 toString은 object클래스의 메소드로서 생략된다 (p.450)
			}
		}	
		//Object클래스의 메소드 toString(): Public String toString()로 쓸수있다 (p.450) 

public class ClassEx {
	public static void main(String[] args) {
		Buyer b=new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
				
		System.out.println("현재남은 돈은"+b.money+"만원입니다");
		System.out.println("현재 보너스점수는"+b.bonusPoint+"점입니다.");
	}
}
