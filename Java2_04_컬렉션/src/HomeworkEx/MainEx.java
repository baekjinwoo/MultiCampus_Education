package HomeworkEx;

import java.util.ArrayList;
import java.util.List;

class Student{
	String name;
	int age;
	int height;
	int weight;
	
	public Student(){
		
	}
	public Student(String name, int age, int height, int weight){
	this.name=name;
	this.age=age;
	this.height=height;
	this.weight=weight;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public int getWeight() {
		return weight;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}

class StudentView{
	public void viewStudent(Student st){
	System.out.println(st.getName()+"\t"+st.getAge()+"\t"+st.getHeight()+"\t"+st.getWeight());
	}
	public void viewStudentList(List list ){
		for(Object ob : list){
			Student st = (Student)ob;
			System.out.println(st.getName()+"\t"+st.getAge()+"\t"+st.getHeight()+"\t"+st.getWeight());
		}
	}
}

public class MainEx {
	public static void main(String[] args) {
	Student  s1 = new Student("민들래",15,170,55);
	Student  s2 = new Student("진달래",22,156,53);
	Student  s3 = new Student("개나리",19,255,47);

	System.out.println("이름\t나이\t신장\t몸무게");
	StudentView ss = new StudentView();
	ss.viewStudent(s1);
	
	System.out.println();
	ArrayList<Student> a1 = new ArrayList<Student>();
	a1.add(s1);
	a1.add(s2);
	a1.add(s3);
	ss.viewStudentList(a1);
	}
}
