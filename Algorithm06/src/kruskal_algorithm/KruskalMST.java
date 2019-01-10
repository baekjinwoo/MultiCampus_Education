package kruskal_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalMST {
	int N, M;//정점, 간선 수(7, ..)
	List<Edge> [] graph; //그래프자체가 배열
	UnionFind uf;
	Edge result[];//최단경로 Edge들
	
	
	KruskalMST(List<Edge> [] g, int numOfEdges){ //(adjList, M)
		graph = g;//그래프
		N = g.length;//정점수
		M = numOfEdges;//간선수
		uf = new UnionFind(N);
		result = new Edge[N-1];//최소경로포함 7-1 = 6
	}//생성자_end
	
	
	Edge[] mst() {
		// 1. Edge 들 weight 오름차순 정렬
		List<Edge> ascList = new ArrayList<Edge>(); //ascList에 Edge들을 저장하려고 한다
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].size(); j++) {
				ascList.add(graph[i].get(j)); //쫙 연결함
			}
		}

		Collections.sort(ascList, new Edge());
		System.out.println("====오름차순 정렬 확인===");
		for (int i = 0; i < graph.length; i++) {
			Edge e = ascList.get(i);
			System.out.println("(" + e.vertex + "," + e.adjVertex + ")=" + e.weight);
		}
		System.out.println();

		// 2. union find
		// 같은 부모인지 확인:같으면 중지
		// 다르면 : 랭크 큰 쪽 루트로
		int ascIndex = 0;
		int resultIndex = 0;
		while (resultIndex < N - 1) {// 7-1=6
			// 꺼낸다. ascIndex 증가하면서
			Edge e = ascList.get(ascIndex++);
			int u = e.vertex;
			int v = e.adjVertex;
			if (uf.find(u) != uf.find(v)) {
				// 두 점 하나 트리 구성
				uf.union(u, v);
				result[resultIndex] = e;
				resultIndex++;
			}
		}
		// find - union : 가능
		// resultIndex 증가하면서 result 배열 저장
		return result;
	}//mst_end
}
