package basic10;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.*;

//1. Vector와 ArrayList중 ArrayList를 써라
public class Vector01 extends Vector{//Vector는 ArrayList와 같은 가변길이배열이다.
	public Vector01(int i){
		super(i);
	}

	public static void main(String[] args) {
		Vector01 v1=new Vector01(2); //v1은 가변길이배열. 2칸은 의미없다. 왜냐하면 아래와같이 치면 배열이 늘어나니까
		v1.addElement(new Integer(10));
		v1.addElement(new Double(10.0));
		v1.addElement(new String("자바"));
		v1.addElement(new String("굳-드"));
		//시작위치v1에 3칸으로 10, 10.0, 자바가 들어있다.
		System.out.println("3개 삽입후의 현재요소의 수는"+v1.elementCount);
		
		if( v1.contains("자바")){
			System.out.println("\"자바\"스트링은"+v1.indexOf("자바"));
			System.out.println(" 번째 인덱스에 존재한다");
		}
		
		System.out.println("1번째 인덱스의 요소는"+ v1.elementAt(1));
		
		for(int i=0;i<v1.size();i++){
			System.out.println(i+"번째 요소는"+v1.elementAt(i));
		}
		
		ArrayList a1=new ArrayList();
		//순서가 있는 가변길이 배열
		a1.add(30);
		a1.add("나무");
		System.out.println(a1.get(0));
		System.out.println(a1.get(1));
	
//2. 배열과 컬렉션의 장점만 가져온게 지네릭스
		List a2=new ArrayList(); //List는 조상.
		ArrayList <String>arr1=new ArrayList<String>(); //오직 문자열만
		System.out.println(arr1.size()); //0
		arr1.add("빵");
		arr1.add("라면");
		arr1.add("우유");
		arr1.add("김밥");
		
		//수정
		arr1.set(1, "과자"); //1번에 들어있는 라면-> 과자
		arr1.set(2, "사과"); //2번에 들어있는 우유-> 사과
		
		//삭제
		arr1.remove(2); //사과 삭제 (번지수로)
		arr1.remove("과자"); //빵 삭제 (내용으로)
		
		//출력
		for(int i=0;i<arr1.size();i++){
			System.out.println(arr1.get(i)); //배열을 통해 출력
			
			
		}
	}
}
