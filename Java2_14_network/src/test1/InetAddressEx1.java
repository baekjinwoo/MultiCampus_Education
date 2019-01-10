package test1;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class InetAddressEx1 {
	public static void main(String[] args) throws UnknownHostException, MalformedURLException {
		InetAddress addr1= InetAddress.getByName("www.naver.com"); //host는 네이버로
		InetAddress addr2= InetAddress.getLocalHost(); //host는 현재컴퓨터로
		URL url = new URL("http://127.0.0.1:9000/apex"); //host는 http, port는 9000
		
		System.out.println(url.getProtocol()+"  "+url.getPort()+"\n"); //host, port
		
		System.out.println("addr1: "+addr1.getHostAddress());
		System.out.println("addr2: "+addr1.getHostName());
		
		System.out.println("\n"+"addr1: "+addr2.getHostAddress());
		System.out.println("addr2: "+addr2.getHostName());
	}
}
