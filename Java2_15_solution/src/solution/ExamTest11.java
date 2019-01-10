package solution;

import java.util.Scanner;

/* [문제11] 지불된 금액에서 제품 가격 2340원을 뺀 차액을 동전으로 거스름돈을 주려고 한다.
 최소 동전의 개수로  거스름돈을 줄 수 있게 구현하시오.
 동전은 500, 100, 50, 10 원이 사용된다고 정한다.
 
 [결과 화면]
 지불된 금액이 제품 가격 보다 적을 때 -> "제품을 구매할 수 없어요"
 지불된 금액과 제품 가격이 동일할 때 -> "거스름돈이 없습니다."
 지불된 금액이 제품 가격 보다 많을 때 -> "500원 X개, 100원 X개..."
 필요없는 금액의 동전은 출력하지 않는다. 
*/
public class ExamTest11 {
	public static void main(String[] args) {
		int productPrice = 2340;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("금액을 지불해 주세요 : ");
		int money = sc.nextInt();
		System.out.println("상품의 가격: "+productPrice);
		int rest = money-productPrice;
		System.out.println("거스름돈: "+rest);
		
		//조건
		if(money<productPrice){  //rest<0
			System.out.println("제품을 구매할 수 없어요");
		}
		if(money==productPrice){ //rest=0
			System.out.println("거스름돈이 없습니다");
		}
		if(money>productPrice){ //rest>0
			System.out.println("500원: "+rest/500+"개"
					+ "\n100원: "+(rest%500)/100 
					+ "\n50원: "+((rest%500)%100)/50
					+ "\n10원: "+((rest%500)%100)%50/10); //(rest-500)/100은 왜 안되지?
		}
	}
}
