package HomeworkEx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*[문제2]

1. source.txt파일을 읽어서 결과물을 desc.txt로 출력하시오
2. 파일명 : ScoreTest2.java

test2/source.txt
강호동
80
76
65
이순신
76
65
75
이만기
90
75
88

test2/desc.txt
이름 : 강호동  총점 : 221  평균 : 73.7
이름 : 이순신  총점 : 216  평균 : 72.0
이름 : 이만기  총점 : 253  평균 : 84.3
*/

public class ScoreTest2 {
	public static void main(String[] args) throws IOException {
		//파일 복사
		//String file1= args[0]; //생략
		//String file2= args[1]; //생략
		
		try {
			BufferedReader in=new BufferedReader(new FileReader("src/HomeworkEx/source.txt"));
			PrintWriter out=new PrintWriter(new FileWriter("src/HomeworkEx/desc.txt"));

			while(true){
				String name = in.readLine();
				if(name ==null){
					break;
				}
				int kor=Integer.parseInt(in.readLine());
				int eng=Integer.parseInt(in.readLine());
				int mat=Integer.parseInt(in.readLine());
				
				System.out.printf("이름: %s  총점: %d  평균: %.1f\n",name,(kor+mat+eng),(kor+mat+eng)/3.0); //콘솔창으로 출력
				out.printf("이름: %s  총점: %d  평균: %.1f\n",name,(kor+mat+eng),(kor+mat+eng)/3.0); //desc로 복사되어 출력.
			}
			// 복사
			System.out.println("src/HomeworkEx/desc.txt"+"로 복사되었습니다");

			
			out.close();
			in.close();
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}








