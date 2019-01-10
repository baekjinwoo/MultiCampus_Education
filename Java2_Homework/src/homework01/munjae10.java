package homework01;

import java.util.Scanner;

/*[문제10] 다음 프로그램을 작성하시오

(1)클래스명 : Sales
   필드   #article:String   
            #qty :int
            #cost :int
            #cnt :int (static)
            #discount :double(static)
   메소드 : Sales()             //품목, 수량, 단가입력받는다
                        
(2)클래스명 : Test10  (Sales를 상속받기)
  -amount:int
  +setProcess():void                              //amount = qty * cost
  +getDisplay():void                              //출력
  +setDiscount(d:double):void (static)      //할인률을 대입

(3)main()메서드 에서
    public static void main(String[] args){
           Test10  []op = new Test10[2]; 
           //나머지를 완성하시오
    }

[입/출력 화면]
품목을 입력하시오   : 삼성TV
수량을 입력하시오   : 1
단가를 입력하시오   : 1200000

품목을 입력하시오   : 지펠냉장고
수량을 입력하시오   : 2
단가를 입력하시오   : 1500000

할인율을 입력하시오 :  0.15        <--- main()에서 입력 받으시오

[[판매가]] 
삼성TV       1020000원
지펠냉장고   2550000원

판매건수 : 3건*/

class Sales{
	protected String article;
	protected int qty;
	protected int cost;
	protected static int cnt;
	protected static double discount;
	Scanner sc = new Scanner(System.in);

	
	Sales(){
		System.out.println("품목: ");
		article = sc.nextLine();
		System.out.println("수량: ");
		qty = sc.nextInt();
		System.out.println("단가: ");
		cost = sc.nextInt();
		cnt += qty; //cnt?

	}
}

public class munjae10 extends Sales{
	private int amount;
		
	public void setProcess(){
		amount = (int) ((super.qty * super.cost )*(1-discount)); //여기서 (1-discount)
	}
	public void getDisplay(){
		System.out.println(super.article+" "+cost);
	}
	public static void setDiscount(double d){
		Sales.discount= d;
	}

	
	
	
	public static void main(String[] args) {
				Scanner sc2 = new Scanner(System.in);
				munjae10 [] op = new munjae10[2];
				for (int i = 0; i < op.length; i++) {
					op[i] = new munjae10();
					System.out.println();
				}
				
				
				System.out.print("할인율을 입력하시오: ");
				munjae10.setDiscount(Double.parseDouble(sc2.nextLine()));
				
				for (munjae10 t : op) {
					t.setProcess();
					t.getDisplay();
				}
				System.out.println("판매 건수: "+ Sales.cnt);
				sc2.close();

	}
}