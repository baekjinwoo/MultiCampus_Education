package factory;

//공장
public class Worker extends Thread{
	private Factory factory;
	
	public Worker(Factory factory){
		this.factory=factory;
	}
	
	@Override
	public void run(){   //생산작업
		for(int i=1; i<=500; i++){
			factory.produce();
		}
	}
}
