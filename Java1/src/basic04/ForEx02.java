package basic04;

//구구단
public class ForEx02 {
	public static void main(String[] args) {
		//1. 구구단중 7단을 출력하시오
		for(int i=1;i<=7;i++){
			System.out.printf("%d x %d= %d \n",7,i,7*i);
		}
				

		//2. 2단부터9단 구구단출력
		for(int i=1;i<=9;i++){
			for(int j=2;j<=9;j++){
				System.out.printf("%d  x  %d  = %d\t",j,i,j*i);
			}
			System.out.println();
		}
		System.out.println();
	}
}
