package homework07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*[����1] ���� ���ǿ� �°� ���α׷��� �ϼ��Ͻÿ�

1. score.txt������ �о ȭ�鿡 ����Ѵ�
2. �̸�, ����,����,���� ������ �о ������ ����� ���Ͻÿ�
3. ���ϸ� : ScoreTest.java
  
4. ���ȭ��
�̸� : ȫ�浿    ���� : 221   ��� : 73.66
�̸� : �̼���    ���� : 216   ��� :  72.00 
*/

public class ScoreTest {

	public static void main(String[] args) {
		try{
			BufferedReader bis = new BufferedReader(new FileReader("src/homework07/score.txt"));
			String name;
			int k, e, m;
	
			while (true) {
				name = bis.readLine();
				if (name == null)
					break;
				k = Integer.parseInt(bis.readLine());
				e = Integer.parseInt(bis.readLine());
				m = Integer.parseInt(bis.readLine());
	
				System.out.print("�̸� : " + name);
				System.out.print("    ���� : " + (k + e + m));
				System.out.printf("   ��� : %.2f\n" , (double)(k + e + m) / 3);	
			}
			bis.close();
		}catch(IOException e){
			e.printStackTrace();
		}

	}

}
