package Union_find_algorithm;

public class UnionFind { //부모 누구니
	Node [] nodes;
	UnionFind(Node[] nodes){
		this.nodes=nodes;
	}
	
	//i가 속한 트리에서 i의 부모를 찾아서 세팅
	//i의 부모의 부모까지 재귀 호출하여 찾는다
	int find(int i){  //node parent 찾아 
		if(i != nodes[i].getParent()){
		nodes[i].setParent(find(nodes[i].getParent()));
		}
		return nodes[i].getParent();
	}
	
	//find(1) --> 1이라는 노드의 값을 찾아 리턴한다
	//node parent 찾아
	void union(int i, int j){
		int iroot = find(i);
		int jroot = find(j);
		if(iroot == jroot){
			return; //사이클이 생기는 상황에는 종료해라    1 -> 2 -> 4
		}			//   								   3 ->	 	3==4이면 종료해라

		if(nodes[iroot].getRank()>nodes[jroot].getRank()){ //i루트가 더 크면 i가 루트.
			nodes[jroot].setParent(iroot);
		}
		else if(nodes[iroot].getRank()<nodes[jroot].getRank()){//j가 더 크면 j가 루트
			nodes[iroot].setParent(jroot);
		}
		else{//같은 경우는, 누가 누구의 부모가 되도 상관없다
			nodes[jroot].setParent(iroot);  //iroot가 root(부모)인 경우.
			nodes[iroot].setRank( nodes[iroot].getRank()+1 ); //루트가 되는 노드의 rank +1
		}
	}
}
