package basic02;

public class CastingEx01 {
	public static void main(String[] args) {
		//형 변환 Casting 연산 (%c나 %s나 문자를 쓸때는 상관x 문자열을 쓸때는 무조건 %s)
		char c100='A';
		int num100=(int)'A';

		System.out.println(num100); //65
		System.out.printf("%d\n",num100); //65

		System.out.printf("%c",c100); //A
		System.out.printf("%c",num100); //A
		System.out.printf("%c",'A'); //A
		System.out.printf("%c",65); //A
		System.out.println(c100); //A		
		//System.out.printf("%d",num01); error
	}
}
