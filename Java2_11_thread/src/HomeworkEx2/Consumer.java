package HomeworkEx2;

public class Consumer extends Thread {
	private VendingMachine vm;
	
	public Consumer(VendingMachine vm){
		this.vm=vm;
	}
	
	@Override
	public void run(){
		for (int i=0; i<5;i++) {
			vm.getDrink(i);
		}
	}
}
