package homework07;

import java.util.StringTokenizer;

/*[����3-2] emp.txt������ �о ����Ͻÿ�
���ϸ� : EmpInputTest.java
ó������ : StringTokenizer�� �̿��ؼ� ����Ÿ�� �Ľ��Ͽ� 
            �Ʒ��� ��������Ͻÿ�

[��°��]
�̸� : ��ȣ��   �μ� : ���ߺ�   �޿� 150000
�̸� : �̼���   �μ� : ������   �޿� 250000


*/

public class StringTonkenizerEx {
	public static void main(String[] args) {
		//String str="�б�,��,�п�#���ӹ�$������,����";
		//StringTokenizer token=new StringTokenizer(str,",#$");
		
		String str="�б�		��	�п�		���ӹ�	������	����";
		StringTokenizer token=new StringTokenizer(str,"\t");
		
		System.out.println("�Ľ̵� ���ڿ��� ��:" + token.countTokens()+"��");
		while(token.hasMoreTokens())
		{
			System.out.println(token.nextToken());
		}
	}
}
