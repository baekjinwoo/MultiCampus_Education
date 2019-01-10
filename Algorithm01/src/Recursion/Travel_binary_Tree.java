package Recursion;


//2진 트리
class Node{
	String name;
	Node left; //Node클래스가 Node를 자료형으로, 변수로 가진다.
	Node right;
	
	Node(String name, Node left, Node right) {
		this.name = name;
		this.left = left;
		this.right = right;
	}
}//Node-end



public class Travel_binary_Tree {
	public Node map(){ 
	//누가 내 오른쪽이고 왼쪽인지를 지도로 만드는 메소드 //Node타입 리턴
	//노드 구성 최초 관광지 구성하기 <-- 아래에서부터 초기화
		Node n = new Node("N",null,null);
		Node t = new Node("T",null,null);
		Node a = new Node("A",null,t);
		Node e = new Node("E",a,null);
		Node u = new Node("U",n,null);
		Node f = new Node("F",u,e);
		Node z = new Node("Z",null,null);
		Node y = new Node("Y",null,null);
		Node k = new Node("K",null,y);
		Node s = new Node("S",z,k);
		Node h = new Node("H",f,s);
		return h; //초기반환값은 h로 모두 받을 수 있도록
	}
	

	private void A_Course(Node n) {
		//A course: 가운데-왼쪽-오른쪽 코스		
		if(n != null){  //null을 만날때까지 실행
			System.out.print(n.name+"->"); //출발점 H부터
			A_Course(n.left);
			A_Course(n.right);
		}
	}

	private void B_Course(Node n) {
		if(n != null){  //null을 만날때까지 실행
			B_Course(n.left);
			System.out.print(n.name+"->");
			B_Course(n.right);
		}
	}
	
	private void C_Course(Node n) {
		if(n != null){  //null을 만날때까지 실행
			//출발점이 안 정해진 상태이기때문에 재귀의 끝까지 돈다.
			C_Course(n.left); //left재귀
			C_Course(n.right); //right재귀
			System.out.print(n.name+"->"); //F U N 으로 나와야되는데. N U T A E F순서로 나오는 이유는 C_Course(n.left) 재귀함수의 종료까지 돌다가 종료가되면 그 종료부터 찍게된다. 따라서 N U T A ....
		}
	}

	public static void main(String[] args) {
		Travel_binary_Tree t = new Travel_binary_Tree();
		Node start = t.map(); //map을 호출해서, 출발지 h섬의 Node를 반환한다
		
		System.out.print("A코스:가운데(=현재)-왼쪽-오른쪽 관광코스= ");
		t.A_Course(start);

		System.out.print("\nB코스:왼쪽-가운데-오른쪽 관광코스= ");
		t.B_Course(start);
		
		System.out.print("\nC코스:왼쪽-오른쪽-가운데 관광코스= ");
		t.C_Course(start);
		
	
	}//main_end
}//Travel_binary_Tree_end
