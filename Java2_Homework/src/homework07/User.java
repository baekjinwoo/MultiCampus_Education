package homework07;

import java.io.Serializable;

/*[문제4] 아래와 같이 파일 입출력을 완성하시오

파일명 : User.java
파일명 : UserOutputTest.java
[조건] 
1. 데이타가 계속 추가 되도록 완성하시오
2. 객체 직렬화를 이용 하시오

입력을 종료하시려면 ctrl+z를 하시오
Enter your name : 개나리
Enter your age :  22 
Enter your tall :  165.2
계속 입력하려면 Enter키를 누르시오

user.txt파일이 저장 되었습니다
==============================================
파일명 : UserInputTest.java

[출력결과]
이름 : 강호동   나이 : 22   키 : 165.2

*/

public class User implements Serializable 
{
	private String name;
	private int age;
	private double tall;
	
	public User() {
		super();
	}
	public User(String name, int age, double tall) {
		super();
		this.name = name;
		this.age = age;
		this.tall = tall;
	}
	@Override
	public String toString() {
		return "이름 : " + name +"\t나이 : " + age +"\t키 : "+tall +"\n";
	}	
}
