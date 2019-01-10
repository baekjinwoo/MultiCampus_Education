package homework02;


class Account {
	private String account;
	private int balance;
	private double interestRate;

	public Account() {
	}
	
	public Account(String account, int balance, double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
		System.out.println("계좌: "+account+"\n잔액:"+balance+"\n이자율: "+interestRate);
	}
	public double calcuateInterest() {
		return balance*interestRate; //현재 잔액을 기준으로 이자를 계산한다
	}

	public void deposit(int money) {
		// 입금을 통해 잔액정보를 증가시킨다.
		System.out.println();
		System.out.print("입금을 통한 현재금액은:  ");
		System.out.print(this.balance+=money);
		System.out.print("원");
	}

	public void withdraw(int money) {
		//출금을 통해 잔액정보를 감소시킨다. 단, 출금을 통해 잔액이 0보다 작으면 "출금을 할 수 없습니다"를 출력
		this.balance-=money;
		System.out.println();
		if(this.balance<0){
			System.out.println("출금을 할 수 없습니다");
		}
		else{
		System.out.print("출금을 통한 현재금액은:  ");
		System.out.print(this.balance);
		System.out.print("원");
		}
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return 0;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}


public class AccountTest1 {

	public static void main(String[] args) {
//		Account ob = new Account("계좌정보: "+ob.getAccount()+"\n현재잔액: "+ob.getBalance());
		Account ob = new Account ("stre",51324, 0.5); //기본정보 생성
		
		ob.withdraw(10000); //출금
		ob.deposit(10000); //입금
		//변경정보 출력
		//ob.calcuateInterest(); // 이자계산
		
		
		System.out.println();
		System.out.println("\n이자율은: "+ob.calcuateInterest());
		
		
		
		ob.withdraw(3000); //출금
		ob.withdraw(6000); //출금
		ob.withdraw(60000); //출금

	}
}
