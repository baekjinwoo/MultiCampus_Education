//4-2. 상속다시 사용해보기
package basic07;

class Saram{
	public void walk(){
	System.out.println("사람이니까 걸을 수 잇지");}
	String sum;
	
}

class Student extends Saram{
	public void think(){
	System.out.println("난 생각도 할 수 있어");
	}
}

public class Ingeritance02 {
	public static void main(String[] args) {
	Saram s1=new Saram();
	Student s2=new Student();
	
	s1.walk();
	s1.sum="숨도 쉬지";
	System.out.print(s1.sum);
	
	
	System.out.println();
	s2.walk();
	s2.think();
	s2.sum="숨도쉬지";
	System.out.print(s2.sum);
	}

}