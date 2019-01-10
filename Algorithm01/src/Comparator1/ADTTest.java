package Comparator1;

import java.util.Arrays;

class ADTClass1 implements java.util.Comparator<Integer>{

	//{1, 100, 56, 78, 9}
	//(1-100) (1-56) .... 오름차순
	//(100-1) (56-1) .... 내림차순
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1-o2;
	  //return o2-o1;
		//음수(o1:작은값, o2:큰값), 0, 양수(o1:큰값, o2:작은값)
	}
}



//class ADTClass2 implements java.util.Comparator<String>{
//
//	//{1, 100, 56, 78, 9}
//	@Override
//	public String compare(String s1, String s2) {
//		return null;
//	}
//}



public class ADTTest {
	public static void main(String[] args) {
		Integer [] array = {999,100,56,78,9};
		//(999-100) (999-56) 오름차순
		//(100-999) (56-999) ... 내림차순
		for(Integer i: array){
			System.out.print(i+"  ");
		}
		System.out.println();
		Arrays.sort(array,new ADTClass1()); //Arrays.sort(정렬배열, 정렬기준객체); sort가 알아서메서드를 호출한다
		System.out.println("--------정렬 이후 ------- \n-----자료형 위아래 일치-----");

		
		for(Integer i:array){
			System.out.print(i+"  ");
		}
		
		
		
		
		
		
	}
}
