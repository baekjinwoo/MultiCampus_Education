package homework07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*[����2]

1. source.txt������ �о ������� desc.txt�� ����Ͻÿ�
2. ���ϸ� : ScoreTest2.java

test2/source.txt
�̼���
90
80
75
��ȣ��
76
45
88

test2/desc.txt
�̸� : �̼���      ���� : 245       ��� : 81.66
�̸� : ��ȣ��      ���� : 209       ��� : 69.66
*/

public class ScoreTest2 {

	public static void main(String[] args) {
		BufferedReader in=null;
		PrintWriter out=null;	
		
		try{
			in=new BufferedReader(new FileReader("src/homework07/source.txt"));
			out=new PrintWriter(new FileWriter("src/homework07/desc.txt"));
			
			String name;
			int kor,eng,mat;
			
			System.out.println("source.txt������ �а� �ֽ��ϴ�");
			Thread.sleep(1000);
			
			while(true)
			{
				name=in.readLine();
				if(name == null)
					break;
				kor=Integer.parseInt(in.readLine());
				eng=Integer.parseInt(in.readLine());
				mat=Integer.parseInt(in.readLine());
				
				System.out.printf("�̸� : %s  ���� : %d  ��� : %.1f\n",name, (kor+eng+mat),(double)(kor+eng+mat)/3);
				
				out.printf("�̸� : %s  ���� : %d  ��� : %.1f\n",name, (kor+eng+mat),(double)(kor+eng+mat)/3);
			}			
			Thread.sleep(1000);
			System.out.println("desc.txt������ �����Ǿ����ϴ�");
			
			in.close();
			out.close();			
		}catch(IOException e){
			e.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}		
	}
}









