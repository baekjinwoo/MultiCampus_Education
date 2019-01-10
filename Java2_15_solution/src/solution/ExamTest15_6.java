package solution;

/*
 1부터 100까지 더하는 프로그램을 작성 한다. 단, eclipse에서 argument로 1자리 정수형 데
 이터를 입력 받아 입력 받은 수의 배수만 더한다.
 입력 예1: 5
 5,10,15, … , 100의 합
 */

public class ExamTest15_6 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int sum=0;
		for(int i=1; i<100; i++){
			sum=n*i; //sum+=n*i로 하면 안된다.
			System.out.println(sum); //1~100까지의 5의배수 구성
		}//for-end
		System.out.println("\n1~100 범위에서 "+n+"배수의 최종합계는 "+sum);
	}
}
