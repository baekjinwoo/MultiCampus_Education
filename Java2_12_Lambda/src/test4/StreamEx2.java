package test4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Student{
	String name;
	int tot;
	
	public Student() {
		super();
	}

	public Student(String name, int tot) {
		this.name = name;
		this.tot = tot;
	}

	@Override
	public String toString() {
		return "이름: " + name + " 점수: " + tot;
	}
}



public class StreamEx2 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("kim",90));
		list.add(new Student("park",100));
		list.add(new Student("kim",60));
		list.add(new Student("jun",65));
		list.add(new Student("cok",80));
		list.add(new Student("ham",75));
		list.add(new Student("lo",100));
		
		
		//객체중에 점수가 80점 이상인 학생만 출력(1)
		Stream<Student> rs 
				= list.stream()
					  .filter(s-> s.tot >= 80);
		rs.forEach(m->System.out.println(m.toString()));
		System.out.println("======구분선======");

		
		//(2)
		list.stream().filter(s -> s.tot < 80)
					 .forEach(System.out::println);
		System.out.println("======구분선======");
		

		// 앞에서부터 3사람까지만 출력
		list.stream()	//filter는 개인선호
					 .limit(3)
					 .forEach(System.out::println);
		
	}
}
