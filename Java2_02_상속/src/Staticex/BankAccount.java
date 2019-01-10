package Staticex;

public class BankAccount {
	private int year;
	private String name;
	private int money;
	private static double rate;

	public BankAccount(int year, String name, int money, double r) { // 생성자
		this.year = year;
		this.name = name;
		this.money = money;
		rate = r; // static변수를 초기화하는 방법
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public static double getRate() { 
		return rate;
	}

	public static void setRate(double r) {
		//유효성검사
		if(r<0.02||r>0.12){
			System.out.println("금리확인 요망");
			System.exit(0);
		}
		rate=r;
	}

	public void view() {
		System.out.println(year + " " + name + " " + money + " " + rate);

	}
}
