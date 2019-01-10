package collection1;

import java.util.ArrayList;
import java.util.List;

public class ListEx2 {

	public static void main(String[] args) {
		List<Object> List = new ArrayList<Object>(); //최상위클래스 Object(객체형)를 쓰면 아래의 문자열, 정수, 실수가 다 들어간다.
		List.add("봄");
		List.add("여름");
		List.add("가을");
		List.add(4.00);
		List.add(new Integer(2));
		List.add("겨울");
		List.add(new Double(4.00));
		
		/*Iterator<Object> iter = List.iterator();
		while(iter.hasNext()){ //하나씩 출력하기할때, 
			System.out.println(iter.next());
		}
		*/
		
		for(Object m : List){ ///자료형 변수 : 클래스
			System.out.println(m);
		}
		
	}
}
