package HomeworkEx;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*[문제15] HashMap컬렉션을 이용하여 다음 자료를 추가하시오

(1)사용데이터
    key          value
  -----------------------
   콩쥐팥쥐   15000
   백설공주   10000
   보물섬      18000

(2) 조건 
     1) main()메서드에서  Map클래스로 객체 ht를 만들어 HashMap으로 인스턴스할당할것
     2) 제네릭스를 이용하여 데이터를 추가할것
     3) 아래 화면처럼 출력하되, 책가격은 세자리마다콤마찍고 화폐단위 "원"을 표시할것
       
[출력화면]
콩쥐팥쥐의 책가격=15,000원
보물섬의 책가격=18,000원*/

public class HomeworkEx3 {
	public static void main(String[] args) {
		
		Map<String, Integer> ht = new HashMap<>();
		
		ht.put("콩쥐팥쥐", 15000);
		ht.put("백설공주", 10000);
		ht.put("보물섬", 18000);
		
		System.out.println("key\t value");
		
		Set <String> key = ht.keySet();
		for(String k:key){
			String st = ht.get(k).toString();
			int n = st.length()-3;
			System.out.println(k+"     "+st.substring(0,n)+","+st.substring(n)+"원");
		}
	}
}
