package file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTest {
	public static void main(String[] args) throws IOException {
		File file=new File("storage/data3.txt");
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
		
		byte[] buf=new byte[(int)file.length()];
		bis.read(buf, 0, buf.length);
		
		System.out.println(new String(buf));
		bis.close();
		
		//------------------------------------------------------------
/*		//FileReader reader=new FileReader("storage/data3.txt");
		File file=new File("storage/data3.txt");
		Reader reader=new FileReader(file);
		
		int ch;
		while((ch=reader.read()) != -1)
		{
			System.out.print((char)ch);
		}
		reader.close();*/
	}

}

















