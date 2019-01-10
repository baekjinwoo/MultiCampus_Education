package homework07;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

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

public class UserOutputTest
{
	public static void main(String[] args)
	{
		// 입력 스트림(키보드)
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String name;
		int age;
		double tall;
		System.out.println("입력을 종료 하시려면 ctrl + z를 하시오");
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/homework07/user.txt"));
			do
			{
				System.out.print("이름을 입력하시오: ");	name = br.readLine();
				System.out.print("나이를 입력하시오: ");	age = Integer.parseInt(br.readLine());
				System.out.print("신장을 입력하시오: ");	tall = Double.parseDouble(br.readLine());
				oos.writeObject(new User(name, age, tall));

				System.out.print("계속 입력하려면 Enter키를 누르시오");
				System.in.read();
			} while (System.in.read() != -1);
			oos.close();
			System.out.println("\n user.txt 파일이 저장되었습니다");
		}catch (IOException e)	{
			e.printStackTrace();
		}finally{
			try	{
				br.close();
				isr.close();
			}catch (IOException e){}
		}
	}
}
