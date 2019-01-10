package instance;

class AA{}
class BB extends AA{}
class CC extends AA{}


public class InstanceOfEx1 {
	public static void main(String[] args) {
		AA a = new AA();
		BB b = new BB();
		
		System.out.println(b instanceof AA); // true // 자식에서 부모로 o
		System.out.println(a instanceof CC); // false // 부모에서 자식으로 x (오버라이드메서드있을떄만)
//		System.out.println(b instanceof CC); // error //자식클래스끼리 x

		
	}
}
