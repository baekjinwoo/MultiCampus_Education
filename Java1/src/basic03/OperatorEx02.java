package basic03;

public class OperatorEx02 {
	public static void main(String[] args) {
		//1. 삼항연산자를 이용한 내용(값)비교
		String str4="빨간색";
		String str5="파란색";
		String result5=(str4==str5)?"빨간색이 크다":"파란색";//str4==str5 내용값 비교
		System.out.println("\n"+result5);
				
		String str6="Tom";
		String str7="Jerry";
		String result6=(str6==str7)?"Tom이 크다":"Jerry"; //str6==str7 내용값 비교
		System.out.println(result6);
					

		//2. 삼항연산자를 이용한 번지수 비교
		String result7=(str6.equals(str7))?"Tom이 크다":"Jerry"; //str6==str7 주소값(번지수) 비교
		System.out.println(result7);
	}
}
