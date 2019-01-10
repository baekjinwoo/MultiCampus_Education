package Graph_Search;

import java.util.ArrayList;


//-------------------------------------------------------------------------------------------------------------------

//  		0						0
//		  1   2					1		2
//      3  4 5  6					3

// <그래프 두 가지 탐색방법>
// 1. DFS ( Depth first Search: 깊이우선탐색 ) ==> 아래로 검색하는 방법, 0-1-3-4/-2-5-6 and 0-1-3-2
// 2. BFS (Breadth first: 너비우선탐색 ) ==> 옆으로 검색하고 없으면 다음줄에서 다시 옆으로 검색하는 식으로, 0-1-2-3-4-5-6 and 0-1-2-3
//									   ==>  BFS가 아니고 인접탐색을 하기위한 DFS는 QUEUE 필수.
//									   ==> chap3 ==> binaryTree패키지 참고 
//									  ==> 임의의 정점에서 시작하여 이웃하는 하나의 정점을 방문하고 그 이웃을 또 방문하고 모두 방문했을땐, 이전정점으로 되돌아가 탐색하는 방법

//-------------------------------------------------------------------------------------------------------------------

public class Main {
	public static void main(String[] args) {
		ArrayList<Edge> []graph = 	new ArrayList[10];
		
		graph[0] = new ArrayList<>(); //0번 점
		Edge e1 = new Edge(1); //0과 인접한 첫번째 점은 1
		Edge e2 = new Edge(2); //0과 인접한 점 2
		graph[0].add(e1); 
		graph[0].add(e2); //값을 넣어주다
		
		graph[1] = new ArrayList<>(); 
		Edge e3 = new Edge(0); 
		Edge e4 = new Edge(3);
		graph[1].add(e3); 
		graph[1].add(e4);
		
		graph[2] = new ArrayList<>(); 
		Edge e5 = new Edge(0); 
		Edge e6 = new Edge(3);
		graph[2].add(e5); 
		graph[2].add(e6);
		
		graph[3] = new ArrayList<>(); 
		Edge e7 = new Edge(1); 
		Edge e8 = new Edge(2);
		Edge e9 = new Edge(8);
		Edge e10 = new Edge(9);
		graph[3].add(e7); 
		graph[3].add(e8);
		graph[3].add(e9); 
		graph[3].add(e10);
		
		graph[4] = new ArrayList<>(); 
		Edge e11 = new Edge(5); 
		graph[4].add(e11);
		
		graph[5] = new ArrayList<>(); 
		Edge e12 = new Edge(4); 
		Edge e13 = new Edge(6); 
		Edge e14 = new Edge(7); 
		graph[5].add(e12);
		graph[5].add(e13);
		graph[5].add(e14);
		
		graph[6] = new ArrayList<>(); 
		Edge e15 = new Edge(5); 
		Edge e16 = new Edge(7); 
		graph[6].add(e15);
		graph[6].add(e16);
		
		graph[7] = new ArrayList<>(); 
		Edge e17 = new Edge(5); 
		Edge e18 = new Edge(6); 
		graph[7].add(e17);
		graph[7].add(e18);
		
		graph[8] = new ArrayList<>(); 
		Edge e19 = new Edge(3); 
		graph[8].add(e19);
		
		graph[9] = new ArrayList<>(); 
		Edge e20 = new Edge(3); 
		graph[9].add(e20);
		
//		for(int i=0; i<graph.length; i++){
//			for(Edge e: graph[i]){
//				System.out.println
//				(i+ " 정점연결 - "+ e.adjVertex);
//	
//			}
//			
//		}

//그래프형태: 인접리스트 안에 배열형태
//검색방법: DFS기법 (깊이우선탐색)
//참고내용: p.373
		//DFS d = new DFS(graph); //기준점에서 연결점을 누구를 먼저 add했느냐에 따라서, p373의 값과 DFS의 결과값의 순서가 다를 수 있다
		

//그래프형태: 인접리스트 안에 배열형태
//검색방법: BFS기법 (너비우선탐색)
//참고내용: p.375
		BFS b = new BFS(graph); 
		
	}
}
