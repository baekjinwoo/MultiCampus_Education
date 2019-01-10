package basic07;

// getter&setter메소드를 자동생성: source -> generate getter and setter ..
// 전체주석은 범위선택후 source-> add block comment
/* 1. 접근제어자 
   2. 캡슐화: 정보은닉(외부에서 직접 접근을 못하도록, 겉으로는 보이지 않도록) */

//같은 패키지안에서 이름이 같은 클래스가 중복정의되면 안된다. 따라서 BBang가 아니라 BBang2를 썻다.
class BBang2{ //설계
	private String menu; 
			//빵종류는 문자, private는 존재하는 클래스 내부에서만 접근가능 //field메뉴=인스턴스변수
	private int price;
	
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	//public String getMenu(){ // 캡슐화에서의 도우미는 무조건 (설계도안에서) public으로 설계해야한다.
	// return menu; // 도우미는 행동이니까 속성x 메소드로 생성하기위해 void를 붙인다. 
	// 이때, 외부로 주는 메소드는 get, 외부로 받는 메소드는 set으로 4개의 도우미가 생긴다(get/set+첫대문자명)
	// return을 작성해서 반환을 해줄 수 있는대, 이때 void가 아닌 기본자료형이나 String을 쓴다.
	//}		
	//public void setMenu(String menu){ //임시변수, stack메모리에 저장되는 변수
	//	this.menu=menu; //this는 자기자신을 참조하는 객체(=헌재 열려있는 클래스 BBang의 menu)
	//}
	//public int getPrice(){
	//	return price;
	//}
	//public void setPrice(int price){
	//	this.price=price;
	//}
}

public class Encapsulation01 {

	public static void main(String[] args) {
	BBang2 b1=new BBang2(); //객체 생성 // b1은 클래스에 대한 인스턴스,객체라고한다.(p.246)
		
	//b1.menu="소보로빵"; //맨 위 클래스의 도우미는 메소드이기에 속성하고 사용할 수 없다.
	//b1.price=1000;
	
	//System.out.print(b1.menu+"은/는 "+b1.price);
		
	b1.setMenu("소보로빵"); //객체사용 //객체.메소드();
	b1.setPrice(1000);
	
	System.out.print(b1.getMenu()+"은  "+b1.getPrice());
	
	}
}