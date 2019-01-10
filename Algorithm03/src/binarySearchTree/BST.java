package binarySearchTree;

public class BST {
		//일반트리나 이진트리는 root를 선언하고, 맨위로 만들었지만, BST에서는 중간값이 root이기때문에 변하는 값이다 
		
		Node root;
		
		BST(){ 
			this.root=null;
		}
		
		public Node getRoot() { 
			return root; 
		}

		public void setRoot(Node root) {
			this.root = root;
		}

		
		
		//중위 우선 조회 --오름차순
		public void display(Node n){
			if(n!=null){
				display(n.getLeft()); //왼쪽출력
				System.out.println(n.getKey()); //나 출력
				display(n.getRight()); //오른쪽출력
			}
		}
		
		
		
	public boolean find(int id) { // 검색용도로 찾았다면 t, 아니라면 f
		// 현재 노드 루트 getKey()와 비교
		// 같으면 true
//		int cnt = 0;  //속도성능 Test
		Node current = root;

		while (current!=null){
//			cnt++;
//			System.out.print(cnt+"  -->  ");
			if (current.getKey() == id) {
				return true; //아이디가 있다. 찾았다.
			}
			// 현재 노드보다 작으면 왼쪽으로 가서 탐색
			else if (current.getKey() > id) { //루트> 입력값
				current=current.getLeft();   //그냥 current.getLeft()는 root=current.getLeft()와 같고, 무한루프를 돌게된다
			}
			// 현재 노드보다 크면 오른쪽
			else if (current.getKey() < id) { //루트< 입력값
				current=current.getRight();
				}
			}
		return false; //아이디가 없다.
		}//find_end
	
	
	
	
	public void insert(int id) {
		Node newNode = new Node(id); // id값을 가지는 노드(newNode)하나를 만들어라
//		int cnt = 0;  //속도성능 Test

		if (root == null) { // 트리를 구성하는 노드가 하나도 없다.
			root = newNode; //입력되는 정수형 id값의 처음 값을 root로 잡는다.
			return;
		}
		Node current = root; // Current노드를 루트로 지정한다
		Node parent = null; // 루트는 parent가 없기때문에 null값으로 지정해주기 위해서

		while (true) {
//			cnt++;
//			System.out.print(cnt+"  -->  ");
			parent = current;
			//현재노드보다 작으면..... 
			if (current.getKey() > id) { // 비교결과 : root(key값) > id값
				// 왼쪽노드로 설정
				current = current.getLeft();
				if (current == null) { // 왼쪽노드가 비어잇니?
					parent.setLeft(newNode); // 현재노드.setLeft(newNode);
					return;
				}
			}//if_end
			else{
				current = current.getRight();
				if(current == null){ //오른쪽자식이 없니?
					parent.setRight(newNode); //current로 현재노드를 잡지말고, parent로 잡는다. 왜냐? current는 root값이고 parent가 자식값이니까
					return;
				}
			}//else_end
		}//while-end
	}//insert-end
}
