package protocol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProtocolClient {
	Socket sock = null;
	BufferedReader br = null;
	BufferedReader keyboard=null;
	BufferedWriter bw = null;
	
	public ProtocolClient(){
		try{
			sock=new Socket("127.0.0.1", 7000); //소켓을 생성하는데, 로컬호스트의 7000포트에서 실행할 것이다
			
		}catch(UnknownHostException e){
			System.out.println("서버를 찾을수 없습니다");
			System.exit(0);
		}catch(IOException e){
			System.out.println("서버와 연결 할수 없습니다");
			System.exit(0);
		}
		//-------------------------------------------------------------
		try{
			//keyboard와 연결된 스트림
			keyboard=new BufferedReader(new InputStreamReader(System.in));
			
			//sock로 부터 stream생성
			br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
			bw=new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			while(true)
			{
				//메세지를 받아서 서버로 전송하기-----------------------------
				System.out.println("ex)100:아이디(입장),  200:아이디(퇴장),  300:아이디:메세지(대화),  400:아이디1:아이디2:메세지(귓속말)");
				System.out.print("메세지를 입력하시오 : ");
				
				String msg=keyboard.readLine();
				bw.write(msg + "\n");
				bw.flush();
			}
		}catch(IOException e){
			System.out.println("서버와 연결이 끊어짐");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new ProtocolClient();
	}
}







