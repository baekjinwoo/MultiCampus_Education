package homework07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* BufferedReader(new InputStreamReader(System.in)      //ǥ���Է�
 * 
 * BufferedWriter(new FileWriter(new File("���ϸ�")))   //������� 
 */

/*[����3-1] ����Ÿ�� �Է¹޾� ���Ͽ� ����Ͻÿ�

1) ���� �Է¹޾� ���Ϸ� ����ϴ� ���α׷�
���ϸ� : EmpOutputTest.java
ó������ : ����Ÿ�� ���̿� \t�� �߰��Ͽ� �����Ͻÿ�
           ex) name+"\t"+dept+"\t"+salary+"\n"


�Է��� �����Ͻ÷��� ctrl+z�� �Ͻÿ�
�̸��� �Է��Ͻÿ� : ��ȣ��
�μ��� �Է��Ͻÿ� : ���ߺ�
�޿��� �Է��Ͻÿ� : 1500000
��� �Է��Ϸ��� EnterŰ�� �����ÿ�

�̸��� �Է��Ͻÿ� : �̼���
�μ��� �Է��Ͻÿ� : ������
�޿��� �Է��Ͻÿ� : 2500000
��� �Է��Ϸ��� EnterŰ�� �����ÿ�
ctrl+z

emp.txt������ ���� �Ǿ����ϴ�
--------------------------------------------------------
emp.txt����
��ȣ��    ���ߺ�    1500000
�̼���    ������    2500000*/

public class EmpOutputTest {
	public static void main(String[] args) throws IOException {
		/*��� ��Ʈ��(����)*/
		File file=new File("src/homework07/emp.txt");
		//FileWriter fw=new FileWriter(file);           //==> �����Ҷ����� emp.txt������ ���� �������
		FileWriter fw=new FileWriter(file,true);        //==> �����ϸ� �������Ͽ� ���ο� ����Ÿ �߰� 
		BufferedWriter bw=new BufferedWriter(fw);
		
		/*�Է� ��Ʈ��(Ű����)*/
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		String name, dept;
		int salary;
		
		System.out.println("�Է��� �����Ϸ��� CTRL+Z�� �Ͻÿ�\n");
		try{
			do{
				System.out.print("�̸��� �Է��Ͻÿ�:"); name=br.readLine();
				System.out.print("�μ��� �Է��Ͻÿ�:"); dept=br.readLine();
				System.out.print("�޿��� �Է��Ͻÿ�:"); salary=Integer.parseInt(br.readLine());
				
				bw.write(name+"\t"+dept+"\t"+salary+"\n");
				System.out.println("��� �Է��Ϸ��� EnterŰ�� �����ÿ�");
				System.in.read();   // \n�� ó��
			}while(System.in.read() != -1);   
			System.out.println("emp.txt���Ϸ� ���� �Ǿ����ϴ�");
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				br.close();
				isr.close();
				bw.close();
				fw.close();
			}catch(IOException e){}
		}
	}
}




















