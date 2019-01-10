package thread;

//single thread: ob1이 다 끝나야 -> ob2시작하고 ob2다 끝나야 -> ob3시작.
public class MyThreadEx1 {
	String str;
	int num;
	
	public MyThreadEx1(String str, int num){
		this.str=str;
		this.num=num;
	}
	
	public void view(){
		for(int i=1;i<=num;i++){
			try{
			System.out.println(str+":"+i);
			Thread.sleep(30);
			}catch(InterruptedException e){
	//			e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MyThreadEx1 ob1 = new MyThreadEx1("one",50);
		MyThreadEx1 ob2 = new MyThreadEx1("two",50);
		MyThreadEx1 ob3 = new MyThreadEx1("three",50);

		ob1.view();
		ob2.view();
		ob3.view();
		
	}
}
