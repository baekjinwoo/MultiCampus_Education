package Comparator2;

public class Student{
	private int id;
	private String name;
	private String major;
	private int grade;
	
	public Student(){
		
	}
	
	public Student(int id, String name, String major, int grade) {
		this.id = id;
		this.name = name;
		this.major = major;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public int getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", major=" + major + ", grade=" + grade + "]";
	}

	
}
