package family;

public class Family {
	private String name;
	
	public Family(){
		
	}
	public Family(String name){
		this.name=name;
		
	}

	public String toString(){ 
		return "이름: "+name+"\n"; //return null로 주면 이 클래스는 의미가 없게된다. 이름을 반환하는 return값을 만들고 자식클래스에서 override메서드안에서 super로 가져오면된다
	}
}
