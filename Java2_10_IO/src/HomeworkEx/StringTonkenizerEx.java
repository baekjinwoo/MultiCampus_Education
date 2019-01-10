package HomeworkEx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*3-2) emp.txt파일을 읽어서 출력하시오
파일명 : EmpInputTest.java
처리조건 : StringTokenizer을 이용해서 데이타를 파싱하여 
            아래와 같이출력하시오

[출력결과]
이름 : 강호동   부서 : 개발부   급여 150000
이름 : 이순신   부서 : 영업부   급여 250000*/

public class StringTonkenizerEx {
	public static void main(String[] args) throws IOException {
		//String str="학교,집,학원#게임방$도서관,술집";
		//StringTokenizer token=new StringTokenizer(str,",#$");
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br=new BufferedReader(new FileReader("src/HomeworkEx/emp.txt"));
		
		String str="   이름    \t부서    \t급여";
		StringTokenizer token=new StringTokenizer(str,"\t");
		
		System.out.println("파싱된 문자열의 수:" + token.countTokens()+"개");
		int readData;
		
		while(token.hasMoreTokens())
		{
			System.out.print(token.nextToken()+"\t\t");
		}
		while(true){
			readData=br.read();    
			if(readData == -1)     
			break;  
			System.out.println();
			System.out.println(br.readLine());
		}
		
		br.close();
	}
}
