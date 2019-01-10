package basic13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

//1-1. 다중채팅_Server

public class TcpIpMultiChatServer {
		//포트번호를 넣는다
	HashMap clients; //선언
	
	TcpIpMultiChatServer(){ //생성자
		clients=new HashMap(); //객체생성
		Collections.synchronizedMap(clients); //앞전에는 키워드를 썻다면, 지금은 쓰레드메서드 (해시맵으로 만든 객체(안에 들어갈 정보)들을 동기화)
	}
	public void start(int port1){ 
		ServerSocket serverSocket=null;
		Socket socket=null;
		
		try{
			serverSocket=new ServerSocket(port1);
			System.out.println("서버가 시작되엇습니다");
							//listen개념. 
			while(true){
				socket=serverSocket.accept(); //accept단계
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+"에서 접속하셧습니다."); //확인차 출력하는 문장 (필수x, 선택문장)
				ServerReceiver thread= new ServerReceiver(socket); //thread를 통해 들어온 정보를 여러사람들에게 보여주게 보내는 작업 //?
				thread.start();
			}// while-true
			
		}catch(Exception e){
			e.printStackTrace();
		} 
	} //start();
	
	void sendToAll(String msg){ //메시지가 넘어오면 
		Iterator it = clients.keySet().iterator(); //clients의 key값만 it에 저장 //여기서 key는 name
		
		while(it.hasNext()){ //it의 정보를 찾아보고 있으면
			try{
				DataOutputStream out=(DataOutputStream)clients.get(it.next()); //출력스트림에 하나씩 순서대로 넣는다.
				out.writeUTF(msg); //그리고 문자열로 읽는다.
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}//while
	} //sendToAll


public static void main(String[] args) {
		new TcpIpMultiChatServer().start(Integer.parseInt(args[0])); //포트값을 정수화해서 시작하라...............ㄹㅇㄴㄻㄴㅇㅎㅁㅎㄴㅇ
		}


class ServerReceiver extends Thread{ //소켓의 데이터를 받는 쓰레드를 생성
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	ServerReceiver(Socket socket){ //생성자
		this.socket=socket;
		try{
			in=new DataInputStream(socket.getInputStream()); //입력스트림을 생성
			out=new DataOutputStream(socket.getOutputStream()); //출력스트림 생성
		}
		catch(IOException e){}
	}
		public void run(){ //ServerReceiver에 대한 run()
		String name="";
		try{
			name=in.readUTF(); //입력스트림으로 들어온 값을 문자로 읽어 name에 저장한다
			sendToAll("#"+name+"님이 들어오셨습니다");
			clients.put(name, out); //값을 넣고
			System.out.println("현재 서버접속자 수는"+clients.size()+"입니다"); //컬렉션이라서 size개념 //array는 length
			
			while(in!=null){ //값이 있으면 (=값이 빈공간이 아니라면)
				sendToAll(in.readUTF()); //(다시 문자열로 읽은)값을 모두에게 보낸다.
			}
		}
			catch(IOException e){
				
			}
			finally{ //필수로 처리해야할 구문.
					sendToAll("#"+name+"님이 나가셨습니다");
					clients.remove(name); //나간사람을 remove로 지운다
					System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+"에서 종료하였습니다");
					System.out.println("현재 서버접속자 수는"+clients.size()+"입니다");		
				}//try-end
			}//run-end
		}//ReceiverThread-end
	}//class-end

