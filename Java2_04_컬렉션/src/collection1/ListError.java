package collection1;

import java.util.ArrayList;
import java.util.List;

//제네릭스를 사용하지 않을경우: 컴파일상의 문제는 없으나, 실행시에 형변환의 문제가 발생한다.

public class ListError {

	public static void main(String[] args) {
		List<Object> List = new ArrayList<Object>(); 
		List.add("봄");
		List.add("여름");
		List.add("가을");
		List.add(4.00);
		List.add(new Integer(2));
		List.add("겨울");
		List.add(new Double(4.00));
		
		for(int i=0;i<List.size();i++){
			String s = (String)List.get(i); //15번째 line에서 오류발생. ClassCastException
			System.out.println(s);
		}
	}
}
