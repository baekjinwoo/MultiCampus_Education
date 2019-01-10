package Inheritance;

//디폴트 생성자, 인자 두개받는 생성자, toString()추가
class Emp {
	public String name;
	private String addr;

	Emp() {
	}

	Emp(String name, String addr) {
		this.name = name;
		this.addr = addr;
	}

	public String toString() {
		return "사원의 이름은 " + name + "이고 " + addr + "에 삽니다\n";
	}

}

// ----------------------------------------------------------------------------- 부모클라스의 확장

class Empcompany extends Emp {
	private String company;
	private int salary;

	public Empcompany() {
		super();
	}

	public Empcompany(String name, String addr, String company, int salary) {
		super(name, addr);
		this.company = company;
		this.salary = salary;
	}

	public String toString() {
		return super.toString()+ "회사명은 "+company+"이고 급여는 "+salary+"입니다"; //super.toString()가능
	}
}

public class InheritanceEx4 {

	public static void main(String[] args) {
		Emp ob = new Emp("민들래", "서울");
		Empcompany ob2 = new Empcompany("진달래","부산","삼성",5110000);
		
		System.out.println(ob2.toString());
	}
}
