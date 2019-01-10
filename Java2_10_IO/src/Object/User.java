package Object;

import java.io.Serializable;

//생성자2개, disp():void추가
public class User implements Serializable { //객체직렬화(한줄만 써주면 된다.)
	
	private String name;
	private int age;
	private double score;
	
	public User(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	public User() {
		super();
	}
	
	public void disp(){
		System.out.print("이름: "+name);
		System.out.print("\t나이: "+age);
		System.out.print("\t점수: "+score);
		System.out.println();
	}
	
}
