package test1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAddressEx2 {
	public static void main(String[] args) throws UnknownHostException {
		Scanner sc=new Scanner(System.in);
		String host=null;
		
		System.out.print("웹싸이트 주소:");
		host=sc.nextLine();
		
		InetAddress[] addr = InetAddress.getAllByName(host);
		System.out.println(host);
		System.out.println(addr.length+"개의 ip가 있음");
		
		for(int i=0;i<addr.length;i++){
			System.out.println(addr[i].getHostAddress());
		}
		sc.close();
	}
}
