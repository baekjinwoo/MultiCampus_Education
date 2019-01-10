package constructorEx;

class Emp {
	private String name = "이순신";
	private int age = 25;

	Emp(String name, int age){
		this.age=age;
		this.name=name;
	}
	
	Emp(){ //default생성자는 내가 쓰던 안쓰던 만들어 두는것이 좋다.
		
	}
	
	public void view() {
		System.out.println(name + " " + age);
	}
}

public class ConstructorEx7 {

	public static void main(String[] args) {
		Emp e=new Emp("홍길동",27);
		e.view();
		
		Emp e2=new Emp();
		e2.view();
	}
}
