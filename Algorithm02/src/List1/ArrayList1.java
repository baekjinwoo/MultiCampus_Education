package List1;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList1 {
	public static void main(String[] args) {
		String data ="d%#$^#Y&!gslgkasmndlgknsdalfa;lsjf";
		//문자 10개씩 잘라서 ArrayList 저장
		int Max=10;
		int length= data.length();
		System.out.println("문자열의 총개수"+length);
		
		//10개씩 잘라서 저장(반복)
		ArrayList<String> list =new ArrayList(1);
		for(int i=0; i<data.length();i=i+Max){
			
			//i=0(0,10), i=10(10,20), i=20(20,30), i=30(30~);
			System.out.print("i+Max="+(i+Max)+"  "); //검증코드
			if(i+Max<length){
			list.add(data.substring(i,i+Max));
			System.out.println(list.size());
			}
			else //나머지를 출력
				list.add(data.substring(i));
		}
		
		//저장을 확인
		System.out.println();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		//문자열 10개씩 잘라서 객체에 저장: list
		//ArrayList: 배열변환 메소드 : 배열리턴 => list.toArray();
	}
}
