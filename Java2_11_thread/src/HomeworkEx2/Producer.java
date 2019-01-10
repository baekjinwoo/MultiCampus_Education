package HomeworkEx2;

public class Producer extends Thread{
	private VendingMachine vm;
	
	public Producer(VendingMachine vm){
		this.vm=vm;
	}
	
	@Override
	public void run(){
		for (int i=0; i<5;i++) {
			vm.putDrink(i);  //매개변수를 어떻게 해야할 줄 몰라서 null로 우선 임시대처
		}
	}
}
