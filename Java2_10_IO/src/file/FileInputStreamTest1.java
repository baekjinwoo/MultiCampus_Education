package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputStreamTest1 {
	public static void main(String[] args) throws IOException, InterruptedException {
	/*	InputStreamReader is=new FileReader("src/file/data1.txt");
		BufferedReader br=new BufferedReader(is);
		
		String str;
		while((str=br.readLine()) != null)
		{
			System.out.println(str);
			
		}
		br.close();
		is.close();*/
		
		//--------------------------------------------------------------------------
		InputStreamReader is=new FileReader("src/file/data1.txt");
		
		int readData;
		while(true){
			readData=is.read();    //byte로 읽는다, 한글 안 깨짐
			if(readData == -1)     // -1 : 데이타의 끝
				break;   
			System.out.print((char)readData);
			Thread.sleep(100);    
		}
		is.close();
		//-------------------------------------------------------------------------
/*		InputStream is=new FileInputStream("src/file/data1.txt");
		
		int readData;
		while(true){
			readData=is.read();    //byte로 읽는다, 한글깨짐
			if(readData == -1)     // -1 : 데이타의 끝
				break;   
			System.out.print((char)readData);
			Thread.sleep(100);  //  1/1000초
		}
		is.close(); */
	}  
}



