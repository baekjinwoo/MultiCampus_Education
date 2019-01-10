package basic07;

/* 생성자: 초기값 적용의 기능이 있고, 항상 아래의 flow가 적용된다.	
 - new가 객체를 생성한다. 하지만 Static변수를 쓰게되면 객체가 아니고 클래스가 생성된다. 
 - 객체.메소드가 아니고 클래스.static매소드가 된다.
 - 생성자가 가동되고, 초기치가 적용
 - 소멸자가 객체등을 정리 (GC가 네트워크는 제거불가능하니까, 개발자가 네트워크 강제종료)
 - 끝나면, 객체소멸 (Garbage Collector(쓰레기 전담반)은 객체(즉, 메모리)만 제거할 수 잇다   */

class BBang{
	int price;
	String menu;
	
	public int getPrice() { //주고
		return price;
	}
	
	public String getMenu() { //주고
		return menu;
	}
	
	public BBang(String menu,int price){ //생성자 (public(o), void(x), return(x))
		this.menu=menu;
		this.price=price;	
	}
	
	public BBang(){ //이클립스에서 내부적으로 만들어주는 디폴트 생성자 
					//생성자 오버로딩이다 (위와 비교했을때 이름은 같고 길이가 다르니까)
	  //this.menu=null;
	  //this.price=0;
		this(null,0); //위 두개를 축소한다면 이와같이 쓸 수 있다.(위의 생성자를 호출해서 null과 0을 넣는다)
	}
}

public class Constructor01 {
	public static void main(String[] args) {
		BBang b1=new BBang("피자빵",1500); //객체 생성& 생성자를 통한 초기치 적용
		BBang b2=new BBang(); //또 다른 객체생성, 생성자없어서 초기치는 별도로
		/*초기치없이 객체만 생성할 경우, 디폴트생성자를 만들어준다. 하지만 객체중에 초기치하나라도 적용된게 잇으면 
		나머지 객체들중에 초기치 적용이 안되면 개발자가 디폴트생성자를 만들어줘서 외부적으로 만들어야한다. */
		
		System.out.println(b1.getMenu()+" "+b1.getPrice());
		System.out.println(b2.getMenu()+" "+b2.getPrice()); //b2에 초기치가 없기때문에 String때는 null, int때 0 기본값이 들어간다.
		
		kaja("아자");
		kaja();
		 //아래 메소드의 길이와 메소드 오버로딩이다. kaja2(); kaja3(); 등으로 쓰면 가독성이 느려지니까 안쓴다.
		}
		
	public static void kaja(){ //메소드 1형식
		System.out.println("객체 굳-드");
	}
	public static void kaja(String aa){ //메소드 2형식
		System.out.println("오늘도"+aa);
	}
}