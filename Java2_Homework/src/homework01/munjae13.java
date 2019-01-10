package homework01;

/*[문제13] 문자열변수에 "IT ELITE" 를 대입한후 String클래스의 메서드를 이용하여
         다음과 같이 출력하시오

-출력-

L   T
it elite
IT
ELITE
iT ELiTE*/

public class munjae13 {
	public static void main(String[] args) {
		String str = "IT ELITE";
		System.out.println(str.charAt(4)+"\t"+str.charAt(6));
		
		String str1 = str.toLowerCase(); //대문자 ->소문자
		System.out.println(str1);
		
		String str2 = str.substring(0,2);
		System.out.println(str2);
		
		String str3 = str.substring(3,8);
		System.out.println(str3);
		
		
		
		char c1 = str.charAt(0); //indexOf, contains //Concat(연결)
		char c2 = str.charAt(5);
		c2= c1 = 'i';
		String str4 = str.substring(1,2);
		String str5 = str.substring(3,5);
		String str6 = str.substring(6,8);
		
		System.out.println(c1+str4+"  "+str5+c2+str6);
	}
}