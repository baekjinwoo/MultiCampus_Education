package test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorEx1 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("축구");
		list.add("야구");
		list.add("농구");
		list.add("배구");
		list.add("탁구");
		
		//List, map, set은 collection을 쓴다
				 //Collections.sort(list); 오름차순
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2) ; //내림차순.
			}
		});
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
