package homework07;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

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

public class UserOutputTest
{
	public static void main(String[] args)
	{
		// �Է� ��Ʈ��(Ű����)
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String name;
		int age;
		double tall;
		System.out.println("�Է��� ���� �Ͻ÷��� ctrl + z�� �Ͻÿ�");
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/homework07/user.txt"));
			do
			{
				System.out.print("�̸��� �Է��Ͻÿ�: ");	name = br.readLine();
				System.out.print("���̸� �Է��Ͻÿ�: ");	age = Integer.parseInt(br.readLine());
				System.out.print("������ �Է��Ͻÿ�: ");	tall = Double.parseDouble(br.readLine());
				oos.writeObject(new User(name, age, tall));

				System.out.print("��� �Է��Ϸ��� EnterŰ�� �����ÿ�");
				System.in.read();
			} while (System.in.read() != -1);
			oos.close();
			System.out.println("\n user.txt ������ ����Ǿ����ϴ�");
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
