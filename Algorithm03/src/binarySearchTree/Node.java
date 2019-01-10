package binarySearchTree;

	//binaryTree의 Node.class를 복사
	public class Node {
	int key;
	Node left;
	Node right;

	public Node(int key, Node left, Node right) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
	public Node(int key){
		this.key=key;
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
