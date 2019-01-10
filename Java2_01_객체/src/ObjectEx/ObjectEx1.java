package ObjectEx;

/*  -(private) , +(public) , #(protected)
 *  
 *  클래스명 : Person
 *  +name:String
 *  +age:int
 *  +score:float
 *  
 *  +setPerson(na:String, a:int, s:float) : void
 *  +viewPerson():void 
 */

class Person {

	public String name;
	public int age;
	public float score;

	public void setPerson(String name, int age, float score) { //setperson은 값 대입함수
		this.name = name;
		this.age = age;
		this.score = score;

	}

	public void viewPerson() { //viewperson은 값 출력함수
		System.out.println("이름:" + name);
		System.out.println("나이:" + age);
		System.out.println("점수:" + score);

	}

}

public class ObjectEx1 {

	public static void main(String[] args) {
		Person p = new Person(); //new Person: 실제로 heap영역에 메모리를 할당하는 인스턴스.
		p.setPerson("민들래", 22,75.8f); //객체=필드+메서드
		p.viewPerson();
		System.out.println(p.hashCode());

		Person p2 = new Person();
		p2.setPerson("개나리", 10,95.8f);
		p2.viewPerson();
		System.out.println(p2.hashCode());
		

	}
}
