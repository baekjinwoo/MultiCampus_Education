package Tree;

import java.util.ArrayList;

//트리 노드 집합. 루트로부터 노드 연결 자료구조
class Node{ //노드정보 클래스
	String name;
	Node parent;
	ArrayList<Node> children; //ArrayList자료구조의 Node자료형 변수를 선언.
	//Node a = new Node("A",new Node());
	// a.setChildren(Node를 ArrayList로 저장);
	
	public Node(){ 
		
	}
	public Node(String name, Node parent) {
		this.name = name;
		this.parent = parent;
	}
	public Node(String name, Node parent, ArrayList<Node> children) {
		this.name = name;
		this.parent = parent;
		this.children = children;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public ArrayList<Node> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}
	public void printAllNode(){ //전체노드출력을 위한 반복
		printNode();
		if(children!=null){
			for(int i=0; i<children.size();i++){
				children.get(i).printAllNode(); //자식이 있을때까지 PrintAllNode 재귀함수를 호출
			}
		}
	}

	public void printNode(){ //하나의 노드출력
		System.out.println("-----------------노드정보확인---------------");
		if(parent!=null){ System.out.println("부모노드: "+parent.getName()); }
		else{ System.out.println("부모 노드 : 없음"); }
		
		System.out.println("현재노드: "+name);
		if(children!=null){
			System.out.println("자식노드 갯수: "+children.size());
			System.out.print("자식노드 명단: ");
			for(int i=0; i<children.size();i++){//명단을 출력하기 위한 반복문
				System.out.print(i+": "+children.get(i).getName());
			}
		}
		else{
			System.out.println("자식 노드 갯수 :0");
			System.out.println("자식 노드 명단 :없음");
		}
		System.out.println();
		System.out.println("-----------------------------------------");
	}
}


class MultiChildrenTree {
		Node root;
		public MultiChildrenTree(){}
		public MultiChildrenTree( Node root ){ this.root=root; }
		
}
