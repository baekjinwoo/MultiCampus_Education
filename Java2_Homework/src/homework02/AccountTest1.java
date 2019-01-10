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
		System.out.println("����: "+account+"\n�ܾ�:"+balance+"\n������: "+interestRate);
	}
	public double calcuateInterest() {
		return balance*interestRate; //���� �ܾ��� �������� ���ڸ� ����Ѵ�
	}

	public void deposit(int money) {
		// �Ա��� ���� �ܾ������� ������Ų��.
		System.out.println();
		System.out.print("�Ա��� ���� ����ݾ���:  ");
		System.out.print(this.balance+=money);
		System.out.print("��");
	}

	public void withdraw(int money) {
		//����� ���� �ܾ������� ���ҽ�Ų��. ��, ����� ���� �ܾ��� 0���� ������ "����� �� �� �����ϴ�"�� ���
		this.balance-=money;
		System.out.println();
		if(this.balance<0){
			System.out.println("����� �� �� �����ϴ�");
		}
		else{
		System.out.print("����� ���� ����ݾ���:  ");
		System.out.print(this.balance);
		System.out.print("��");
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
//		Account ob = new Account("��������: "+ob.getAccount()+"\n�����ܾ�: "+ob.getBalance());
		Account ob = new Account ("stre",51324, 0.5); //�⺻���� ����
		
		ob.withdraw(10000); //���
		ob.deposit(10000); //�Ա�
		//�������� ���
		//ob.calcuateInterest(); // ���ڰ��
		
		
		System.out.println();
		System.out.println("\n��������: "+ob.calcuateInterest());
		
		
		
		ob.withdraw(3000); //���
		ob.withdraw(6000); //���
		ob.withdraw(60000); //���

	}
}
