package homework07;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*[문제5] 
student.dat파일을 읽어들여 데이타를 가공한후 
backup.dat파일로 출력하시오

입력파일명 : student.dat
출력파일명 : backup.dat

[1]프로젝트명 : StudentTest
파일명 : StudentTest.java  --main
         Student.java
             -name:String   -kor:int   -eng:int   -mat:int
             +Student()
             +Student(name:String,kor:int,eng:int,mat:int)
             +setter&getter
                 
[2]조건
1. 현재 프로젝트에서 student.dat 파일 내용 입력 받아
    총학생수 각 과목별 총점 평균을 구한다
2. FileReader, FileWriter , Scanner를 이용해도 아래와 같이 코딩 해도 무방함
   (참고)
        FileReader fr = new FileReader("src/test5/student.dat");
		FileWriter fw = new FileWriter("src/test5/backup.dat", true);
		Scanner sfi = new Scanner(fr);

		while (sfi.hasNextLine() == true) { // End of File
		}
		
3. 구분자(StringTokenizer)로 분리해서 Student 객체로 생성한후
    ArrayList객체에 추가 한다 
4. 5명의 Student의 kor만 총합/평균 
5. 5명의 Student의 eng만 총합/평균 
6. 5명의 Student의 math만 총합/평균 
7. 총학생수 = student 객체 갯수 

[3]출력파일 - backup.dat
아래 파일처럼 출력 파일을 만드시오
===========================
총학생수 =5명
국어 총합 = 423 국어 평균= 84
영어 총합 = 411 영어 평균= 82
수학 총합 = 462 수학 평균= 92
===========================

[4]화면출력
backup.dat파일이 생성되었습니다
*/

//다음 코드를 수정하여 프로그램을 완성하시오
class Student {
	// private name,kor,eng,math 변수, 생성자, set/get
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
			// StringTokenizer로 분리하여 list객체에 추가하기
			String line = sfi.nextLine();
			StringTokenizer token = new StringTokenizer(line, "/:-");

			String name = null;
			int kor = 0;
			int eng = 0;
			int math = 0;

			while (token.hasMoreTokens() == true) {
				name = token.nextToken();
				token.nextToken();				
				kor = Integer.parseInt(token.nextToken()); // 국어 점수
				token.nextToken(); 				
				eng = Integer.parseInt(token.nextToken()); // 영어 점수
				token.nextToken();				
				math = Integer.parseInt(token.nextToken()); // 수학 점수				
				Student stu = new Student(name, kor, eng, math);
				list.add(stu);
			}
		}
		// -------------------------------------------------------------------------
		// list 각 객체의 국어 점수 총합/평균구하기
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
		// backup.dat파일
		// 총학생수 파일로 출력하기
		// 각 과목별 총합/평균로 출력하기
		fw.write("총학생수 =" + list.size() + "명" + "\n");
		fw.write("국어 총합 = " + sumOfKor + " 국어 평균= " + avgOfKor + "\n");
		fw.write("영어 총합 = " + sumOfEng + " 영어 평균= " + avgOfEng + "\n");
		fw.write("수학 총합 = " + sumOfMath + " 수학 평균= " + avgOfMath + "\n");
		fw.write("========================\n");

		fr.close();
		sfi.close();
		fw.close();
		System.out.println("backup.txt 파일이 생성되었습니다");
	}
}
