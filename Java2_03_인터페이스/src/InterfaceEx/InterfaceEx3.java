package InterfaceEx;

/* class와 interface를 이용하여 성적처리
 * 클래스명 : User
 *  -name:String
 *  +User()
 *  +User(name:String)
 *  +toString():String
 *  
 *  인터페이스명 : Score
 *  +sol:int         (초기값:20)
 *  +getScore():int
 *  
 *  인터페이스명 : Print
 *  +toPaint():String
 *  
 *  [출력화면]
 *  이름 : 홍길동
 *  점수 : 60점
 */

interface Score{
	public int sol = 20; //final 생략
	public int getScore(); //abstract 생략
}

interface Print{
	public String toPaint();
}

class User{
	private String name;
	public User(){
		
	}
	public User(String name){
		this.name=name;
	}
	public String toString(){
		return "이름: "+ this.name;
	}
}

public class InterfaceEx3 extends User implements Score, Print { // User, Score, Print상속받기
	int s;
	public InterfaceEx3(String name, int s){
		super(name);
		this.s=s;
	}
	
	@Override
	public int getScore(){
		return sol*s;		
	}
	@Override
	public String toPaint(){
		return super.toString() + "\n 점수: "+ this.getScore();
	}
	

	
	public static void main(String[] args) {
		InterfaceEx3 ob = new InterfaceEx3("홍길동",3);
		System.out.println(ob.toPaint());
		//홍길동, 60점이 출력
	}
}
