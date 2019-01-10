package solution;

/*[문제13]
클래스명 : Date
필  드 : year, month, day          (제조 년,월,일)
메서드 : Date(int,int,int); 
         void printDate();         <--- 년,월,일출력


클래스명 : Product                 <---- Date를 상속받음
필  드 : item,company,price        (상품명,제조사,가격)
메서드 : Product(String, String, int,int,int,int)
         void printPro();          <----- 상품명,제조사,가격출력

파일명/클래스명 : ExamTest13           <--- main()포함      

[조건]
Test1클래스의 main()함수에서 Product클래스로 
객체 ob("새우깡", "농심",1200, 2012, 3, 10)을 생성한후 
각각의 메서드를 호출하여 아래와 같이 출력하시오
   
[결과 화면]
상품명 : 새우깡
제조사 : 농심
가  격 : 1200원
제조일 : 2012/3/10
*/

class Date{
	int year;
	int month;
	int day;
	
	public Date(int year, int month, int day){
		this.year=year;
		this.month=month;
		this.day=day;
	}
	public void printDate(){
		System.out.println("제조일 : "+year+"/"+month+"/"+day);
	}
}
 
class Product extends Date{
	String item;
	String company;
	int price;
	
	public Product(String item, String company, int price, int year, int month, int day) {
		super(year, month, day); //상속먼저해야됨
		this.item=item;
		this.company=company;
		this.price=price;
	}
	public void printPro(){
		System.out.println("상품명 : "+item+ "\n제조사 : "+company+"\n가 격 : "+price);
	}
}

public class ExamTest13 {
	public static void main(String[] args) {
		Product ob = new Product("새우깡", "농심",1200, 2012, 3, 10); //부모 객체 = new 부모 (오버라이드메서드없으면 x), 왠만하면 자식 객체 = new 자식
		ob.printPro();
		ob.printDate();
	}
}
