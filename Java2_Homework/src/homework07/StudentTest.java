package homework07;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*[����5] 
student.dat������ �о�鿩 ����Ÿ�� �������� 
backup.dat���Ϸ� ����Ͻÿ�

�Է����ϸ� : student.dat
������ϸ� : backup.dat

[1]������Ʈ�� : StudentTest
���ϸ� : StudentTest.java  --main
         Student.java
             -name:String   -kor:int   -eng:int   -mat:int
             +Student()
             +Student(name:String,kor:int,eng:int,mat:int)
             +setter&getter
                 
[2]����
1. ���� ������Ʈ���� student.dat ���� ���� �Է� �޾�
    ���л��� �� ���� ���� ����� ���Ѵ�
2. FileReader, FileWriter , Scanner�� �̿��ص� �Ʒ��� ���� �ڵ� �ص� ������
   (����)
        FileReader fr = new FileReader("src/test5/student.dat");
		FileWriter fw = new FileWriter("src/test5/backup.dat", true);
		Scanner sfi = new Scanner(fr);

		while (sfi.hasNextLine() == true) { // End of File
		}
		
3. ������(StringTokenizer)�� �и��ؼ� Student ��ü�� ��������
    ArrayList��ü�� �߰� �Ѵ� 
4. 5���� Student�� kor�� ����/��� 
5. 5���� Student�� eng�� ����/��� 
6. 5���� Student�� math�� ����/��� 
7. ���л��� = student ��ü ���� 

[3]������� - backup.dat
�Ʒ� ����ó�� ��� ������ ����ÿ�
===========================
���л��� =5��
���� ���� = 423 ���� ���= 84
���� ���� = 411 ���� ���= 82
���� ���� = 462 ���� ���= 92
===========================

[4]ȭ�����
backup.dat������ �����Ǿ����ϴ�
*/

//���� �ڵ带 �����Ͽ� ���α׷��� �ϼ��Ͻÿ�
class Student {
	// private name,kor,eng,math ����, ������, set/get
	private String name;
	private int kor;
	private int eng;
	private int math;

	public Student() {
		super();
	}

	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
}

public class StudentTest {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src/homework07/student.dat");
		FileWriter fw = new FileWriter("src/homework07/backup.dat", true);
		Scanner sfi = new Scanner(fr);

		List<Student> list = new ArrayList<Student>();

		while (sfi.hasNextLine() == true) { // End of File
			// StringTokenizer�� �и��Ͽ� list��ü�� �߰��ϱ�
			String line = sfi.nextLine();
			StringTokenizer token = new StringTokenizer(line, "/:-");

			String name = null;
			int kor = 0;
			int eng = 0;
			int math = 0;

			while (token.hasMoreTokens() == true) {
				name = token.nextToken();
				token.nextToken();				
				kor = Integer.parseInt(token.nextToken()); // ���� ����
				token.nextToken(); 				
				eng = Integer.parseInt(token.nextToken()); // ���� ����
				token.nextToken();				
				math = Integer.parseInt(token.nextToken()); // ���� ����				
				Student stu = new Student(name, kor, eng, math);
				list.add(stu);
			}
		}
		// -------------------------------------------------------------------------
		// list �� ��ü�� ���� ���� ����/��ձ��ϱ�
		int sumOfKor = 0, sumOfEng = 0, sumOfMath = 0;
		int avgOfKor = 0, avgOfEng = 0, avgOfMath = 0;
		for (int i = 0; i < list.size(); i++) {
			Student st = list.get(i);
			sumOfKor += st.getKor();
			sumOfEng += st.getEng();
			sumOfMath += st.getMath();
		}
		avgOfKor = sumOfKor / list.size();
		avgOfEng = sumOfEng / list.size();
		avgOfMath = sumOfMath / list.size();

		// -------------------------------------------------------------------------
		// backup.dat����
		// ���л��� ���Ϸ� ����ϱ�
		// �� ���� ����/��շ� ����ϱ�
		fw.write("���л��� =" + list.size() + "��" + "\n");
		fw.write("���� ���� = " + sumOfKor + " ���� ���= " + avgOfKor + "\n");
		fw.write("���� ���� = " + sumOfEng + " ���� ���= " + avgOfEng + "\n");
		fw.write("���� ���� = " + sumOfMath + " ���� ���= " + avgOfMath + "\n");
		fw.write("========================\n");

		fr.close();
		sfi.close();
		fw.close();
		System.out.println("backup.txt ������ �����Ǿ����ϴ�");
	}
}
