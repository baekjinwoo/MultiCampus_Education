package basic05;

public class MethodEx01 {
	public static void main(String[] args) {
		// 1. C언어      함수function
		// 모든 프로그램은 main에서 시작해서 main에서 끝난다.
		// 자바,C#   메서드(반복을 줄이기위해)
				 	 
		// 메서드 호출문- 사장역할
		// 메서드 정의문- 비서역할 
				
			kaja1(); //메서드 호출문- 사장
					//반드시 호출문은 호출후에 되돌아온다 (메서드 1형식)
				
			int aa3=200;
			int aa2=100;
			kaja2(aa2, aa3); // 예하 메소드로 자료전달 (메서드 2형식) 
							// aa2와같은 자료를 인자, 인수, argument라고 한다.
				      	   // 메서드1,2형식은 호출 후에 다음줄로 넘어간다.
					
			String bada2= kaja3();  // kaja3()를 지우고 "다했음"이 들어간다 (메서드 3형식)
									// 그냥 kaja3();만 쓰면 안된다.
									// 괄호안에 인자가 있든없든 예하메서드에 Return이 있으면 3형식이다.
			System.out.println(bada2);
		} //main-end

//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void kaja1(){ //메서드 정의문- 비서
		System.out.println("메서드 입문");
		System.out.println("메서드를 쓰는 방식");
		System.out.println("또 비서가 비서를 호출할 수 있다.");
	}
	
	public static void kaja2(int bada, int bada2){ // bada와 같은 자료를 매개변수(parameter)라고한다. 
		System.out.println(bada+100+bada2);	   		  // aa2,aa3와 bada,bada2는 이름이 똑같이 선언되어도 상관없다.
		// 왜냐하면, 저장된 스택메모리가 달라서(열고 닫는 괄호의 범위가 달라서)
	} 

	public static String kaja3(){ //(1)void: 반환할 자료형이 없을때  (2)문자열을 반환할때는String, 숫자는 Int 등 
		System.out.println("나 ~~~3형식이야");
		String str="다했음";
		return str; //비서가 호출후 되돌아갈때 가져갈 것임.
	}
			
}//class_end
