package kruskal_algorithm;

public class UnionFind { //부모 누구니
	int[] p ;
	int [] rank;
	UnionFind(int N){
		p = new int[N];//자신노드값 동일
		rank = new int[N];//0
		for(int i = 0; i < N; i++){ //반복문으로 초기값: (0-N,0)
			p[i] = i;
			rank[i] = 0;
		}
	}
	//i가 속한 트리에서 i의 부모를 찾아서 세팅
	//i의 부모의 부모까지 재귀 호출하여 찾는다
	int find(int i){
		if(i != p[i]){ //i노드의 parent값과 같아지는 경우, 자신 루트
			p[i] = find(p[i]);
		}
		return p[i];
	}
	
	void union(int i, int j){
		int iroot = find(i);
		int jroot = find(j);
		if(iroot == jroot){
			return;//사이클 중지.연결불필요.방문
		}
		if(rank[iroot] > rank[jroot]){
			p[jroot] = iroot;
		}
		else if(rank[iroot] > rank[jroot]){
			p[iroot] = jroot;
		}
		else{//같은 경우.랜덤
			p[jroot] = iroot;
			rank[iroot]++;
		}
	}
}
