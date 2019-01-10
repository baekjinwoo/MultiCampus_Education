package HomeworkEx2;

import java.util.Stack;

/*
+getDrink():String
+putDrink(drink String):void

[참고]
wait()와 notify()를 이용하여 완성
Stack store=new Stack();

pop() :  꺼냄 
push():  넣기*/

//--------------------------------------------------------------------------------------------

/*
Thread간의 조정
두개의 스레드가 데이터를 주고 받는 경우에 발생하는데
이를 해결하기 위해 스레드에서 wait();, notify();를 이용한다.

wait() : 스레드를 일시정지 시켜 대기 상태로 만든다.
notify() : 스레드를 깨워 다시 실행시킨다.
notifyAll() : 모든 스레드를 깨워 다시 실행시킨다.

다중쓰레드를 사용할 경우 nofity();를 사용하면 어떤 쓰레드가 깨어날지 알 수 없기 때문에
우선순위가 높은 쓰레드가 계속 wait 상태로 머무를 수 있다.
그렇기 때문에 notifyAll();을 통해 JVM이 쓰레드의 우선순위에 따라 처리하게 하는 것이 좋다.
*/

public class VendingMachine{
	Stack store=new Stack(); 

	public VendingMachine(){
		
	}
	
	public synchronized String getDrink(int i){
		while(store.isEmpty()) //아무것도 없다면 
		{
			try {
				wait(); //정지
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 			
		}
		notify(); //실행
		System.out.println("소비자 : 음료수 No."+ i+" 꺼내먹음");
		return store.pop().toString(); //하나씩 넣어주고
	}
	
	
	
	public synchronized void putDrink(int drink){
		while(!store.isEmpty()) //뭐라도 들어있으면
		{
			try {
				wait(); //정지
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 			
		}
		notify(); //실행
		store.push(drink); //하나씩 빼내고
		System.out.println("생산자 : 음료수 No."+drink+" 자판기에 넣기");
	}
}




	
		
	






