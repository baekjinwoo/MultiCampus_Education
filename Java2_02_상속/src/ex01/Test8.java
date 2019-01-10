package ex01;
/*[문제8] 다음 프로그램을 완성하시오
(1)클래스명 : Salary
  -name:String
  -salary:int
  +Salary(name:String, int salary:int) 
  +viewInfomation1():void  ==>이름과 연봉을 출력

(2)클래스명 : Test8 ==> Salary를 상속받음
  -department:String
  +Test8(name:String, salary:int,department:String)
  +viewInfomation2():void   ==>부서출력

(3)main()함수에서
   public static void main(String[] args){
         Test8  ob = new Test8("강호동",85000000,"개발부"); 
   }

[출력화면]
이름 : 강호동
연봉 : 85000000
부서 : 개발부*/

class Salary {
	private String name;
	private int salary;

	public Salary(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void viewInfomation1() {
		System.out.println("이름: " + getName() + "\n연봉: " + getSalary());
	}
}

public class Test8 extends Salary {

	private String department;

	public Test8(String name, int salary, String department) {
		super(name, salary);
		this.department = department;
	}

	public void viewInfomation2() {
		// 부사출력
		super.viewInfomation1();
		System.out.println("부서: " + department);
		
		//System.out.println("이름: " + getName() + "\n연봉: " + getSalary()+"부서: " + department); 이거도 가능

		
	}

	public static void main(String[] args) {
		Test8 ob = new Test8("강호동", 85000000, "개발부");
		//ob.viewInfomation1();
		ob.viewInfomation2();

	}
}
