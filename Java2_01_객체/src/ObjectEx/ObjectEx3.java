package ObjectEx;

//setter & getter : 맴버변수 하나당 하나씩 값을 대입하는 setter과 그 값을 리턴하는 getter

class Member {
	private String name;
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int age;

	public double getTall() {
		return tall;
	}

	public void setTall(double tall) {
		this.tall = tall;
	}

	public void setName(String name) {
		this.name = name;
	}

	private double tall;

	public String getName() {
		return name;
	}

	public void setName() { // set/get+첫번째이름은 대문자로.
		this.name = name;
	}

}

public class ObjectEx3 {
	public static void main(String[] args) {
		Member m = new Member();
		m.setAge(25);
		m.setName("오징어");
		m.setTall(175.9);
		
		System.out.println("나이; "+m.getAge());
		System.out.println("이름; "+m.getName());
		System.out.println("키; "+m.getTall());
	}
}
