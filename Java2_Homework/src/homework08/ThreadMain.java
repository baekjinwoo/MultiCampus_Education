package homework08;

/*[문제] Thread객체를 생성한후 다음과 같이 출력하시오

클래스명 : KoreanThread
클래스명 : EnglishLowerThread
클래스명 : EnglishUpperThread
클래스명 : ThreadMain.java
		       EnglishLowerThread t1=new EnglishLowerThread();
		       EnglishUpperThread t2=new EnglishUpperThread();
		       KoreanThread t3=new KoreanThread();
	   
	           -- 사용자가 나머지 구현하시오--   
	           
[조건]	     
1. 각각 데이타는 배열에 저장한후 사용한다
   char[] arr={'ㄱ','ㄴ','ㄷ','ㄹ','ㅁ','ㅂ','ㅅ','ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
   char[] arr={'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
	                 'o','p','q','r','s','t','u','v','w','x','y','z'};
   char[] arr={'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
			          'O','P','Q','R','S','T','U','V','W','X','Y','Z'};

2. 한 작업이 끝난후 다은 작업을 한다
    -- start()와 join()을 이용

3. Thread.sleep()를 이용해서 출력 결과를 0.3초마다 찍히도록 한다
     

[출력화면]	 
ㄱ ㄴ ㄷ ㄹ ㅂ ㅅ ㅇ .......ㅎ      
A B C D E F G................Z
a b c d e f g h i ...........z 
*/

public class ThreadMain {
	public static void main(String[] args) {
		
	}
}
