package file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/*
 * $CopyFile storage/data3.txt  ==>  storage/data100.txt로 복사
 * 
 * data100.txt파일로 복사되었습니다.
 * 
 * args로 인자를 받는다
 * 
 * 
 * */

public class CopyFile {
	public static void main(String[] args) {

		String file1 = args[0];
		String file2 = args[1];

		try {
			File file = new File(file1);
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));

			byte[] buf = new byte[(int) file.length()];
			in.read(buf, 0, buf.length);
			// System.out.println(new String(buf));

			// 복사
			FileWriter fw = new FileWriter(file2);
			fw.write(new String(buf));
			System.out.println(file2+"로 복사되었습니다");
			
			fw.close();
			in.close();
			fis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
