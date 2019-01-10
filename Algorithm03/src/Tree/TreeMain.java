package Tree;

import java.util.ArrayList;


/* 			 A
 	B   	 C	    D
 	E  F			G
 */
public class TreeMain{ // A-B-C-D순회(1) A-B-E-F-C 순회(2)
	public static void main(String[] args){
		Node a =new Node("A",null);
		Node b =new Node("B",a);
		
		Node c =new Node("C",a);
		Node d =new Node("D",a);

		Node e =new Node("E",b);
		Node f =new Node("F",b);
		Node g =new Node("G",d);
		
		ArrayList<Node> a_list = new ArrayList<Node>();
		a_list.add(b);
		a_list.add(c);
		a_list.add(d);
		a.setChildren(a_list);
		
		ArrayList<Node> b_list = new ArrayList<Node>();
		b_list.add(e);
		b_list.add(f);
		b.setChildren(b_list);
		
		ArrayList<Node> d_list = new ArrayList<Node>();
		d_list.add(g);
		d.setChildren(d_list);
		
		MultiChildrenTree tree= new MultiChildrenTree(a);  a.printAllNode();	//a를 루트로 설정 트리 객체 생성
		System.out.println("루트="+ tree.root.getName()); 			//tree루트 노드 이름 출력 //tree.root까지가 노드타입이다
		System.out.println("b의 부모="+b.getParent().getName()); 	//b 노드 부모 노드 이름 출력 //b.getParent 노드타입이다
		
		ArrayList<Node> list= b.getChildren(); 						//b 노드 자식 객체들 갯수와 이름들 출력 //노드타입x arrayList타입
		for(Node n : list){
			System.out.println("b의 이름"+ n.getName());
		}
		System.out.println("총 자식노드수= "+list.size());
			
		}
	}
