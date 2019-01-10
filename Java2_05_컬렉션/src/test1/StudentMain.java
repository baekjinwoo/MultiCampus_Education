package test1;

import java.util.Arrays;

class Student implements Comparable<Student>{
	private String name;
	private int num;
	private double score;
	
	public Student() {
		super();
	}
	public Student(String name, int num, double score) {
		super();
		this.name = name;
		this.num = num;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name+" "+num+" "+score;
	}
	@Override
	public int compareTo(Student o) {
		return Integer.compare(o.num, this.num);
	} 		//this가 앞에 있으면 오름차순,
			//this가 뒤에 있으면 내림차순
}

public class StudentMain {
	public static void main(String[] args) {
		Student[] s=new Student[5];
		s[0]=new Student("Dave",20170301, 4.5);
		s[1]=new Student("Amie",20160301, 3.5);
		s[2]=new Student("Emma",20180301, 2.5);
		s[3]=new Student("Brad",20150301, 4.5);
		s[4]=new Student("Cara",20150302, 3.8);
		
		Arrays.sort(s); //정렬 //기본형객체는 sort가 가능하지만 우리가만든 객체는 sort가 안되기때문에 comparable를 implements해야한다.
		for(int i=0;i<s.length;i++){
			System.out.println(s[i].toString()); //toString생략가능
		}
	}
}
