package homeworkEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ListHashSet {
	public static void main(String[] args) {
		Random r = new Random();
		int size = Integer.parseInt(args[0]);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		// ArrayList에 size만큼의 개수 만큼 랜덤한 숫자를 넣는다.
		while (list.size() < size) {
			list.add((int) (Math.random() * 10));
			System.out.println(list);
				
		}
		// ArrayList에 정보를 HashSet에 넣는다.

		ArrayList<Integer> set = new ArrayList<>();
		Collections.sort(set); //오름차순 정렬
		
		for(Integer ob : set){ //자료형 변수 : 객체
			System.out.print(ob);
		}
	}
}
