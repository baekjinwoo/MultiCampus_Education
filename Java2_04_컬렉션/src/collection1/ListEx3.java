package collection1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListEx3 {

	public static void main(String[] args) {
		Book ob1 = new Book("java","kim",100);
		Book ob2 = new Book("C#","lee",350);
		Book ob3 = new Book("oracle","park",200);

		List<Book> ob = new ArrayList<>();  //Book타입
		ob.add(ob1);
		ob.add(ob2);
		ob.add(ob3);
		
	/*	for(Book m : ob){ //자료형 변수 : 객체
			System.out.println("책이름: "+m.getTitle()+"책저자:  "+m.getAuthor()+"페이지:  "+m.getPage());
		}*/
		
		Iterator<Book> m = ob.iterator();
		while(m.hasNext()){
			Book it=m.next();
			System.out.println("책 이름:"+ it.getAuthor());
			System.out.println("책 저자:"+it.getTitle());
			System.out.println("페이지: "+it.getPage());
			
		}
	}
}
