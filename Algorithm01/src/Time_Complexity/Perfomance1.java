package Time_Complexity;

public class Perfomance1 {
	public static void main(String[] args) {
		System.out.println( System.currentTimeMillis() ); //출력이전 시간측정하기
		//(1970년 1월 1일 0 0 0 ~ 현재시간)를 1/1000초로 보여준다 
		System.out.println("*"); 
		System.out.println( System.currentTimeMillis() ); //출력이후 시간측정하기
	
		
		//출력 전후 시간차이 
		long start = System.currentTimeMillis();
		System.out.println("*"); 
		long end = System.currentTimeMillis()-start;
		System.out.println(end);
	}
}
