package web_socket;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.sun.swing.internal.plaf.basic.resources.basic;

//Server

//annotation : WebSocket클래스 - broadcast url
@ServerEndpoint("/broadcast") //("ws/ip/port/프로젝트명/broadcast/
	public class websocket {
	//clients 모든 요청 static선언
	 static Set<Session> clients= new HashSet<Session>(); //지역변수말고 전체범위 맴버변수로 사용한다. static을 사용하면 구글과 익스프로저에서 공유해서 채팅할 수 있다. static을 쓰지않으면 그냥 각각의 싸이트에서 글 올리는정도
//클라이언트
	//websocket.onmessage=function(){....}

//서버: 클라이언트 메시지 전달받았을 때, 메소드의 매개변수에 전달하기위해 사용되는 어노테이션
	@OnMessage
	public void a(String message, Session session) throws Exception{
		System.out.println("웹소켓 클라이언트가 메세지 보냄111 + "
				+ "메세지내용: "+message+"누가: "+session.getId());
		//session.getBasicRemote().sendText(message); //하나의 클라이언트한테만 메시지를 송수신
		//메세지: id메세지
		for(Session i: clients){ //모든클라이언트에게 메시지송수신
			i.getBasicRemote().sendText(message);
		}
	}
	@OnOpen
	public void b(Session session){ //클라이언트를 의미하는 세션만. 
		System.out.println("웹소켓 연결="+session.getId());
		//클라이언트 접속= Session객체들 생성
		//HashSet 구성
		clients.add(session);
	}
	@OnClose
	public void c(Session session){ //클라이언트를 의미하는 세션만. 
		System.out.println("웹소켓 연결해제="+session.getId());
		clients.remove(session); //계속 서버가 종류되는 것을 막아주는것.
	}
	@OnError
	public void d(Throwable e, Session session){ //클라이언트를 의미하는 세션만. 
		System.out.println("웹소켓 오류="+session.getId()+":"+e);
	}
}
