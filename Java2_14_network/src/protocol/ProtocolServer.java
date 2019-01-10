package protocol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 *  100:아이디                         ==>입장
 *  200:아이디                         ==>퇴장
 *  300:아이디:메세지                  ==>대화방에 접속한 모든 사람들에게 메세지 전달
 *  400:아이디1:아이디2:메세지         ==>아이디1이 아이디2에게 귓속말
 */
public class ProtocolServer {
	ServerSocket ss=null;
	Socket sock=null;
	BufferedReader br=null;
	BufferedWriter bw=null;
	
	public ProtocolServer() throws IOException{
		ss=new ServerSocket(7000);
		System.out.println("접속 대기중....");
		sock=ss.accept();           //응답
		
		br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
		bw=new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		
		while(true)
		{
			try{
				String buf=br.readLine();
				String[] words=buf.split(":");  //읽어온 문자열을  구분자(:) 로 분리
				
				if(words[0].equals(Protocol.ENTER)){    //입장
					enter(words);
				}else if(words[0].equals(Protocol.EXIT)){  //퇴장
					exit(words);
				}else if(words[0].equals(Protocol.SEND_MESSAGE)){  //메세지 전달
					sendMessage(words);
				}else if(words[0].equals(Protocol.SECRET_MESSAGE)){  //귓속말
					secretMessage(words);
				}else{
					bw.write("잘못된 요청입니다\n");
					bw.flush();
				}
			}catch(IOException e){
				System.exit(0);
			}
		}		
	}
	
	private void secretMessage(String[] words) {
		//400:아이디1:아이디2:메세지
		System.out.println("[" + words[0] + "의" + words[2] + "가 귓속말을 보냄]");
		System.out.println("[" + words[1] + "]" + words[3] + "\n");
	}

	private void sendMessage(String[] words) {
		//300:아이디:메세지
		System.out.println("[" + words[1] + "]" + words[2] + "\n");
	}

	private void exit(String[] words) {
		//200:아이디
		System.out.println("[" + words[1] + "]님이 퇴장하셨습니다\n");
	}

	private void enter(String[] words) {
		//100:아이디
		System.out.println("[" + words[1] + "]님이 입장하셨습니다\n");
	}

	public static void main(String[] args) throws IOException {
		new ProtocolServer();
	}
}













