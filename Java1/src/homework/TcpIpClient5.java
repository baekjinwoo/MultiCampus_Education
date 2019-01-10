package homework;

import java.io.*;
import java.net.*;

public class TcpIpClient5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String serverIp="70.12.109.111"; //로컬 주소
			
			Socket socket = new Socket(serverIp,7780); // 새로운 소켓을 생성하여 서버에 연결을 요청한다.
			
			System.out.println("서버에 연결되었습니다."); // 서버에 연결이 되면 연결되었다고 출력한다.
			Sender sender = new Sender(socket); // 소켓의 데이터를 송신하는 쓰레드인 센더를 생성한다.
			Receiver receiver = new Receiver(socket); //  소켓의 데이터를 수신하는 쓰레드인 리시버를 생성한다.
			
			sender.start(); // 센더 쓰레드를 실행한다.
			receiver.start(); // 리시버 쓰레드를 실행한다.
		} catch (ConnectException ce) { //try에서 오류가 나면 처리한다.
			ce.printStackTrace();
		} catch(IOException ie) {
			ie.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
