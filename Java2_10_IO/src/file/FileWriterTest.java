package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* [경로]
 * 절대경로 : 루트(root)를 기준으로 파일을 찾는다
 * 상대경로 : 현재위치를 기준으로 찾는다
 *            ./   ==> 현재위치(생략가능)
 *            ../  ==> 상위(한단계위로)
 *            /    ==> 루트(최상위:root)
 */
public class FileWriterTest {

	public static void main(String[] args) throws IOException {
		//FileWriter writer=new FileWriter("D:/IT_2015/1.JAVA/javawork/day16_IO/storage/data3.txt");
		File file=new File("storage/data3.txt");
		Writer writer=new FileWriter(file);
		
		StringBuilder str=new StringBuilder();
		str.append("동해물과 백두산이 마르고 닳도록\n");
		str.append("하느님이 보우하사 우리나라 만세\n");
		str.append("무궁화 삼천리 화려강상\n");
		str.append("대한사람 대한으로 길이 보전하세......\n");
		
		writer.write(str.toString());
		writer.close();
		System.out.println("data3.txt로 저장 되었습니다");
	}
}
















