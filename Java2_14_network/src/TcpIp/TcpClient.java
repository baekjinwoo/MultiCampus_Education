package TcpIp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;

public class TcpClient {
	final static int PORT=7000;
	
	public static void main(String[] args) {
		String server_ip;
		
		//콘솔로 입력할 거다(키보드)
		BufferedReader br=new BufferedReader(
				         new InputStreamReader(System.in));
		//콘솔로 출력할 거다(모니터)
		PrintStream ps=new PrintStream(System.out);
		
		try{
			ps.print("접속할 IP를 입력하시오:");
			server_ip=br.readLine();   
		
			while(true)
			{
				Socket sock=new Socket(server_ip, PORT);  //접속시도
			
				//네트워크를 통해서 데이터 전송
				OutputStream os=sock.getOutputStream();
				BufferedWriter bw=new BufferedWriter(
						new OutputStreamWriter(os));
				ps.print("\n전송할 메세지를 입력하시오:");
				String str=br.readLine();
				
				bw.write(str, 0 ,str.length());
				bw.close();
				sock.close();
				ps.println(server_ip + "에 메세지 전송");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}




