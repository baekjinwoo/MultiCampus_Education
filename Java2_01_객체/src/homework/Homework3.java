package homework;

public class Homework3 {
	private String item;
	private int qty;
	private int price;
	private int don;
	
	
	public Homework3(String item, int qty, int price) {
		this.item=item;
		this.qty=qty;
		this.price=price;
	}
	
	public int getDon() {
		return don;
	}

	
	public String getItem() {
		return item;
	}
	
	public int getQty() {
		return qty;
	}

	public int getPrice() {
		return price;
	}



	public void compute() {
		
		don=qty*price;
		System.out.println("품명: "+item+"\n수량: "+qty+"\n가격: "+price+"\n금액:"+don);

	}

	
	public static void main(String[] args) {
		Homework3 h=new Homework3("apple", 10, 1200);
/*		------------------------------------------------------------------
		[문제3]값을 입력받아 함수호출하여 처리하시오
		조건1)입력받은 값을  compute(item, qty, price):void  함수에서 처리
		조건2)계산방법 : 금액 = 수량 * 단가

		-입력-
		품명 : apple
		수량 : 10
		단가 : 1200

		-출력-
		품명 : apple
		금액 : 12000원*/
		
		h.compute(); //1. 생성자에서 입력했음. 
					//2. default 생성자로 놓고 compute에서 인자 입력할 수도 있음
	}
}
