package homework;

public class hm07 {
	public static void main(String[] args) {
		//문제. 1+(1+2)+(1+2+3)+(1+2+3+4)+(1+2+3+4+5)+....+(1+2+3+ +100) 
		
		int sum=0;
		for (int i = 1; i <= 100; i++){
			for (int j = 1; j <= i; j++){
				sum=sum+j;
				}
			System.out.println();
			}
		System.out.println(sum);

	}
}
