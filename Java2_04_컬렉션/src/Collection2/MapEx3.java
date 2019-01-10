package Collection2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapEx3 {

	public static void main(String[] args) {
		Book ob1 = new Book("java","kim",100);
		Book ob2 = new Book("C#","lee",350);
		Book ob3 = new Book("oracle","park",200);
		
		Map<String, Book> map = new HashMap<>();
		map.put(ob1.getTitle(), ob1);
		map.put(ob2.getTitle(), ob2);
		map.put(ob3.getTitle(), ob3);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("찾는 도서:");
		String key = sc.nextLine();
		if(map.get(key)==null){
			System.out.println("찾는 도서가 없음");
		}
		else{
			System.out.println(map.get(key).getTitle());
			System.out.println(map.get(key).getAuthor());
			System.out.println(map.get(key).getPage());
		}
		sc.close();
	}
}
