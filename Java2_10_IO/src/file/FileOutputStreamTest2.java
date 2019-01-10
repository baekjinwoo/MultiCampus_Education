package file;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest2 {
		public static void main(String[] args) throws IOException {
			FileOutputStream out=new FileOutputStream("src/file/data2.txt");
			int value;
			
			System.out.println("문자열을 입력하고 마지막 줄에서 CTRL+Z로 종료 하세요");
			while((value=System.in.read()) != -1)
			{
				out.write(value);
			}
			
			System.out.println("data2.txt로 저장 되었습니다");
			
			out.flush(); //버퍼 비우기
			out.close();
	}
}
