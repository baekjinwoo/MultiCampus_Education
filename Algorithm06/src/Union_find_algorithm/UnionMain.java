package Union_find_algorithm;

public class UnionMain {
	public static void main(String[] args) {
		int N = 10;
		Node[] nodes = new Node[N];
		for (int i=0; i<=N-1; i++){
			nodes[i] = new Node(i, 0); //10개 (parent, rank); 초기값 :(0~9, 0) 		
		}
		System.out.println("=======초기값========");
		for(int i=0; i<=N-1; i++){
			System.out.print(nodes[i]+"  ");
		}
		System.out.println();
		
		//결과 확인용
		UnionFind uf = new UnionFind(nodes);
		uf.union(2,1);
		System.out.println("=======1번 수행========");
		for(int i=0; i<=N-1; i++){
			System.out.print(i+" : "+nodes[i]+"  ");
		}
		System.out.println("\n==================");
		

		uf.union(2,6);
		System.out.println("=======2번 수행========");
		for(int i=0; i<=N-1; i++){
			System.out.print(i+" : "+nodes[i]+"  ");
		}
		System.out.println("\n==================");
		
		uf.union(7,4);
		uf.union(5,2);
		uf.union(9,3);
		uf.union(8,7);
		uf.union(6,1);
		uf.union(4,2);
		
	}
}
