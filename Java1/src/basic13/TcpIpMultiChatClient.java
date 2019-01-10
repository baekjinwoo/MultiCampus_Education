package basic13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

//1-2. 다중채팅 //Client
public class TcpIpMultiChatClient {
	public static void main(String[] args) {
		if(args.length!=3){
			System.out.println("USAGE: java TcpIpMultichatClient ip주소 port 대화명"); //ip는[0] port는 [1] 대화명[2]
			System.exit(0);
		}
		try{
			String serverIp=args[0]; //ip주소가 들어가는 자리
			//String serverIp="127.0.0.1";
			//소켓을 생상하여 연결을 요청한다.
									 //서버주소		//포트번호
			Socket socket=new Socket(serverIp,Integer.parseInt(args[1])); //소켓에 서버주소와 포트번호를 저장
			System.out.println("서버에 연결되었습니다.");
			
															 //대화명
			Thread sender= new Thread(new ClientSender(socket,args[2]));//Thread를 이용한sender는 ClientSender를 생성해서 소켓을 넣는다. //sender는 보낼때 대화명도 같이 간다
			Thread receiver= new Thread(new ClientReceiver(socket)); //Thread를 이용한receiver는 ClientReceiver를 생성해서 소켓을 넣는다.
			receiver.start(); //receiver를 실행한다
			sender.start();   // sender를 실행한다
		}
		catch(ConnectException ce){
			ce.printStackTrace();
		}
		catch(Exception e){}
	}// main-end
	
static class ClientSender extends Thread{ //ClientSender 클래스 생성
	Socket socket;
	DataOutputStream out; //출력스트림
	String name;
	
	ClientSender(Socket socket, String name){ //생성자 생성
		this.socket=socket;
		try{
			out=new DataOutputStream(socket.getOutputStream()); //소켓의 출력스트림에서 얻은 값을 새로 저장한다
			this.name=name;
		} catch(Exception e){}
	} 
	
	public void run(){ //send에 대한 run()
		Scanner scanner= new Scanner(System.in); //스캐너를 통한 입력문
		try{
			if(out!=null){ //값이 들어온다면 (=들어온 값이 빈공간이 아니라면)
				out.writeUTF(name); //out에 들어온 값name을 문자로 반환          
			}
			while(out!=null){
				out.writeUTF("["+name+"]"+scanner.nextLine()); //스캐너를 통해서 값을 입력.
			}//[홍길동] 방가방가
		} catch(IOException e) {}
	}//run()-end
}// CLientSender-class end

static class ClientReceiver extends Thread{ //ClientReceiver 서버가 뿌려주는 부분을 받는 클래스
	Socket socket;
	DataInputStream in;
	
	ClientReceiver(Socket socket){
		this.socket=socket;
		try{
			in=new DataInputStream(socket.getInputStream()); //소켓의 입력스트림에서 얻은 값을 새로 저장한다
		} catch(IOException e){}
	}
	public void run(){ //서버가 보내주면
		while(in!=null){//저장된 값이 있다면(=저장되있는 값이 null이 아니라면)
			try{
				System.out.println(in.readUTF());
			} catch(IOException e){}
		}//while-end
	}//run-end
}// ClientReceiver-end

}
