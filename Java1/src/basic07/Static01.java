package basic07;

public class Static01 {
	public static void main(String[] args) {//static메소드에서 static변수전달
		Emp e1=new Emp(); //설계도 하나 가지고 new작성할때마다 객체생성하므로, 객체 3개를 만든다. 
		Emp e2=new Emp();
		Emp e3=new Emp();
		System.out.println("생성된 객체의 수: "+ Emp.getEmpNum());
		
		//원래는 객체.메소드()이지만, static변수를 사용함으로써 클래스.스태틱메소드()를 쓴다.
		//???? Emp가 클래스인대 클래스면서 생성자가 되나? => 생성자는 메소드와 비슷한 개념으로써 클래스와는 엄연히 다르다.
	}
}


//Static변수
class Emp{
	String name;
	static int num=0; 
//객체& new와 관계없이 사용가능하다. main도 객체&new와 상관없이 툴을 시작하자마자 바로 실행한다. 
//이와같은 이유로 static변수 초기화는 바로해줘야한다. static초기치는 무조건 저기아니면 넣을 수가 없다. 
//프로그램 끝날때까지 안지워지는 변수.
	
	public Emp(){ 	// main에서 new를 작성하면 바로 찾아오는게 "생성자"이다
		System.out.println("객체 생성수"+ ++num);
	}
	
	public static int getEmpNum(){ //static메소드에는 static변수가 들어간다.
		return num;
	}
}