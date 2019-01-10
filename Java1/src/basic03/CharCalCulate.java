package basic03;

public class CharCalCulate {
	public static void main(String[] args) {
		//char를 가지고 숫자를 숫자로 변형하기
		//3의 아스키코드-0의 아스키코드는 3이 남는다.(문자 아스키코드는 0~9까지만 있다.)
		
		//(char) '9'-'0';처럼, 문자를 숫자로표현하는데 -'1~9'와같은 표현을 쓴다 */

		char c='3';
		System.out.println(c-'0');
		System.out.println('2'-'0');
	}
}
