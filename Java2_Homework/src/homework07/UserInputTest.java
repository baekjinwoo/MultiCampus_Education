package homework07;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

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

public class UserInputTest
{
	public static void main(String[] args)
	{
		try	{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/homework07/user.txt"));
			User user;
			while (true)
			{
				try {
					user = (User)ois.readObject();
					System.out.println(user.toString());
				} catch(EOFException e) {
					break;
				}
			}
			ois.close();
		}catch (FileNotFoundException e)	{
			e.printStackTrace();
		}catch (IOException e){			
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
