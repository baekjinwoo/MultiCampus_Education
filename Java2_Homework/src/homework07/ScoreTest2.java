package homework07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*[문제2]

1. source.txt파일을 읽어서 결과물을 desc.txt로 출력하시오
2. 파일명 : ScoreTest2.java

test2/source.txt
이순신
90
80
75
강호동
76
45
88

test2/desc.txt
이름 : 이순신      총점 : 245       평균 : 81.66
이름 : 강호동      총점 : 209       평균 : 69.66
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
			
			System.out.println("source.txt파일을 읽고 있습니다");
			Thread.sleep(1000);
			
			while(true)
			{
				name=in.readLine();
				if(name == null)
					break;
				kor=Integer.parseInt(in.readLine());
				eng=Integer.parseInt(in.readLine());
				mat=Integer.parseInt(in.readLine());
				
				System.out.printf("이름 : %s  총점 : %d  평균 : %.1f\n",name, (kor+eng+mat),(double)(kor+eng+mat)/3);
				
				out.printf("이름 : %s  총점 : %d  평균 : %.1f\n",name, (kor+eng+mat),(double)(kor+eng+mat)/3);
			}			
			Thread.sleep(1000);
			System.out.println("desc.txt파일이 생성되었습니다");
			
			in.close();
			out.close();			
		}catch(IOException e){
			e.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}		
	}
}









