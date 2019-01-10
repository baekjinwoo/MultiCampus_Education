package atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Bank implements Runnable{
	private long depositMoney=100000;    //은행잔고
	private long balance;                //찾는금액
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	public synchronized void run() { //동기화를 하지 않으면 코드가 꼬인다. 엄마고객이 오자마자 일처리도 하기전에 아들고객도 들어오기때문에 
		System.out.println(Thread.currentThread().getName()+"고객님 어서 오세요");
		
		try{
			System.out.print("출금하실 금액을 입금해 주세요:");
			balance=Long.parseLong(br.readLine());
		}catch(NumberFormatException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		withDraw();    //잔액계산
	}
	
	public void withDraw(){
		if(depositMoney >= balance)
		{
			if(balance % 10000 == 0)
			{
				depositMoney = depositMoney - balance;
				System.out.println("남은 금액은 " + depositMoney + "원 입니다\n");
			}else{
				System.out.println("만원 단위로 입력하세요\n");
			}
		}else{
			System.out.println("잔액이 부족합니다");
		}
	}
}















