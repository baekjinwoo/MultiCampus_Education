package binaryTree;

public class Main {
	public static void main(String[] args) {
		//루트가 누군지 정하지 않은 상태에서 부모자식관계 형성
		Node n1 = new Node(100, null,null);
		Node n2 = new Node(200, null,null);
		Node n3 = new Node(300, null,null);
		n1.setLeft(n2);
		n1.setRight(n3);
		
		Node n4 = new Node(400, null,null);
		Node n5 = new Node(500, null,null);
		n2.setLeft(n4);
		n2.setRight(n5);
		
		Node n6 = new Node(600, null,null);
		Node n7 = new Node(700, null,null);
		n3.setLeft(n6);
		n3.setRight(n7);
		
		Node n8 = new Node(800, null,null);
		Node n9 = new Node(900, null,null);
		n4.setLeft(n8);
		n4.setRight(n9);
	
		Node n10 = new Node(1000,null,null);
		n5.setLeft(n10);
		
		//n1을 루트(최상위)로 만듬
		BinaryTree tree= new BinaryTree(n1);
		
		//1. 트리 내부 총 노드 갯수 출력 메서드  //트리는, 부모자식관의 관계로써 내려가는 계층구조이기때문에 재귀함수를 사용하는 경우가 많다. //각각은 노드들이나 이것들을 연결하는 것들은 트리이다.
		int total= tree.size(tree.root); 
		System.out.println(total);
		
		//2. 조회: 부모 먼저_ 메서드
		System.out.print("부모먼저 조회: ");
		tree.preOrder(tree.root); //트리전체를 다 볼거니까 tree.root()이지만 n6부터보고싶다면 n6을 넣으면 된다
		System.out.println();
		
		//3. 부모 중간_ 메서드
		System.out.print("부모중간 조회: ");
		tree.inOrder(tree.root);
		System.out.println();
		
		//4. 부모 나중_ 메서드
		System.out.print("부모나중 조회: ");
		tree.postOrder(tree.root);
		System.out.println();
		

		/*						  100
		 * 				200					300
		 * 			400		500			600		700	
		 * 		800	  900		1000
		 * 
		 * 
		 * 
		 * */
		
		//5. 이진트리 : 형제우선 조회 (= level우선 조회 =가로기준 조회)
		System.out.print("같은 레벨 우선 조회: ");
		tree.levelOrder(tree.root);
		System.out.println();

	}
}
