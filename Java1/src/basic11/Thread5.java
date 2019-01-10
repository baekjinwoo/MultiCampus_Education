package basic11;

class BB extends Thread{
	public void run(){
		for(int i=0;i<5;i++){ //b1.join을 만나면 실행!
			System.out.println(i);
			try{
				Thread.sleep(700);
			}
			catch(InterruptedException e){}
			System.out.println("즐거운 하루~");
		}
	}
}


class T extends Thread{
	public void run(){
		BB b1=new BB();
		b1.start();
		System.out.println("정말");
		try{
			b1.join(); //join을 만나게되면 BB클래스가 5번 반복될때까지 기달렸다가 끝나고 실행한다.
			//b1.join(2000); //2초까지밖에 못기다린다.
		}
		catch(InterruptedException e){}
		System.out.println("자바와 함께~");
		System.exit(0); //강제종료
	}	
}


public class Thread5 {
	public static void main(String[] args) {
		T a1=new T();
		a1.start(); //thread가동명령
	}

}
