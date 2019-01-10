package test5;

import java.util.function.Function;

//Function<T,R>: T형 인자를 받아서 R형으로 리턴한다
public class StreamEx7 {
//	public static void main(String[] args) {
//		Function <String, Integer> f=s-> s.length();
//		int n=f.apply("abcdefg"); //값을 주입
//		System.out.println(n); //출력
//		
//		
//		Function <Integer, String> m=s-> (s>=60)?"Pass":"fail";
//		String k=m.apply(75); // 값을 주입
//		System.out.println(k); //출력
//	}
//}

	
	
	//위와같은 람다를 이용하지 않은 기본코드
	public static int view1(String str){
		return str.length();
	}

	public static String view2(int num){
		return (num>=60)?"pass":"fail";
	}
	
	public static void main(String[] args){
		System.out.println(view1("abcdefg"));
		System.out.println(view2(75));
	}
}