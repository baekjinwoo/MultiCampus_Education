package HomeworkEx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Scanner;

/*[문제3] 데이타를 입력받아 파일에 기록하시오

3-1) 값을 입력받아 파일로 출력하는 프로그램
파일명 : EmpOutputTest.java
처리조건 : 데이타들 사이에 \t를 추가하여 저장하시오
           ex) name+"\t"+dept+"\t"+salary+"\n"


입력을 종료하시려면 ctrl+z를 하시오
이름을 입력하시오 : 강호동
부서를 입력하시오 : 개발부
급여를 입력하시오 : 1500000
계속 입력하려면 Enter키를 누르시오

이름을 입력하시오 : 이순신
부서를 입력하시오 : 영업부
급여를 입력하시오 : 2500000
계속 입력하려면 Enter키를 누르시오
ctrl+z

emp.txt파일이 저장 되었습니다*/

/* BufferedReader(new InputStreamReader(System.in)    //표준입력
 * BufferedWriter(new FileWriter(new File("파일명")))   //파일출력 
 */

public class EmpOutputTest {
	public static void main(String[] args) throws IOException {
		// 출력 스트림(파일)
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/HomeworkEx/emp.txt")));
		FileOutputStream out = new FileOutputStream("src/HomeworkEx/emp.txt");

		// 입력 스트림(키보드)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int salary3;
		String name3, dept3;

/*		String name1 = "강호동";
		String dept1 = "개발부";
		int salary1 = 1500000;

		String name2 = "이순신";
		String dept2 = "영업부";
		int salary2 = 2500000;

		PrintStream ob1 = new PrintStream(out);
		ob1.printf("\n\n   %s \t\t %s \t\t %d", name1, dept1, salary1);
		ob1.printf("\n\n   %s \t\t %s \t\t %d", name2, dept2, salary2);
*/
		String name, dept;
		int salary;

		System.out.println("입력을 종료하려면 CTRL+Z를 하시오\n");
		try {
			do {
				System.out.print("이름을 입력하시오:");
				name = br.readLine();
				System.out.print("부서를 입력하시오:");
				dept = br.readLine();
				System.out.print("급여를 입력하시오:");
				salary = Integer.parseInt(br.readLine());

				bw.write(name + "\t" + dept + "\t" + salary + "\n");
				System.out.println("계속 입력하려면 Enter키를 누르시오");
				System.in.read(); // \n을 처리
			} while (System.in.read() != -1);
			System.out.println("emp.txt파일로 저장 되었습니다");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
			}
		}
	}
}
