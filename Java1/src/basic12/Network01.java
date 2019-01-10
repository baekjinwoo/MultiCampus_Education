package basic12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

//1. 네트워크의 URL
//(Run configu...실행하고 도메인을 작성하면 나오는 실행문
public class Network01 {
	public static void main(String[] args) throws Exception {
		URL obj = new URL(args[0]);
		BufferedReader in= new BufferedReader(new InputStreamReader(obj.openStream()));  //obj.openStream()?
		
		//이하문장은 읽어온 문장 출력
		String inputLine;
		while((inputLine=in.readLine())!=null)
			System.out.println(inputLine);
			System.out.println("===========");
			System.out.println("protocol="+ obj.getProtocol());
			System.out.println("Host="+ obj.getProtocol());
			System.out.println("filename="+ obj.getHost());
			System.out.println("port="+ obj.getPort());
			System.out.println("ref="+ obj.getRef());
			in.close();
	}
}
