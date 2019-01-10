package collection1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//List : 중복 허용O, 순서유지 O
public class ListEx1 {

	public static void main(String[] args) {
		List List = new ArrayList();
		List.add("one");
		List.add(2); //int --> Integer(Boxing) 자료형을 객체로 바꾸는것을 '박싱' // 반대로 Integer-->int를 '언박싱'
		List.add(new Float(3.0f));
		List.add(4.00);
		List.add(2);
		List.add(new Integer(2));
		List.add(new Double(4.00));
		System.out.println(List);
		
		// 자료형이 각각 달라서 for문이나 while문을 사용하기 힘들다. 따라서 Iterator를 사용한다.
		
		Iterator iter = List.iterator();
		while(iter.hasNext()){ //하나씩 출력하기할때, 
			System.out.println(iter.next());
		}
	}
}
