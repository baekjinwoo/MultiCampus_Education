package Dijkstra_algorithm;

import java.util.List;

public class DijkstraSP {
	//변수
	int N;//점의 수
	List<Edge> graph [];
	int [] previous; //shortestPath메서드의 지역변수를 없애고 맴버변수로 선언
	//new DijstraSP().previous
	
	
	//생성자
	DijkstraSP(List<Edge> graph []){
		this.graph = graph;
		N = graph.length;
		
	}
	
	
	public int[] shortestPath(int s) { // start할 점
		// 각 정점 방문 여부 저장 배열
		boolean[] visited = new boolean[N];
		// 가중치 저장 배열 ex) int a = 10;는 a로가는 가중치가 10
		int[] D = new int[N];
		// 이전 정점 저장 배열
		previous = new int[N];
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

		// 방문안된 정점들 가운데 최소값 가중치 가진
		// 정점 찾기
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
					int currentDist = D[i.adjVertex];// D[1]
					int newDist = D[minVertex] + i.weight;// 0점 인접들(1)=>9
					if (newDist < currentDist) {
						D[i.adjVertex] = newDist;
						previous[i.adjVertex] = minVertex;
					}
				}
			}//for_end
		}//for_end
		return D;// D[1]=?
		
		
	}//shortestPath_end
}
