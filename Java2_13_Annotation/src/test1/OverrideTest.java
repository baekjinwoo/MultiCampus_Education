package test1;

import java.util.ArrayList;
import java.util.List;

public class OverrideTest { //extends Object가 생략되있다
	
	@Override 	//메서드 오버라이드를 한다는 것을 명시  //메서드앞에서 사용
	public String toString(){
		return "Override Test";
	}

	@SuppressWarnings(value="unchecked") //검증되지않은 연사자 관련경고 //메서드앞에서 사용
	public static void main(String[] args) {
		System.out.print(new OverrideTest().toString());

//--------------------------------------------------------------------------------------------------------------------
		
	@SuppressWarnings("rawtypes") //제네릭을 사용하는 클래스 매개변수가 불특정일때의 경고 //변수앞에서 사용
		List list = new ArrayList(); //@SuppressWarnings을 이용한 경고제거 (1)
//		List<String> list = new ArrayList<>();  //제네릭을 이용한 경고제거 (2)
	
		list.add("apple");
		list.add("orange");
		list.add("banana");
		System.out.print(list);
		
		
		
		
	}
}
