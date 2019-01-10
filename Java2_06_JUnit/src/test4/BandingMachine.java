package test4;

public class BandingMachine {
	private int money;
	
	public void insertCoin(int money){ //동전주입
		if(money<0){
			throw new RuntimeException("zero or nagative money:"+money);
		}
		this.money+=money;
	}
	public int getCurrent(){ //누적된 동전
		return this.money;
	}
}
