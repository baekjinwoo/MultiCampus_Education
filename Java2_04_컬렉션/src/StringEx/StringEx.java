package StringEx;

public class StringEx {
		//charAt : 성별을 알아낼 때
	    //substring: 앞자리를 알아낼 때
	public static void main(String[] args) {
		String str1="korea";
		String str2=" fighting";
		
		//01234567890123
		//korea fighting
		String str3=str1.concat(str2); //Concat은 다 붙이는 것.
		String str4=str3.substring(6, 11); //6~10까지 
		String str5=str3.substring(6); //6~이후
		char s=str3.charAt(4);
		
		System.out.println(str3); //korea fighting
		System.out.println(str4); //fight
		System.out.println(str5); //fighting
		System.out.println(s); //a
		

		
/*		String s1="Hello";
		String s2="Hello";
		String s3=s2;
		String s4=new String("Hello"); //t
		String s5=new String("Hello"); //t  //new로 인해 새로운 번지공간으로 "Hello"가 저장된다.
		
		System.out.println(s1==s2); //t
		System.out.println(s1==s3); //t
		System.out.println(s1.equals(s2)); //t
		System.out.println(s1.equals(s3)); //t
		System.out.println(s4==s5);  //false //s4와 s5의 주소값이 다르기떄문에 
		System.out.println(s1.equals(s5)); //t
*/		
	}
}
