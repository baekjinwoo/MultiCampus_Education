package basic12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//1. 전화하기전에 Eco테스트하기. (데이터를 받는 서버쪽), (TCPIP를 이용한 소켓통신), (1:1접속밖에 안됨) 
//tcp를 이용해서 여러명이서?xxxxx
public class EcoServer{
	public static void main(String[] args) {
		ServerSocket ss=null; //서버에서 포트지정할 변수
		try{
			ss= new ServerSocket(Integer.parseInt(args[0])); //윈폼에서는 텍스트박스가 빠르지만, 콘솔확인할 땐 args[0]이 빠르다 
		} catch(Exception e){
			e.printStackTrace();
		}
		
		while(true){
			try{
				Socket s= ss.accept(); // accept: client의 요청을 받앗다 (연결됫다)
				String remoteHost= s.getInetAddress().getHostAddress();
				System.out.println(remoteHost+"==> Server IP"); // 연결확인차, Ip주소확인
				
				InputStream in= s.getInputStream(); // 말을 보내는 통로(send)
				OutputStream out= s.getOutputStream(); //대화를 받는 통로(receive)
				
				
				BufferedReader br= new BufferedReader(new InputStreamReader(in)); //client -> server
				BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(out)); //Server-->client
				bw.write(remoteHost+"서버에 연결을 요청하셨군요");
				bw.newLine();
				bw.flush();
		
				String line;
				
				//동작
				while(true){
					line=br.readLine(); //받은걸 읽고 
					if(line==null)break;
					System.out.println(line); //확인차
					bw.write(line); //클라이언트에서 무언가를 받자마자 Server ->client 보낸다.
					bw.newLine(); 
					bw.flush(); //출력버퍼 비우기. //보내고 나면 아무것도 없다
				}
				s.close(); //끝
			}
			catch(Exception e){
				System.out.println(e);
		
			}
		}
	}
}
