package methodex;

//Call by Name 리턴값만 연습
public class Methodex2 {
	public static int view1() {
		return 10; // return뒤에는 하나만 작성할 수 있다. return 10,20,30 x
					// 여러개를 보내기 위해 객체를 사용
	}

	public static char view2() {
		return 'A';
	}

	public static float view3() {
		return 10.5f;
	}

	public static boolean view4() {
		return false;
	}

	public static String view5() { // String은 대문자
		return "Hello";
	}

	
	
	public static void main(String[] args) {
		int a = view1();
		System.out.println(a);

		char b = view2();
		System.out.println(b);

		// float c = view3();
		// System.out.println(c);
		System.out.println(view3());

		System.out.println(view4());
		System.out.println(view5());
	}
}
