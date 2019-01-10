package homework07;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/*[����4] �Ʒ��� ���� ���� ������� �ϼ��Ͻÿ�

���ϸ� : User.java
���ϸ� : UserOutputTest.java
[����] 
1. ����Ÿ�� ��� �߰� �ǵ��� �ϼ��Ͻÿ�
2. ��ü ����ȭ�� �̿� �Ͻÿ�

�Է��� �����Ͻ÷��� ctrl+z�� �Ͻÿ�
Enter your name : ������
Enter your age :  22 
Enter your tall :  165.2
��� �Է��Ϸ��� EnterŰ�� �����ÿ�

user.txt������ ���� �Ǿ����ϴ�
==============================================
���ϸ� : UserInputTest.java

[��°��]
�̸� : ��ȣ��   ���� : 22   Ű : 165.2

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
