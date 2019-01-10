package collection1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


//Set : 중복 허용X 순서 유지 X
public class SetEx {
	@SuppressWarnings(value="unchecked")

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("one");
		set.add(2); //int --> Integer(Boxing) 자료형을 객체로 바꾸는것을 '박싱' // 반대로 Integer-->int를 '언박싱'
		set.add(new Float(3.0f));
		set.add(4.00);
		set.add(2);
		set.add(new Integer(2));
		set.add(new Double(4.00));
		System.out.println(set);
		
		// 자료형이 각각 달라서 for문이나 while문을 사용하기 힘들다. 따라서 Iterator를 사용한다.
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){ //하나씩 출력하기할때, 
			System.out.println(iter.next());
		}
	}
}
