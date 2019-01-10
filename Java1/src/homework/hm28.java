package homework;

/*문제.
품명, 금액, 제조사명을 넣는 
class를 설계한후 Arralist 배열에 다음 자료가 
들어있는 객체를 모두 넣은 후 
금액이 30000원 이상되는 자료만 검색해 
출력모양처럼 출력하시오(출력시 toString사용) 
 
 
"좋은맛과자", 25000, "Sams"
"아자과자", 32000, "Sams"
"우유맛과자", 17050, "Sams"
"참지과자", 24500, "Sams"
"고소해", 75000, "KwajaGood"
"깐풍기과자", 34300, "KwajaGood"
"국화차과자", 1400, "KwajaGood"
"고소고소한", 17560, "Hello"
"굳오징어땅콩", 57800, "Hello"
"비타민과자", 63000, "Hello"

<< 검색된 상품 목록 >>
아자과자(Sams) :32000
고소해(KwajaGood) :75000
깐풍기과자(KwajaGood) :34300
굳오징어땅콩(Hello) :57800
비타민과자(Hello) :63000   */

import java.util.*;

class SuperMarket {
	private int don;
	private String product;
	private String jejoname;

	public int getDon() {
		return don;
	}

	public void setDon(int don) {
		this.don = don;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getJejoname() {
		return jejoname;
	}

	public void setJejoname(String jejoname) {
		this.jejoname = jejoname;
	}

	public SuperMarket(String product, int don, String jejoname) { // 생성자에 들어가는
																	// 값 작성은 필수
		this.product = product;
		this.don = don;
		this.jejoname = jejoname;
	}

	public String toString() {
		return this.product + "\t" + this.don + "\t" + this.jejoname + "\n";
	}

}

public class hm28 {
	public static void main(String[] args) {
	//List a=new ArrayList();
		ArrayList<SuperMarket> a=new ArrayList<SuperMarket>(); //제네릭은 SuperMarket클래스를 객체화해서 <SuperMarket>이라는 객체만 접근할 수 있도록 자료형으로 선언한것. a는 ArrayList가변배열의 변수로써, 값이 들어갈때마다 a[0],a[1]늘어난다. 배열의 길이가 무한으로 늘어나되 하나의 배열로써 작용하게 된다. 또 기본배열의 장점으로는 타입을 SuperMarket으로 지정할 수 있다는 것이다
		
		a.add(new SuperMarket("좋은맛과자", 25000, "Sams")); //오직 SuperMarket만 받을수있도록 객체화된 SuperMarket자료형안에 선언된 것들을 a배열에 순서대로 넣는다
		a.add(new SuperMarket("아자과자", 32000, "Sams")); //a[1]
		a.add(new SuperMarket("우유맛과자", 17050, "Sams")); //a[2]
		a.add(new SuperMarket("참지과자", 24500, "Sams")); //a[3]
		a.add(new SuperMarket("고소해", 75000, "KwajaGood")); //a[4]
		a.add(new SuperMarket("깐풍기과자", 34300, "KwajaGood")); //a[5]
		a.add(new SuperMarket("국화차과자", 1400, "KwajaGood")); //a[6]
		a.add(new SuperMarket("고소고소한", 17560, "Hello")); //a[7]
		a.add(new SuperMarket("굳오징어땅콩", 57800, "Hello")); //a[8]
		a.add(new SuperMarket("비타민과자", 63000, "Hello")); //a[9]
					
		for(int i=0;i<a.size();i++){
			if(a.get(i).getDon()>30000) //객체 객체명 속성이름 //a자리에 SuperMarket을 넣게되면 int(자료형)을 넣게되는것과 똑같다. //a배열의 i번지의 Don을 반환한다는 의미// a.get(0)은 a[0]번지를 반환한다는 의미.
					System.out.print(a.get(i).toString()); //toString을 작성하려면 toString 메서드를 따로 만들어야한다.
			}
		}
	}

