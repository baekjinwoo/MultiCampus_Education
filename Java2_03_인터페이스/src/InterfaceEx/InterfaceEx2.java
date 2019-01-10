package InterfaceEx;

interface Cryable{
	/*abstract*/ public void cry();
}
interface Flyable{
	/*abstract*/ public void fly();
}
class Eagle implements Flyable, Cryable{
	@Override
	public void fly(){
	System.out.println("독수리는 날아다닌다");
	this.cry(); //cry메서드 호출
	}

	@Override					
	public void cry(){
		System.out.println("까악 까악");
	}
}

public class InterfaceEx2 {
	public static void main(String[] args) {
		new Eagle().fly(); 
	}
}


/*abstract class Cryable{
	abstract public void cry();
}
abstract class Flyable{
	abstract public void fly();
}
class Eagle extends Flyable{ //extends는 하나밖에 못받는다.
	@Override
	public void fly(){
	System.out.println("독수리는 날아다닌다");
	new CryableEx().cry(); //형태(중첩클래스.메서드), 중첩클래스로 넘어간다. 
	}
	
	class CryableEx extends Cryable{ //중첩클래스: 인터페이스없이 두개의 클래스를 상속받기위해 클래스안에 클래스를 구현		
		@Override					 //Eagle$CryableEx.class: 중첩클래스, 안드로이드나 스프링에서 사용
		public void cry(){
			System.out.println("까악 까악");
		}
	}
}

public class InterfaceEx2 {
	public static void main(String[] args) {
		new Eagle().fly();
	}
}
*/