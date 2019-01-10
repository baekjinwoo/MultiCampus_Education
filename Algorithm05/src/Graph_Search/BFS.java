package Graph_Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	//Edge: adjVertex: 따라서 조회 반복
	//이미 조회 adjVertext라면 생략
	//방법1. 각각의 점마다 (0과 1을 check 조회해서 결과가 t면 빼고 /f면 다시??) 
	
	//특정정점 : 큐 저장
	//반복 (큐 빌 떄까지): 큐 삭제+ 삭제정점 인접 점 
	//1번 방문 체크
	
	ArrayList<Edge> [] graph;
	boolean visited []; 
	public BFS(ArrayList<Edge>[] graph2){
		//10개 점 확인할 것
		//배열은 없고 선언만 된visited를 ===> new boolean[10] ; false초기화할 것
		
		this.graph=graph2;
		visited = new boolean[graph2.length];
		System.out.println("  bfs호출              visited[]       출력");
		System.out.println("====================================");
		for(int i=0; i<visited.length; i++){
			visited[i]=false;  //i번째를 false로 우선 초기화
		}
		for(int i=0; i<graph2.length; i++){
			if(!visited[i]){
				bfs(i); //재귀호출
			}
		}//for_end
	}//DFS_end
	
	//방문한적이 있는지? 없다면 다시 수행하도록
	//메소드 재귀호출이 곧 Stack이나 마찬가지이다
	public void bfs(int i){
		Queue<Integer> q = new LinkedList<>();
		visited[i] = true; 
		q.add(i);//현재점
		
		while(!q.isEmpty()){ //만약에 비어있다면 빠져나오도록 반복
			int j= q.remove(); //q에서 끄집어낸 값 j
			System.out.println("  bfs("+ j + ")" + "   visited[" +j+ "]="+visited[j]+  "   출력="+j); //0은 방문이 되었으니 true입니다
			for(Edge e : graph[j]){ //형태가 그래프인 배열의 j번째 점
				if(!visited[e.adjVertex]){ //나의 인접점이 방문한 적이 없냐? 방문된 것들은 빼라(= 방문되지않았을때만 true)
					q.add(e.adjVertex); //j번지점의 이웃한 점을 넣는다
					}
				}
			}
		for(Edge e : graph[i]){ //인접리스트
		if(!visited[e.adjVertex]){
			bfs(e.adjVertex); 	//나랑 연결되어져있는 인접점들만 찾아가게 되어있습니다.
			}
		}//for_end
	}//dfs_end




}
