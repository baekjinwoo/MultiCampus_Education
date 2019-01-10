package HomeworkEx;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*[문제1] 다음 조건에 맞게 프로그램을 완성하시오

1. score.txt파일을 읽어서 화면에 출력한다
2. 이름, 국어,영어,수학 점수를 읽어서 총점과 평균을 구하시오
3. 파일명 : ScoreTest.java
  
4. 출력화면
이름 : 홍길동    총점 : 221   평균 : 73.66
이름 : 이순신    총점 : 216   평균 :  72.00 
*/

public class ScoreTest {
	public static void main(String[] args) throws IOException {
		// 작성된 txt파일을 콘솔창에 불러오기는 FileInputStream
		// txt파일에 내용을 저장하려면 FileOutputStream
		
	InputStreamReader is=new FileReader("src/HomeworkEx/score.txt");
		
		int readData;
		while(true){
			readData=is.read();    //byte로 읽는다, 한글 안 깨짐
			if(readData == -1)     // -1 : 데이타의 끝
				break;   
			System.out.print((char)readData);
			//Thread.sleep(100);    
		}
		is.close();
	}
}
