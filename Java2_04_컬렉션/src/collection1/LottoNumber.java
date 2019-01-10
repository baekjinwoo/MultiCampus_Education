package collection1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumber {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		while(set.size()<6){
			set.add((int)(Math.random()*45)+1); //0~0.99999 =>0~44.9999 =>0~44 =>1~45
		}
		for(Integer ob : set){ //자료형 변수 : 객체
			System.out.println(ob);
		}
		
		
		System.out.println("================위:정렬전===//===아래:정렬후================");
		
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list); //오름차순 정렬
		
		for(Integer ob : list){ //자료형 변수 : 객체
			System.out.println(ob);
		}
	}
}
