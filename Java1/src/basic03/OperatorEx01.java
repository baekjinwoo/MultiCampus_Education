package basic03;

public class OperatorEx01 {
	public static void main(String[] args) {
		//단항연산자(중에서 증감연산자)
		
		int i0=20; //필수로 초기화해야한다.
		i0++; //int를 붙이면 안된다.
		
		System.out.println(i0); //후치
		System.out.println(i0);

		++i0;

		System.out.println(i0); //전치
		System.out.println(i0);
	}
}
