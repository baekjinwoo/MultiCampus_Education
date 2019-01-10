package test5;

import java.util.function.Supplier;

//Supplier: 인자를 받지 않고 리턴만 있는 함수	
//  		Supplier의 변수 s를 사용함으로써, 결과값을 바꾸지 않는 경우에 사용
//			ex) id값, getter에 사용하기 좋다(MethodEx2와 같다)
public class StreamEx5 {
	
	
	public static void main(String[] args) {

		Supplier <String> s= ()-> "hello";
		Supplier <Integer> s2 =()-> 100;
		Supplier <Double> s3 =()-> 90.5;
		
		System.out.println(s.get());
		System.out.println(s2.get());
		System.out.println(s3.get());
		
	}
}
	
	
	
//	public static String get1(){  return "hello"; } 
//	public static int get2(){  return 100; }
//	public static double get3(){  return 90.5; }
//	
//	public static void main(String[] args) {
//			System.out.println(get1());
//			System.out.println(get2());
//			System.out.println(get3());
//	}
//}

