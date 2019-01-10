package Staticex;

public class StaticEx2 {
	public static void main(String[] args){
		System.out.println("**입금 당시의 금리**");
		BankAccount ob = new BankAccount(1995,"kim",1000,0.07);
		ob.view();
		BankAccount ob1 = new BankAccount(1998,"lee",2000,0.03);
		ob1.view();
		BankAccount ob2 = new BankAccount(2000,"park",3000,0.17);
		ob2.view();
		BankAccount ob3 = new BankAccount(2006,"baek",4000,0.09);
		ob3.view();

		System.out.println("\n2005년 당시의 금리");
		ob.view();
		ob1.view();
		ob2.view();
		ob3.view();
		
		
		System.out.println("\n0.04로 변동된 금리");
		BankAccount.setRate(0.04); //public으로 직접 값을 받아오는 것은 엄청 위험하다. 따라서 필드는 왠만하면 private로 쓴다.
		ob.view();
		ob1.view();
		ob2.view();
		ob3.view();
		
		BankAccount.setRate(0.4); //0.04가 아닌경우 금리확인 요망.
		
	}
}
