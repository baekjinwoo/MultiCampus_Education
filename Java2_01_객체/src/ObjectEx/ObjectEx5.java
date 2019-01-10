package ObjectEx;

/*   클래스명 : Sales
 *   -item:String
 *   -qty:int
 *   -cost:int
 *   
 *   +setItem(item String):void
 *   +setQty(qty int):void
 *   +setCost(cost int):void
 *   +getItem():String
 *   +getQty():int
 *   +getCost():int
 *   
 *   +toString():String          ==> 출력
 *   +getPrice():int             ==> 수량 * 단가를 리턴
 */
class Sales {
	private String item;
	private int qty;
	private int cost;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPrice() {
		return qty * cost;
	}

	public String toString() {
		return item+"을 "+ qty+"개 짜리를 구입하면 "+getPrice()+"원이 필요함";
	}

}

public class ObjectEx5 {

	public static void main(String[] args) {
		Sales ss = new Sales();

		ss.setCost(1200);
		ss.setItem("apple");
		ss.setQty(5);

		System.out.println(ss.toString()); //방법1
		
		System.out.println(ss.getItem()+"\n"+ss.getQty()+"\n"+ss.getPrice()); //방법2
		
		// setter로 값 대입 후 toString()로 출력

		// System.out.println()을 1번만 써서 출력

	}
}
/*
 * 품목 : apple 수량 : 5 단가 : 1200원 금액 : 6000원
 *
 * apple 1200원 짜리 5개 구입하면 6000원이 필요함
 */
