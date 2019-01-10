package binaryTree;

//public class Node<T> { //T는 무슨타입인지 모른다. key를 String으로도 쓰고싶고 int로도 쓰고싶을때 ?로 작성해주는 것 //3개의 노드변수를 만듬
//	T key;
//	Node left;
//	Node right;
//	
//	public Node(T key, Node left, Node right) {
//		super();
//		this.key = key;
//		this.left = left;
//		this.right = right;
//	}
//	public T getKey(){ //리턴자료형 T
//		return key;
//	}
//	public static void main(String[] args) {
//		Node<String> c = new Node("c", null, null); //오른쪽, 왼쪽 자식이 없음
//		Node<String> b = new Node("b", null, null); //      					/a\
//		Node<String> a = new Node("a", b, c); 		//						  b     c
//		//Node<Integer> a= new Node(0,b,c);
//		
//		System.out.println(c.getKey());
//		System.out.println(b.getKey());
//		System.out.println(a.getKey());
//	}
//}


public class Node {
	int key;
	Node left;
	Node right;

	public Node(int key, Node left, Node right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}

	public int getKey() { // 리턴자료형 T
		return key;
	}

	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
