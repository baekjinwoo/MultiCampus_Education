package basic12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//1. 전화하기전에 Eco테스트하기. (데이터를 주는쪽 클라이언트) 
//소켓통신 //1;1접속밖에 안됨 //tcp를 이용해서 여러명이서?
public class EcoClient {
	public static void main(String[] args) {
	//전화하기전에 Eco테스트 (데이터를 먼저보내는 Client)
		try{
			String host=args[0]; //?	
			int port=Integer.parseInt(args[1]); //?
			Socket s=new Socket(host,port); //Reader /Writer Stream Create		//?
				
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			
			//ReaderStream create->from keyboard입력 (네트워크아님)
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			
			String txMsg="";
			String recMsg="";
			System.out.println(br.readLine());
			while(true){
				System.out.println("Data input:");
				txMsg=in.readLine();
				if(txMsg.length()==0)
					break;
				bw.write(txMsg,0,txMsg.length()); //관으로 넘어간다 
				bw.newLine(); //줄 바꾸기
				bw.flush(); //관 비우기
					
				recMsg=br.readLine(); //읽어서 에코된 것 읽기
				System.out.println("Echoed Data:"+ recMsg);
			}
		} catch(Exception e){
			System.out.println(e);
		}
	}
}