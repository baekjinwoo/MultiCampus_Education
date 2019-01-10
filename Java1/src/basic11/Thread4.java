package basic11;

class SSThread extends Thread{
	String str;
	
	SSThread(String str){
		this.str=str;
	}
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(i+"번쨰 "+str);
			try{
			Thread.sleep(500);
			}
			catch(InterruptedException e){}
		}
		System.out.println("Done"+str);
	}
}
//문제. 사과, 배, 감이 5번씩 교대로 출력하는 three thread로직을 작성하시오.
public class Thread4 {
	public static void main(String[] args) {
		SSThread s1=new SSThread("사과");
		SSThread s2=new SSThread("배");
		SSThread s3=new SSThread("감");
		
		s1.start();
		s2.start();
		s3.start();
		System.out.println("main end!!");
	}
}
