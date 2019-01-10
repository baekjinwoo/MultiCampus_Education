package basic10;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class StackQueue {
	public static void main(String[] args) {
	//1. Vector Sort
		Vector v1= new Vector(3); //v1이 이 배열의 대표명, 곧 배열의 시작점(초기번지값)
		for(int i=3;i>=1;i--)
			v1.add(new Integer(i+100));
		
		for(int i=0;i<v1.size();i++) //(가변배열)컬렉션이니까 배열크기는 size()
			System.out.print(v1.get(i)+"\t"); //ArrayList와 같아서 get쓸수있다
		System.out.println();
		
	//2.Vector --> array
		Object[] ob1=v1.toArray(); //V->a
		Arrays.sort(ob1); //101 102 103 기본값이 오름차순
			
		for(int i=0;i<ob1.length;i++)
			System.out.print(ob1[i]+"\t");
		System.out.println();
			
	//3. Stack: filo
		Stack <String> st1 = new Stack <String>(); //제네릭스를 이용해서 Stack을 문자열로 받겟다. 
		
		st1.push("곤드래밥");
		st1.push("오징어볶음밥"); //push: Stack에 데이터를 밀어넣는방법
		st1.push("뚝불고기");
		System.out.println(st1.size()); //아래에서부터 곤-오-뚝
		
			
	//4. 종이상자를 이용한 출력1(Iterator)
		System.out.println("Itearator로 출력");
		Iterator <String> itr1 = st1.iterator(); //st1에 저장된 내용을 종이상자에 집어넣어라
		while(itr1.hasNext()){  //hasmore와 비슷
			System.out.println(itr1.next());//종이상자는 stack이 아니라서 넣는순서랑 출력순서가 같다 //아래에서부터 뚝-오-곤
		}
		System.out.println();
			
	//5. Stack 출력2
		System.out.println("pop으로 출력");
		if(!st1.isEmpty())//하나나오고		   //st1.isEmpty는 Stack의 첫번째 번지가 비어있어?라는 물음을 의미.
			System.out.println(st1.pop()); //안비어있으니까 팝 하고 출력
		while(!st1.isEmpty())//나머지 다 	   //첫번째에 자료가 있는지. 그다음에 두번째가 있는지 그다음에 세번째가 있는지를 출력
			System.out.println(st1.pop());
		System.out.println();

			
	//6.Queue
		//Stack과 Queue을 쓸떄 검색을 DFs(넓이우선탐색)와 Bfs(깊이우선탐색)사용되는 게 다르다.
		//collection 인터페이스
		// ----> 큐 인터페이스
		// ----> 상속받아만든 (자식) LinkedList클래스
		Queue <String> q1 = new LinkedList <String> (); //Queue 인터페이스를 쓸때는 LinkedList클래스를 써줘야지 객체생성이 가능하다. Queue만 가지고 객체생성 불가능
		//LinkedList<String> q1 =new LinkedList <String>();라고 적은 이유는  상속의 개념이라. ex) List ~~new arrayList처럼
		
		//queue에 자료넣기
		q1.offer("바보"); //offer: Queue를 사용할때 데이터를 밀어넣는다
		q1.offer("온달");
		q1.offer("평강공주");
		System.out.println(q1.size()); //들어간만큼의 배열의 크기를 출력한다
		System.out.println();
		
		
		//Queue를 Iterator로 출력하기
		Iterator <String> itr2= q1.iterator();
		while (itr2.hasNext()){
			String name1=itr2.next();
			System.out.println(name1);
		}
		System.out.println();
			
		//큐에서 꺼내기
		if(!q1.isEmpty())
			q1.poll();
		if(!q1.isEmpty())
			q1.poll();	//평강공주만 남음
		
		q1.offer("홍길동");//평강공주,홍길동만 남음
		System.out.println(q1); //바보를 지우고 온달을 지우고 평강공주만 남앗는대 홍길동을 넣엇다.
		
		System.out.println(q1.peek()); //first data search //0번지 평강공주만 뽑는다.
		
	//7.PribrityQueue 우선순위
		Queue pq=new PriorityQueue();
		pq.offer(3);
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		System.out.println(pq);
		
		Object obj=null;
		while((obj=pq.poll())!=null) //PriorityQueue에 저장된 요소를 하나씩 꺼낸다.
			System.out.println(obj); //들어간 대로 나온다.
		System.out.println("-------------------------------------------");
		
	//8. BinarySearch()검색 //2진검색 //전제조건으로 찾아야될 배열이 Sort되있어야 한다 //속도가 엄청 빠르다
		int[] sear={30,70,100};
		if(Arrays.binarySearch(sear, 30)>=0){ //30을 검색해서 0보다 큰지.
			System.out.println("찾았네~~심봤다");
			System.out.println(Arrays.binarySearch(sear, 30)+"번째에 있네");
		}
		else
			System.out.println("없어!!+");
		System.out.println();
		
		if(Arrays.binarySearch(sear,2345)>=0){ //없는대 한번 결과를 볼라고 찍어보는 것
			System.out.println("찾았네~~심봤다");
			System.out.println(Arrays.binarySearch(sear, 2345)+"번째에 있네");
		}
		else{
			System.out.println(Arrays.binarySearch(sear, 2345));
			System.out.println("없어!!!!");
		}
	}
}
