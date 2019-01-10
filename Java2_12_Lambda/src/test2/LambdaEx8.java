package test2;

import java.util.ArrayList;
import java.util.List;

public class LambdaEx8{
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("월");
		list.add("화");
		list.add("수");
		list.add("목");
		list.add("금");
		
		//1. 일반식으로 출력
		for(String m : list){
			System.out.println(m);
		}
		
		System.out.println("-------------------------------------");
		System.out.println("-람다로 시작-");

		
		//2. 람다식으로 출력: list의 갚을 forEach앞에 주면 된다. 반복자iterator나 for문 필요없음.
		list.forEach( 
				m-> System.out.println(m)
					);
		
		
	}
}
