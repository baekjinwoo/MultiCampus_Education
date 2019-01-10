package basic04;

public class ForEx01 {
	public static void main(String[] args) {
		/* 1.
		 * 1부터 100까지 더하기 (for문 이용)*/
		int sum=0;
		for(int i=1;i<=100;i++){
			sum=sum+i;
		}
		System.out.println(sum+"\n");
				
		
		
		/* 2. 
		 * 1부터 99까지 홀수더하기(for문 이용)*/
		int sum1=0;
		for(int i=1;i<100;i=i+2){
			sum1=sum1+i;
		}
		System.out.println(sum1+"\n");
		
		
		
		/*3.
		 * 1-2+3-4 ~~~+99-100 (짝수빼고 홀수더한값의 합)
		 * for(int i=0,j=1;i<100;i+=2,j+=2){ sum2+=i-j; }도 결과는 -50으로 같다.*/
		int sum2=0;
		for(int i=1;i<=100;i++){
			if(i%2==0)
				sum2=sum2-i;
			else
				sum2=sum2+i;
		}
		System.out.println(sum2);
	}//main_end
}
