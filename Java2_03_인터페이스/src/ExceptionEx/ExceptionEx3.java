package ExceptionEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//checked exception //try catch는 못할 거 같으면 해보다가 보고하지말고 그냥 알아서 포기하라는 것 : 사원한테 아무런 상관없음
public class ExceptionEx3 {
	String str;
	
	public ExceptionEx3(){
		Input();
	}

	public void Input() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("문자열입력:");
		try{
		str=br.readLine();
		}catch(IOException e){}
	}							//BufferedReader안에 ReadLine이란 함수가 있는대 이 함수를 쓰기위해 쓰는 거다. 한문장씩 읽고 앤터하는 기능
	public void output(){
		
		System.out.println("출력: "+ str);
	}
	
	public static void main(String[] args){
		new ExceptionEx3().output();
	}
}



/*//checked exception //throws는 상사의 권한하에 사원이 해보다가 안될거같으니까 위에서 하지말라고 보고내려오는 것: 사원 개고생
public class ExceptionEx3 {
	String str;
	
	public ExceptionEx3() throws IOException{
		Input();
	}

	public void Input() throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("문자열입력:");
		str=br.readLine();
	}							//BufferedReader안에 ReadLine이란 함수가 있는대 이 함수를 쓰기위해 쓰는 거다. 한문장씩 읽고 앤터하는 기능
	public void output(){
		
		System.out.println("출력: "+ str);
	}
	
	public static void main(String[] args) throws IOException {
		new ExceptionEx3().output();
	}
}
*/