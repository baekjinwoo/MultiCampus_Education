package methodex;

// 가독성을위해 java->editor -> syntax -> number & classes 색 변경
// Call by Name: 이름만 있는 함수 
public class MethodEx1 {

	public static void view() {
		System.out.println("hello");
		return; // 생략가능 view함수가 실행을 마치면 원래 main으로 돌아가라는 의미
	}

	public static void star() {
		System.out.println("************");
	}

	public static void main(String[] args) {
		view(); // 함수찾기 F3
		star();

		view(); // 반복처리
		star();
	}
}
