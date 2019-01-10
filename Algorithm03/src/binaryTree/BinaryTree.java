package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	Node root; //"항상 root가 누구인지?"에 대한 정보는 필수

	public BinaryTree() {
		super();
	}

	public BinaryTree(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	
	
	//1. 트리 내부 총 노드 갯수 출력 메서드
	public int size(Node n){
		//자기자신Node개수 + 왼쪽것 + 오른쪽것 누적
		//매개변수를 root를 주게되면 총 노드가 출력되게된다.
		if(n!=null){
			return 1 + size(n.getLeft()) + size(n.getRight()); //재귀함수를 통한 왼쪽호출, 오른쪽 호출
			
		}
		else{ //null이없으면 0을 반환해라
			return 0;
		}
		
	}
	//2. 조회: 부모 먼저_ 메서드 (부모-왼-오)
	public void preOrder(Node n){
		//한줄로 각 노드키의 키값 출력하기
		if(n != null){
		System.out.print(n.getKey()+"  "); //출발점 H부터
		preOrder(n.getLeft());
		preOrder(n.getRight());
		}
	}
	//3. 부모 중간_ 메서드 (왼-부모-오)
	public void inOrder(Node n){
		//한줄로 각 노드키의 키값 출력하기
		if(n != null){
		inOrder(n.getLeft());
		System.out.print(n.getKey()+"  ");
		inOrder(n.getRight());
		}
	}
	//4. 부모 나중_ 메서드 (왼-오-부모)
	public void postOrder(Node n){
		//한줄로 각 노드키의 키값 출력하기
		if(n != null){
		postOrder(n.getLeft());
		postOrder(n.getRight());
		System.out.print(n.getKey()+"  ");
		}
	}
	
	//5. 이진트리 : 형제우선 조회 (= 같은 레벨끼리 묶어서 level우선 조회 =가로기준 조회)
	public void levelOrder(Node n){
		// 큐 (큐 제거-자식 큐 저장)
		Queue<Node> q = new LinkedList<Node>();
		q.add(n); // 우선 넣어라

		while (!q.isEmpty()) {
			Node remove = q.poll(); // queue에서 제거한 값을 remove 
			System.out.print(remove.getKey() + " "); // 맨처음 값이 key //기준 100 출력 

			if (remove.getLeft() != null) { //기준의 왼쪽만 출력 
				q.add(remove.getLeft());
			}
			if (remove.getRight() != null) { //기준의 오른쪽만 출력
				q.add(remove.getRight());
			}
		}//while-end
	}//메소드-end
	
	
	
	//6. 이진탐색트리: 이진트리의 응용 (전체조회가 아니라, 왼쪽만, 오른쪽만 정렬된 상태로 조회)
}
