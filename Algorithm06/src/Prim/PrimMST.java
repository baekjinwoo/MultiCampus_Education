package Prim;

import java.util.List;

public class PrimMST {
	//변수
	int N;//점의 수
	List<Edge> graph [];
	
	//생성자
	PrimMST(List<Edge> graph []){
		this.graph = graph;
		N = graph.length;
		
	}
	
	/* 1.(첫번째 정점 ,인접 정점)들 가중치 비교
	 * 2. 첫번째 정점 가중치 = 0
	 *  */
	
	//값 초기화
	public int[] mst(int s) { //start할 점
		// 각 정점 방문 여부 저장 배열
		boolean[] visited = new boolean[N];
		// 가중치 저장 배열
		int[] D = new int[N];
		// 이전 정점 저장 배열
		int[] previous = new int[N];
		// 구현
		for (int i = 0; i < N; i++) {
			visited[i] = false;
			D[i] = Integer.MAX_VALUE;
			previous[i] = -1;
		}

		// ========================

		// 시작점
		previous[s] = 0;
		D[s] = 0;

		// 방문안된 정점들 가운데 최소값 가중치 가진 정점 찾기
		for (int k = 0; k < N; k++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			// k=0일 때 0과 다른 정점의 간선설정
			// D[0]=0. 나머진 무한대
			// k=1일 때 D[1], D[2] 64번 라인 반복문으로 갱신되었으므로
			// D[0], [1], [2] 만 값 있고 나머지는 무한대
			for (int j = 0; j < N; j++) {
				if (!visited[j] && D[j] < min) {
					min = D[j];// 0
					minVertex = j;// 0
				}
			}

			// ============간선 확인용 출력=============
			for (int j = 0; j < N; j++) {
				System.out.println("==>D[" + j + "]= " + D[j]);
			}
			System.out.println("+++" + minVertex);// 가장 작은 간선의 정점번호 0 1 6 4 5 2
													// 3....
			// ===============================

			// D[0]=0
			// minVertex: 0-인접정점 가중치 가장 작은 점
			visited[minVertex] = true;
			for (Edge i : graph[minVertex]) {
				if (!visited[i.adjVertex]) {
					// System.out.println("==>"+i+":" +i.adjVertex
					// +":"+D[i.adjVertex]+":"+i.weight);
					// D[2]=무한대, i.weight=10
					int currentDist = D[i.adjVertex];// D[1]
					int newDist = i.weight;// 0점 인접들(1)=>9
					// D[minVertex] + i.weight;
					if (newDist < currentDist) {
						D[i.adjVertex] = newDist;
						previous[i.adjVertex] = minVertex;
					}
				}
			}
			System.out.println("\n\n===D출력===");
			for (int i = 0; i < N; i++) {
				System.out.print(k + "-" + i + " 가중치=" + D[i] + "\t");
			}
			System.out.println("\n\n===previous출력===");
			for (int i = 0; i < N; i++) {
				System.out.print("previous[" + i + "]=" + previous[i] + " , ");
			}
			System.out.println("\n\n===visited출력===");
			for (int i = 0; i < N; i++) {
				System.out.print("visited[" + i + "]=" + visited[i] + " , ");
			}
			System.out.println("=====================");
		} // for(k=0...) end
		return previous;// 최단경로 정점 번호들 []
	}
}
