package test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
	private String name;
	private int tot;

	public Student(String name, int tot) {
		this.name = name;
		this.tot = tot;
	}

	public String getName() {
		return name;
	}

	public int getTot() {
		return tot;
	}
}

public class LambdaEx9 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		list.add(new Student("kim",100));
		list.add(new Student("park",60));
		list.add(new Student("lee",70));
		list.add(new Student("hong",100));
		list.add(new Student("kang",90));
		
		System.out.println("********정렬 전********");
		list.forEach(
				m -> System.out.println(m.getName()+"\t"+m.getTot())
				);
		
		
		System.out.println("********정렬 후********");

/*		Collections.sort(list,new Comparator<Student>(){
			@Override
			public int compare(Student o1, Student o2) {
				return o2.getName().compareTo(o1.getName());
			}
		}); */


		//위 이름 정렬식을 람다로 바꾸었습니다.
		Collections.sort (list, (o1,o2) -> {return o1.getName().compareTo(o2.getName());
		
		});
		
		list.forEach(
				m -> System.out.println(m.getName()+"\t"+m.getTot())
				);

	}
}
