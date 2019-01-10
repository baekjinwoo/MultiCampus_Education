package UdpIp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args) {
		final int PORT=8000;
		String server_ip,msg;
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps=new PrintStream(System.out);
		
		try{
			ps.print("접속할 Server IP:");  server_ip=br.readLine();
			while(true)
			{
				ps.print("\n전송할 메세지:"); msg=br.readLine();
				
				DatagramSocket ds=new DatagramSocket();
				InetAddress ip=InetAddress.getByName(server_ip);
				byte []buf=msg.getBytes();
				
				DatagramPacket dp       //데이타, 길이, 주소, 포트번호
				           = new DatagramPacket(buf, buf.length,ip,PORT);
				ds.send(dp); //데이터 전송
				ps.print(server_ip + "에 메세지 전송 성공");
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				br.close();
				ps.close();
			}catch(IOException e){}
		}
	}
}

















