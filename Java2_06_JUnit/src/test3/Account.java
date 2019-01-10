package test3;

public class Account {
	private int balance;
	
	public Account(int money){ //통장초기값
		this.balance=money;
		
	}
	public int getBalance(){
		return this.balance;
	}
		
	public void deposit(int money){ //예금){
		this.balance+=money;
	}
	public void withdraw(int money){ //출금
		this.balance-=money;
	}
	
}
