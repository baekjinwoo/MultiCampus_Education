package test5;

import java.util.function.Consumer;

//Consumer: 리턴하지 않고, 인자를 받는 메서드 
// MethodEx3과 같다
public class StreamEx6 {
	public static void main(String[] args) {
		Consumer<String> s1 = p-> System.out.println(p);
		Consumer<String> s2 = p-> System.out.println("이름: "+p);
		Consumer<String> s3 = p-> System.out.println("주소: "+p);
		
		s1.accept("happy");
		s2.accept("홍길동");
		s3.accept("서울");
		
		
	}
}
 
	
//	//굳이 3개의 static메서드를 만든 이유는, 3개의 다른 내용에 "이름", "주소"를 넣어주기 위해서
//	public static void view1(String str){
//		System.out.println(str);
//	}
//	
//	public static void view2(String str){
//		System.out.println("이름: "+ str);
//	}
//
//	public static void view3(String str){
//		System.out.println("주소: "+str);
//	}
//
//	public static void main(String[] args) {
//		view1("happy");
//		view2("홍길동");
//		view3("서울");
//		
//	}
//}