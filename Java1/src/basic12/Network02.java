package basic12;

import java.net.InetAddress;
import java.util.Arrays;

//2. 네트워크에서 IP
public class Network02 {

	public static void main(String[] args) throws java.net.UnknownHostException{
		InetAddress ip=null;
		InetAddress[] ipArr=null;
		
		ip=InetAddress.getByName("www.naver.com"); //작성된 도메인 ip주소를 가져온다
		System.out.println("getHostName(): "+ip.getHostName()); //이 ip의 이름이 나오고
		System.out.println("getHostAddress(): "+ip.getHostAddress()); // 이 ip의 실제 주소가 나온다
		System.out.println("toString(): "+ ip.toString()); //toString메서드안에 HostName과 HostAddress가 내부적 저장되있기에 두개가 출력됨
		
		
		byte[] ipAddr = ip.getAddress(); //byte배열에(제이스기법) ip주소를 넣는다. 
		System.out.println("getAddress(): "+Arrays.toString(ipAddr)); //제이스 기법으로 byte단위 128을 넘으면 음수가 나온다.
		
		
		String result="";
		for(int i=0;i<ipAddr.length;i++){
			result+=(ipAddr[i]<0)?ipAddr[i]+256:ipAddr[i];
			result+=".";
			}
		
		System.out.println("getAddress()+256: "+result); //128+128
		System.out.println();
	
		
		
		ip=InetAddress.getLocalHost(); //내 ip주소를 가져온다
		System.out.println("getHostName()"+ip.getHostName());
		System.out.println("getHostAddress()"+ip.getHostAddress());
		System.out.println();
		
		
		
		ipArr=InetAddress.getAllByName("www.naver.com"); //모든 ip주소를 가져온다.
		for(int i=0;i<ipArr.length;i++){
			System.out.println("ipArr["+i+"] :"+ipArr[i]);
		}
	}
}	
