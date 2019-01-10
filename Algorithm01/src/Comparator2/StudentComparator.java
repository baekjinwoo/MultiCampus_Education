package Comparator2;

import java.util.Comparator;


public class StudentComparator implements Comparator<Student> {

	
/*	@Override
	public int compare(Student o1, Student o2) {
		return o1.getId() - o2.getId();
		
		//공식처럼 외워도 된다. 원리는 ADTest.java를 다시 보고오자.
		//(o1)앞-(o2)뒤 (오름차순) :작은거부터 정렬
		//(o2)뒤-(o1)앞 (내림차순) :큰거부터 정렬
	}*/

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getName().compareTo(o2.getName());
		//앞.compareTo(뒤) (오름차순) :ㄱ ㄴ ㄷ 순으로 정렬
		//뒤.compareTo(앞) (내림차순) :ㅎ ㅌ ㅊ 순으로 정렬
	}
}
