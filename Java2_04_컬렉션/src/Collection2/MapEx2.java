package Collection2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapEx2 {
	public static void main(String[] args) {
/*		Map<Integer,String> map=new HashMap<>();
		map.put(3, "민들래");
		map.put(1, "들국화");
		map.put(4, "진달래");
		map.put(2, "개나리");
		map.put(5, "채송화");
		
		Set<Integer> keys=map.keySet();
		for(Integer k : keys){
			System.out.println(map.get(k));
}*/	

		
		Map<String,String> map=new HashMap<>();
		map.put("3", "민들래");
		map.put("1", "들국화");
		map.put("4", "진달래");
		map.put("2", "개나리");
		map.put("5", "채송화");
		
		Set<String> keys=map.keySet();
		List<String> list=new ArrayList<>(keys);
		Collections.sort(list);
		
		for(String k : list){
			System.out.println(map.get(k));
		}
	}
}