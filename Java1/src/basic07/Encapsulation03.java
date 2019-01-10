package basic07;

//선생님이 다시 풀어준 문제(Danche.class)
class Danche {
	private String danName;
	private int inwon;
	
	public String getDanName() {
		return danName;
	}
	public void setDanName(String danName) {
		this.danName = danName;
	}
	public int getInwon() {
		return inwon;
	}
	public void setInwon(int inwon) {
		this.inwon = inwon;
	}
	
	public int kyesan(){ //한 단체의 요금계산 메소드 (생성자는 아니기때문에 void나 return쓸수있다)
		return 5000*inwon;
	}
	
	public Danche(String danName, int inwon) { 	
				//source -> generate constructor using field 생성자 자동생성
		this.danName = danName;
		this.inwon = inwon;
	}
}

public class Encapsulation03 { 
	static int chong=0; //static변수: 프로그램끝날때까지 살아있는 변수

	public static void main(String[] args) {
		//int chong=0; //지역변수: 중괄호안에 있는 변수
		Danche d1=new Danche("902호",20);
		chong+=d1.kyesan();
		
		Danche d2=new Danche("굳맨",15);
		chong+=d2.kyesan();
		
		Danche d3=new Danche("가자",17);
		chong+=d3.kyesan();
		
		System.out.println(d1.getDanName()+"\t"+d1.getInwon());
		System.out.println(d2.getDanName()+"\t"+d2.getInwon());
		System.out.println(d3.getDanName()+"\t"+d3.getInwon());
		System.out.println("총요금:"+chong);
	}
}