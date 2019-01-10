package homework;

import java.io.*;
import java.net.*;
import java.util.Scanner;

//***** TcpIP 1:1채팅, 1:1이니까 서버가 클라이언트역할도 한다. (클라이언트인 척)*****
//******************서버먼저 실행하고 client를 실행한다**********************
//TCPIP를 이용한 소켓통신, 에코통신과의 차이는 Thread를 이용한 1;1채팅이다.
public class TcpIpServer5 {  
	public static void main(String[] args) {

		ServerSocket serverSocket=null;	//서버소켓을 생성
		Socket socket=null; //소켓을 생성
		
		try{
			//서버소켓을 생성하여 7777번 포트와 결합
			serverSocket= new ServerSocket(7777);	//서버소켓에 포트 7777를 연결해서 클라이언트에게 연결요청한다.
			System.out.println("서버가 준비되었습니다.");
			
			socket=serverSocket.accept(); //클라이언트와 서버의 소켓이 (같은 포트로) 연결.
			
			Sender sender= new Sender(socket);  	  //sender 객체생성
			Receiver receiver= new Receiver(socket); //receiver 객체생성
													//밑에서 쓰레드 개념으로 쓰이기 때문에 만들어준다.
			sender.start();	//실행
			receiver.start();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

class Sender extends Thread{
	Socket socket;
	DataOutputStream out; //문자기반은 FileOutputStream은 10->10인데, 1byte기반이라서 2진수로 처리되기때문에 명시해줘야한다. 
	String name;
	
	Sender(Socket socket){
		this.socket=socket;
		try{
			out=new DataOutputStream(socket.getOutputStream());   //출력통로 //소켓에서 출력스트림으로 얻은 것을 데이터기반으로 저장하고 
			name="["+socket.getInetAddress()+":"+socket.getPort()+"]"; //입력통로 //Ip주소와 포트를 저장하고
		}
		catch(IOException e){}
	}
	public void run(){ //보내는 동안은 Thread니까 Receiver가 작동하지 않는다.
		Scanner scanner= new Scanner(System.in); //보낼 값을 입력
		while(out!=null){ //그 보낼값이 비어있지 않다면 
			try{
				out.writeUTF(name+scanner.nextLine()); //입력한 내용을 읽어서 문자열로 처리한걸 확 보낸다
			}
			catch(IOException e){} 
			}
		}
}


class Receiver extends Thread{
	Socket socket;
	DataInputStream in;
	
	Receiver(Socket socket){
		this.socket= socket;
		try{
			in=new DataInputStream(socket.getInputStream()); //소켓에서 입력스트림을 통해 얻은 값을 데이터기반으로 저장한다
		}
		catch(IOException e){}
		}
	public void run(){
		while(in!=null){//들어온 값이 비어있지 않으면
			try{
				System.out.println(in.readUTF()); //들어온 값을 문자열로 처리해서 출력하시오
			}
			catch(IOException e){}
				}
		}
}
