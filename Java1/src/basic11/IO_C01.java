package basic11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//3. throws (2)
public class IO_C01 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//throws == try~catch이다. 파일은 예외처리를 필수로 해줘야한다. 소스를 줄이고싶으면 throws를 쓰면되고 (,)콤마로 내용추가가능
		//FileReader fr=new FileReader("C:/aa.txt");
		FileReader fr=new FileReader("C:/aa.txt");		
	}
}
