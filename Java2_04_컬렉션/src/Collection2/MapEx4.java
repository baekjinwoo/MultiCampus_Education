package Collection2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapEx4 {

	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
		map.put("민들래","객실1");
		map.put("들국화","객실2");
		map.put("진달래","객실1");
		map.put("개나리","객실3");
		map.put("채송화","객실2");
		
		Scanner sc=new Scanner(System.in);
		System.out.print("방 이름을 입력하시오(객실1~객실3):");
		String roomNumber=sc.next();		
		
		Set<String> col=map.keySet();
		for(String  key: col)
		{
			String room=(String)map.get(key);
			
			if(room.equals(roomNumber)){
				System.out.println(roomNumber + "에 있는 사용자는 " + key +"입니다");
			}
		}
		sc.close();
	}
}
