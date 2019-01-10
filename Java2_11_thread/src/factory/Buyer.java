package factory;

//소비
public class Buyer extends Thread{
	private Factory factory;
	
	public Buyer(Factory factory){
		this.factory=factory;
	}
	
	@Override
	public void run(){   //소비작업
		for(int i=1; i<=500; i++){
			factory.sell();
		}
	}
}
