package basic01;

public class OverflowEx {
	public static void main(String[] args) {
		/* 최대값에 1을 더하면 오버플로우로 최소값-2147483648이 나온다. 
		 * 011111~~1 + 00000~~1 : 10000~~000 음수 최소값이 나온다.  
		 * 2147483647의 2의보수는 -2147483647인대 100000~~001이 나온다. 
		 * byte:-128~127 short:-32768~32767 int:-2147483648~2147483647	*/
				
		int ii2=2147483647; //int don=2147483648은 안됨
		System.out.println(ii2+1); //-2147483648
				
		int don=2147483647; //int형 양수 최대값
		int don2=don+1;
		System.out.println(don2); 
						
	}
}
