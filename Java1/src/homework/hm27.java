package homework;


/*문제. String에 P1**samsung**5라는 문자열을 넣은후 다음과 같이 출력하시오
 제품번호: P1, 생산자: samsung, 수량:5
조건) 1) 출력은 toString()을 오버라이드한 것을 참조하여 chool메소드를 만들어 사용한다
2) Product 클래스에 다음과 같은 필드가 있어야 한다.
	private String productld;
	private String maker;
	private int amount;
3) getter/setter를 만들어 사용하여야 한다*/

class Product{
	private String productld; //제품번호
	private String maker; //생산자
	private int amount; //수량

	public String toString(){return productld+maker+amount;}  //product인스턴스의 productld와 maker,amount를 문자열로 반환

	public String getProductld() {	return productld; }
	public void setProductld(String productld) {
		this.productld = productld;
	}
	
	public String getMaker() {	return maker; }
	public void setMaker(String maker) {
		this.maker = maker;
	}
	
	public int getAmount() { return amount;	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	//생성자 없이 getter/setter로 배열의 정보를 product클래스에 넣어서 출력해보자.
	public void chool(Product a1, Product a2, Product a3){ //Product클래스의 chool메소드: toString()을 출력할 것임
		System.out.println("제품번호: "+productld);
		System.out.println("생산자: "+maker);
		System.out.println("수량:"+amount);
	}
}

//split를 이용해서 나누서 배열을 만들기
//chool메소드안에서 toString()을 오버라이딩으로 사용해서 출력한다.
//Product클래스안에서만 사용가능한 변수3개(수량, 생산자, 제품번호)를 선언하고 getter, setter

public class hm27 {
	public static void main(String[] args) {
		String s1="P1**samsung**5";
		
		//String[] s2=s1.split("\\**"); split로 \\**을 자르니까 문자열에서 문자로 바뀌어서 번거로움. substring을 쓰자
		
		String[] s2=new String[3];
		s2[0]=s1.substring(0,2);
		s2[1]=s1.substring(4,11);
		s2[2]=s1.substring(13);
		
		Product p1=new Product();
		int i1=Integer.parseInt(s2[2]); //char c1=s2[2].charAt(0);이렇게 하면 문자가 되는대 상위 클래스에서 int로 받기때문에 integer.parseint해줘야한다.
		
		System.out.println("잘 동작하는지 확인차 s2[2] 배열안에있는 수는"+s2[2]);
		
		p1.setProductld(s2[0]);
		p1.setMaker(s2[1]);
		p1.setAmount(i1);
		
		p1.chool(null, null, null); //이미 값을 입력해놨기때문에 null을 넣으면 되는건가? 이건 별표!!
		}
}

















/* 또 다른 풀이법1
 * class Product{
	private String productid;
	private String maker;
	private int amount;
	
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
		
	public String chool(){
		return "제품번호 : "+this.productid+", 생산자 : "+this.maker+", 수량: "+this.amount;
	}
}
public class hm27 {
	public static void main(String[] args) {
		String str = "P1**samsung**5";
		String[] p = str.split("\\*\\*");
		
		Product prd = new Product();
		prd.setProductid(p[0]);
		prd.setMaker(p[1]);
		prd.setAmount(Integer.parseInt(p[2]));
		
		System.out.println(prd.chool());
	}
}*/


/* 또 다른 풀이법2

class Product{
	private String productId;
	private String maker;
	private int amount;
	

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String Chool() {  // toString 매서드를 오버라이딩 하여 사용
		return 
("제품번호 : "+productId+ ",생산자 :"+ maker +",수량 : "
		+ amount);
	}	
}
public class hm27 {
	public static void main(String[] args) {
		String Info = "P1**samsung**5";
		Product pro1 = new Product();
		pro1.setProductId(Info.substring(0, 2));  // 제품번호
		pro1.setMaker(Info.substring(4, 11));  // 생산자  
	
		int amount = Integer.parseInt(Info.substring(13, 14));  
		pro1.setAmount(amount);  // 수량

		System.out.println(pro1.Chool());//////		
	}
}
/*제품번호 : P1,생산자 :samsung,수량 : 5
*/