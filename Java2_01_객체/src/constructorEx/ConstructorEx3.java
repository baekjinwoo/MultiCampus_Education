package constructorEx;
//클래스명 : UserInfo

//+name:String   
//+addr:String
//+UserInfo()
//+UserInfo(name:String, addr:String)   
//+getter

class UserInfo {
	public String name;
	public String addr;

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public UserInfo() {
		System.out.println("**주소록**");
	}

	public UserInfo(String name, String addr) {
		this(); //인자값 없는 생성자 호출
		this.name = name;
		this.addr = addr;

	}
}

public class ConstructorEx3 {
	public static void main(String[] args) {
		UserInfo pp = new UserInfo("도라에몽", "서울시 삼성동 멀캠"); //인자값 있는 생성자 호출
		
		System.out.println("이름 : " + pp.getName());
		System.out.println("주소 : " + pp.getAddr()+"\n");
		
		
		
		/*new UserInfo(); //인자값 없는 생성자 호출
		System.out.println("이름 : " + pp.getName());
		System.out.println("주소 : " + pp.getAddr()+"\n");
		*/
	}
}

/*
 * [출력] ** 주소록 ** <---디폴트 생성자에서 출력 이름 : 도라에몽 <---main()함수에서 getter를 이용해서 출력 주소 :
 * 서울시 삼성동 멀캠
 */