package homework07;

import java.io.Serializable;

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
		return "�̸� : " + name +"\t���� : " + age +"\tŰ : "+tall +"\n";
	}	
}
