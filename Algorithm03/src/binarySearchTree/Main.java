package binarySearchTree;

public class Main {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(8);
		Node n3 = new Node(30);
		Node n4 = new Node(11);
		Node n5 = new Node(80);
		Node n6 = new Node(300);
		Node n7 = new Node(200);
	
		//         * 중간값 
		// 1 8 11 30 80 200 300
		
		/*				  	30
		* 			8				200
		* 		1		11		80		300
		* 
		* */
		
		//위의 그림과같이 설정
		n3.setLeft(n2); 
		n3.setRight(n7);
		
		n2.setLeft(n1);
		n2.setRight(n4);
		
		n7.setLeft(n5);
		n7.setRight(n6);
		
		BST bst = new BST();
		bst.setRoot(n3); // root로 지정
		bst.display(bst.getRoot());
		
		System.out.println(bst.find(80)); //t
		System.out.println(bst.find(800)); //f
	

		
		
		//새로운 binarysearch트리를 만들어서 insert를 통해 값을 저장
		BST bst2 = new BST();
		System.out.println("\n<< insert를 통해 새로운bts2에 값 저장 >>");
		bst2.insert(30); //root
		bst2.insert(100);
		bst2.insert(50);
		bst2.insert(90);
		bst2.insert(75);
		bst2.insert(3);
		bst2.insert(132);
		System.out.println(" ========이진탐색트리 출력 =========");
		bst.display(bst2.getRoot());
		System.out.println();

		System.out.println("\n<< bts2에 insert로 넣은 값 검색 >>");
		System.out.println("90 검색결과는: "+ bst2.find(90));
		System.out.println("50 검색결과는: "+ bst2.find(50));
		System.out.println("9000 검색결과는: "+ bst2.find(9000));
		//결과적으로 insert를 7개(root포함)를 넣엇다면 find는 7/2번 검색하기에 수행시간성능이 빨라진다
		
	}
}
