package basic11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IO_C05 {
	public static void main(String[] args) throws IOException {
		/*FileReader fr1= new FileReader("C:\\aa.txt"); // aa값을 읽기 위해 open
		BufferedReader br1= new BufferedReader(fr1); //도우미 버퍼
		
		FileWriter fr2= new FileWriter("C:\\bb.txt"); // bb값을 쓰기 위해 open
		BufferedWriter br2= new BufferedWriter(fr2);
		PrintWriter pw= new PrintWriter(br2,true); //append */
		
		BufferedReader br1= 
				new BufferedReader (new FileReader("C:\\aa.txt")); //open + 도우미
		
		PrintWriter pw=
				new PrintWriter (new BufferedWriter(new FileWriter("c:\\bb.txt"))); 
									//open + 도우미  //도스명령어로쓸시, c대신 args[0],args[1]
		
		String str= null;
		while((str=br1.readLine())!=null){
			pw.println(str);
			//System.out.println("복사중");
		}
		br1.close();
		pw.close();
	}
}
