package constructorEx;

public class ConstructorEx2 {
	//1. 메인그대로 놔두고 생성자의 this이용 //////////////////////////////////////////////////////////
	public ConstructorEx2() {
		this("가나다");
		System.out.println("default constructor");
	}

	public ConstructorEx2(String s) {
		this(s,10);
		System.out.println(s);
	}
 
	public ConstructorEx2(String s, int a) {

		System.out.println(s + ", " + a);

	}

	public static void main(String[] args) {
		new ConstructorEx2();
	}
	
	
	
	
	
	
	/*public ConstructorEx2() {

		System.out.println("default constructor");
	}

	public ConstructorEx2(String s) { // 인자가 있는 "생성자"
		this();
		System.out.println(s);
	}

	public ConstructorEx2(String s, int a) { // 인자가 있는 "생성자"
		this(s); // this("다라마"); 
		
		//this();  생성자에서 생성자로 호출할 때 두번 쓸 수 없다.
		System.out.println(s + ", " + a);
		//this(s); 생성자에서 생성자로 호출할때는 첫문장에 넣어야한다. 필수로.
	}
		
	public static void main(String[] args) {
		new ConstructorEx2("가나다", 10); // 생성자안에서 this만나면 다시 어울리는 생성자로 이동해서 실행하고 돌아온다.
	}*/
}
