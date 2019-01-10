package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class hm33 {
	public static void main(String[] args) throws IOException {
	//문제. 파일 swap만들기 (파일 두개를 만들어서 맞바꾸기)
			BufferedReader a11= new BufferedReader(new FileReader("C:\\mun1.txt"));
			
			BufferedReader b22= new BufferedReader(new FileReader("C:\\mun2.txt"));

			BufferedReader c22= new BufferedReader(new FileReader("C:\\mmm.txt"));
			
			PrintWriter c1=new PrintWriter (new BufferedWriter(new FileWriter("c:\\mmm.txt")),true);
			

			
			
			String s1=null;
			
			
			
			
			
			while((s1=a11.readLine())!=null)
				c1.println(s1); // 임시방
				
			PrintWriter c2=new PrintWriter (new BufferedWriter(new FileWriter("c:\\mun1.txt")),true);
			
			while((s1=b22.readLine())!=null)
				c2.println(s1);
			
			PrintWriter c3=new PrintWriter (new BufferedWriter(new FileWriter("c:\\mun2.txt")),true);
			while((s1=c22.readLine())!=null)
				c3.println(s1);
			
			a11.close(); b22.close(); c22.close(); c1.close(); c2.close(); c3.close();
	}
}
