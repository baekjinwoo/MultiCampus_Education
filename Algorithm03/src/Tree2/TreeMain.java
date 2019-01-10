package Tree2;

import java.util.ArrayList;


public class TreeMain{
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
		
		
		MultiChildrenTree tree= new MultiChildrenTree(a); //a는 노드 			
		tree.printQueue();  //tree에 있는 메소드 출력
		System.out.println("루트="+ tree.root.getName()); 			
		System.out.println("b의 부모="+b.getParent().getName()); 	
		
		ArrayList<Node> list= b.getChildren(); 						
		for(Node n : list){
			System.out.println("b의 이름"+ n.getName());
		}
		System.out.println("총 자식노드수= "+list.size());
			
		}
	}
