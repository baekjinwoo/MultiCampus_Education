package basic10;

import java.util.*;

public class HashMapGeneric {
	public static void main(String[] args) {
		Map map0=new HashMap(); //타이틀 키를 주고 내용은 자바프로그램
		HashMap map=new HashMap();
	//1. HashMap사용하기
	// (key,value)를 사용해서 빠른검색
	// System.out.println(map.size());
	// put
		map.put("title","자바프로그래밍");
		map.put("name","이자바");
		map.put("publish","멀티캠퍼스");
		map.put("date",new Date());
	//get
			
		System.out.println(map.get("title"));
		System.out.println("Name:"+map.get("name").toString());
		System.out.println("Published by:"+map.get("publish").toString());
		System.out.println("Date:"+map.get("date").toString());
		
		map.remove("date"); //삭제
		map.put("title", "JSP프로그래밍");//수정
		System.out.println();
			
	//2. 제네릭을 이용해서 작성해보자
		HashMap <Integer,String> hm1= new HashMap <Integer,String>(); 
		//key: 정수만 (Integer)
		//value: 문자열만 (String)
		
		System.out.println(hm1.size());//0
		System.out.println();
			
		//제네릭에 맞게 자료 입력하기
					//k			 //v
		hm1.put(new Integer(10), "멋쟁이");
		hm1.put(new Integer(300), "공주");
		hm1.put(new Integer(20), "왕자");
		
		//출력
		System.out.println(hm1); //전체 출력
		System.out.println(hm1.get(10)); //value값 출력
		System.out.println(hm1.get(20));	
		System.out.println(hm1.get(300));
			
		//key만 모음 출력 : keyset();
		Set <Integer> s1=hm1.keySet();
		System.out.println(s1);
		
		//value만 모음 출력: values();
		Collection <String> v1=hm1.values();
		System.out.println(v1); // == System.out.println(hm1.values()); 
		System.out.println();

	}
}
