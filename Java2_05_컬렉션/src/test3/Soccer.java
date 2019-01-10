package test3;



public class Soccer /*implements Comparable<Soccer>*/ {

	private String name;
	private String position;
	private int age;

	public Soccer(String name, String position, int age) {
		super();
		this.name = name;
		this.position = position;
		this.age = age;
	}

	public Soccer() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*@Override
	public int compareTo(Soccer o) {
		return name.compareTo(o.name); //이름순으로 오름차순
		//return (o.position).compareTo(position); //포지션순으로 오름차순
		//return (this.age)-o.age; //나이순
	}*/

}
