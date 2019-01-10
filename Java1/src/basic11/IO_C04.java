package basic11;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO_C04 {
	public static void main(String[] args) throws IOException {
	//1. byte기반일 경우 작성하기 (출)
		FileOutputStream fos 
		= new FileOutputStream(args[0],true); //true는 APPEND
			System.out.println("글자입력");
		while(true){ 
			int n=System.in.available(); //한글자입력받는것
			if(n>0){
				byte[] b=new byte[n]; //한글자 입력받는것이 b배열에 하나씩 들어간다.. 평상시에 스캐너이용할것_키보드입력법
				int result = System.in.read(b);////
				if(result==-1) break; //만약 배열에 수가 없어 음수면 break;
				fos.write(b, 0, result);
				System.out.println("오해하지마~수록중야~");				
			}
		}
		fos.close();
	}
}
