package basic07;

/* clas Noridongsan1
	변수:단체명, 인원수
	출력 단체명, 인원수, 입장료, 총요금
	단, 1인당 입장요금은 성인,아이 구별없이 5000원
	캡슐화, 생성자, this를 사용하여 만드시오 */


//내가 푼 문제
class Noridongsan1{ //설계
	private int inwon; //변수지정시 캡슐화할땐 private
	private String danchae;
	int fee;
	
	public int getFee() {  //get,set 캡슐화
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getDanchae() {
		return danchae;
	}
	public void setDanchae(String danchae) {
		this.danchae = danchae;
	}
	
	public int getInwon() {
		return inwon;
	}
	public void setInwon(int inwon) {
		this.inwon = inwon;
	}
	
	public Noridongsan1(String danchae,int inwon){ //생성자
		this.danchae=danchae;
		this.inwon=inwon;
	}
	
	public Noridongsan1(){
		fee=5000;
	}
	//5000원은 변하지 않기때문에 이 생성자를 빼버리고 위에 Static int fee= 5000;이라고 적어놓고 아래에서 호출해도 된다.
}

public class Encapsulation02 {
	public static void main(String[] args) {
		Noridongsan1 n1=new Noridongsan1("멀티캠퍼스",7); //객체 생성 및 초기화
		
		System.out.println("<"+n1.getDanchae()+">");
		System.out.println("총 인원은 "+n1.getInwon()+"명");
		System.out.println("1인당 입장료는 "+n1.fee+"원"); 
						//요금은 무조건 5000원이니까 default생성자로 해보자
		System.out.println("총 요금은 "+n1.getInwon()*n1.fee+"원");
		
		System.out.println("단, 1인당 입장요금은 성인과 아이 구별없이 5000원");
		
	}
}

