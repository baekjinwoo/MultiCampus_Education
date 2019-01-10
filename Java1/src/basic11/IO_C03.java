package basic11;

import java.io.FileInputStream;

public class IO_C03 {
	public static void main(String[] args) throws Exception {
		int n;
	//1. byte기반일 경우 읽기 (입)
		FileInputStream fis = new FileInputStream(args[0]);// ./aa.txt
		while((n=fis.available())>0){
			//읽어올 수 있는 바이트 수가 0바이트 이상이면~~()안에 30을 넣어도되고 바이트의 범위는 상관무
			byte[] b=new byte[n]; //바이트의 개수만큼 배열이 만들어지고
			//System.out.println(n);
			int result=fis.read(b); //b크기만큼 읽어온다는 의미로 쓰일뿐이다
			//System.out.println(reesult);
			if(result==-1) //만약 배열에 수가 없어 음수면 break;
				break;
			String s=new String(b);
			System.out.println(s);
			System.out.println("잠깐만요~출력하고갈꼐요");
		}
		fis.close();
	}
}
