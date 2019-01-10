package homework;

import java.util.Scanner;

/*문제. 은행업무1 => 은행업무를 객체지향으로 만드시오
	  	java 2개 
  			- main:black.java
	  		- 계정클래스: BankAccount.java
	  	(참고: classBankAccount{	int balance;잔액, getter/setter추가, withdraw는 출금처리메소드, deposit는 임금처리메소드}
	       단,(1) 이율계산 메소드는 static, 이율도 static을 사용해라
	  	 (2) 돈 입금시마다 잔액에 이자를 더하여 줌
	  	 (3) 이율은 잔액의 0.05
	  	   
	  Static 이율계산 {} //계산하는 메소드도 static
	  Static int 이율 *=0.05 //이율자체도 static
	  balance *0.05
	  OOP
	  출금입금을 메인에서 출력해볼것*/

class BankAccount{
private int balance; //캡슐화 set,get
static double plusf=0.05; //static변수 이율초기화

public void setBalance(double balance) { //set 입력을 받고
	this.balance+=balance;
	
}
public double getBalance() { //get 반환해주고
	return balance;
}


public BankAccount(int balance){ //생성자
	this.balance=balance;
	
}

public void deposit(int balance){ // deposit 입금처리 메소드
	this.balance+=balance;
	 this.balance += plusCal(this.balance);
	 
}

public void withdraw(int balance){ //withdraw 출금처리 메소드
	this.balance-=balance;
} 

public static double plusCal(int balance){ //static반환형메소드(도우미를 사용)
	return balance*plusf;
}

}

public class hm22 {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	BankAccount b1=new BankAccount(1000); //초기값 선언
	b1.withdraw(500);
	b1.deposit(1000);
	System.out.println(b1.getBalance());
	}
}


/*
 * 또 다른 풀이방법
 public class BankAccount {
   private int balance;
    public static double interest; //스태틱변수
    public static void InterestRate (double interest) { 
	//0.1 //스태틱메소드 //캡슐화 //이율을 받는 도우미
     
         BankAccount.interest = interest;
	}
	public BankAccount(int balance){ 
		this.balance=balance;
		
	}
	public void SetBalance(int balance)
	{
		this.balance = (int) (balance+
				balance *interest);
	}

	public int GetBalance()
	{
		return balance;
	}

	public void Withdraw(int amount)
	{
		balance -= amount;
	}

	public void Deposit(int amount)
	{
		balance += amount;
	}
}
public class Bank {

	public static void main(String[] args) {
		//BankAccount.interest=0.5;
		//클래스명.속성=값
		System.out.println("account1...");

		BankAccount account1 = 
				new BankAccount(1000);
		BankAccount.InterestRate(0.5);
		account1.SetBalance(10);

		account1.Withdraw(5);
		System.out.println(account1.GetBalance());

		account1.Deposit(10);
		System.out.println(account1.GetBalance());
		System.out.println();
	}
}
 * */
