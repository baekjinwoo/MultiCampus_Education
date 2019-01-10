package IOEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamTest {
	public static void main(String[] args) throws IOException {

//		System.out.print("input string: ");
//		char ch='\0';
//		while(ch!='\n'){
//			ch=(char)System.in.read(); //한글자씩 바꿔주는 것 //(1)바이트스트림(inputStream): 한글깨짐
//			System.out.print(ch); //한글자씩 읽어서 
//			//영문, 숫자(1byte)는 아스키코드에 의해서 작성이 가능하지만 한글은 불가능
//			
//			
//		}
		
		
		
//		InputStreamReader in = new InputStreamReader(System.in);
//		System.out.print("input string: ");
//		char ch='\0';
//		while(ch!='\n'){ 
//			ch=(char)in.read(); //(2)캐릭터스트림(inputStreamReader): 한글 안깨짐 (한글2byte)
//		System.out.print(ch);
//		//하지만, 역시 while문을 돌려야되는 단점이 있다.
//		}

		
		

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		//BufferedReader br = new BufferedReader(InputStreamReader in = new InputStreamReader(System.in));
		
		System.out.print("input string: ");
			String s=br.readLine();  //보조스트림(buffered에 들어온것을 while없이 씀으로써)을 사용함으로써, 속도가 빠르다.
		System.out.print(s);
	
	}
}
