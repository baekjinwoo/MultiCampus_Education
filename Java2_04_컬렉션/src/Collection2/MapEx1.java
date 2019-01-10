package Collection2;

import java.util.HashMap;
import java.util.Map;

//Arraylist는 순서가 있기때문에 맨 뒤의 값을 출력하기위해서는 for문으로 다 돌려야하지만. map은 값마다 key값이 있기대문에 검색한다.  반복문 돌리지않아도 된다.
public class MapEx1 {

	public static void main(String[] args) {
		Map <Integer,String> map = new HashMap<>();
		map.put(101, "민들레");
		map.put(201, "들국화");
		map.put(301, "진달래");
		map.put(401, "개나리");

		System.out.println("key값: "+101+"\nvalue값: "+map.get(101));
		System.out.println("key값: "+401+"\nvalue값: "+map.get(401));
		
/*		Map map = new HashMap();
		map.put(101, "민들레");
		map.put(201, "들국화");
		map.put(301, "진달래");
		map.put(401, "개나리");

		System.out.println("key값: "+101+"value값: "+map.get(101));*/
	}
}
