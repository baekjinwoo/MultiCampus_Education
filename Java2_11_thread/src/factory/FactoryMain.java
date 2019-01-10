package factory;

public class FactoryMain {
	public static void main(String[] args) {
		Factory factory=new Factory();
		Buyer buyer=new Buyer(factory);
		Worker worker=new Worker(factory);
		
		buyer.start();
		worker.start();
	}
}
