package Graph_Search;

import java.util.ArrayList;

public class DFS {
	//Edge: adjVertex: 따라서 조회 반복
	//이미 조회 adjVertext라면 생략
	//방법1. 각각의 점마다 (0과 1을 check 조회해서 결과가 t면 빼고 /f면 다시??) 
	
		//그래프형태: 인접리스트 안에 배열형태
		//검색방법: DFS기법 (너비우선탐색)
		//참고내용: p.373	
	ArrayList<Edge> [] graph;
	boolean visited []; 
	public DFS(ArrayList<Edge>[] graph2){
		//10개 점 확인할 것
		//배열은 없고 선언만 된visited를 ===> new boolean[10] ; false초기화할 것
		
		this.graph=graph2;
		visited = new boolean[graph2.length];
		System.out.println("  dfs호출              visited[]       출력");
		System.out.println("====================================");
		for(int i=0; i<visited.length; i++){
			visited[i]=false;  //i번째를 false로 우선 초기화
		}
		for(int i=0; i<graph2.length; i++){
			if(!visited[i]){
				dfs(i); //재귀호출
			}
		}//for_end
	}//DFS_end
	
	//방문한적이 있는지? 없다면 다시 수행하도록
	//메소드 재귀호출이 곧 Stack이나 마찬가지이다
	public void dfs(int i){
		visited[i] = true; 
		System.out.println("  dfs("+ i + ")" + "   visited[" +i+ "]="+visited[i]+  "   출력="+i); //0은 방문이 되었으니 true입니다
		for(Edge e : graph[i]){ //인접리스트
		if(!visited[e.adjVertex]){
			dfs(e.adjVertex); 	//나랑 연결되어져있는 인접점들만 찾아가게 되어있습니다.
			}
		}//for_end
	}//dfs_end




}
