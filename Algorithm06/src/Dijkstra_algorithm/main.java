package Dijkstra_algorithm;

import java.util.*;
public class main {
	public static void main(String[] args) {
		int[][] weight = { // [그림 9-5-2](a)의 입력그래프
				{ 0, 1, 0, 2, 0, 0, 0, 0},
				{ 1, 0, 4 ,3, 1, 6, 0, 0}, 
				{ 0, 4, 0, 0, 0, 1, 1, 2}, 
				{ 2, 3, 0, 0, 5, 0, 0, 0}, 
				{ 0, 1, 0, 5, 0, 0, 2, 0}, 
				{ 0, 6, 1, 0, 0, 0, 0, 9}, 
				{ 0, 0, 1, 0, 2, 0, 0, 1}, 
				{ 0, 0, 2, 0, 0, 9, 1, 0}
		};

		
		int N = weight.length;
		List<Edge>[] adjList = new List[N];
		for (int i = 0; i < N; i++) { // 인접리스트 만들기
			adjList[i] = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				if (weight[i][j] != 0) {
					Edge e = new Edge(i, j, weight[i][j]);
					adjList[i].add(e);
				}
			}
		}

		
		System.out.println("======초기 그래프======");
		for (int i = 0; i < adjList.length; i++) {
			for (int j = 0; j < adjList[i].size(); j++) {
				System.out.print("(" + i + "," + adjList[i].get(j).adjVertex + ")=" + adjList[i].get(j).weight + "\t");
			}
			System.out.println();
		}
		System.out.println("========================");
		
		
		DijkstraSP d = new DijkstraSP(adjList);
		System.out.println("정점 0 으로부터의 최단거리");
		int[] distance = d.shortestPath(0);
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("0 과 " + i + " 사이에 경로 없음.");
			else
				System.out.println("[0, " + i + "] = " + distance[i]);
		}
		
		
		// 경로길이 0-1
		// 경로포함정점들 출력
		// 1-5 = 6 : 1-2-5= 4+1
		System.out.printf("\n정점 0 으로부터의 최단 경로\n");
		// d.previous[]: 5 4 2 1
		for (int i = 1; i < d.N; i++) {// 정점 0에서 다른 정점들 모두까지 반복
			int back = i; // 1
			System.out.print(back);// 가장 최근 방문정점
			// System.out.println("==> " + back +":"+ start);
			while (back != 0) {// start점에서 1개의 다른 정점까지 이전 방문정점 출력
				// start점 만나면 출력중지
				System.out.print("<-" + d.previous[back]);// 그이전 방문정점
				back = d.previous[back];
			}
			System.out.println();
		} 
		
	
		
		
		
		//test2:시작정점 변경시
/*		int start = 0;
		System.out.println("정점" + start + " 으로부터의 최단거리");
		int [] distance = d.shortestPath(start);
		
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println(start + "과 " + i +" 사이에 경로 없음.");			
			else
				//System.out.println("[0, " + i + "] = " +distance[i]);
				System.out.println("[" + start + "," + i + "] = " +distance[i]);
		}
		
		System.out.printf("\n정점 " + start + "으로부터의 최단 경로\n");
		
		for (int i = 1; i < d.N; i++){//정점 0에서 다른 정점들 모두까지 반복
			int back = i;
			System.out.print(back);//가장 최근 방문정점
			//System.out.println("==> " + back +":"+ start);
			while (back!= start) {//start점에서 1개의 다른 정점까지 이전 방문정점 출력
				//start점 만나면 출력중지
				System.out.print("<-"+d.previous[back]);//그이전 방문정점
				back = d.previous[back];
			}
			System.out.println();
		} */
		
//test3:4에서 7로 가는 최단거리
/*	int start = 4;
	int end = 7;
	System.out.println("정점" + start + " 으로부터의 최단거리");
	int [] distance = d.shortestPath(start);
	
	for (int i = 0; i < distance.length; i++) {
		if(i == end) {
		if (distance[i] == Integer.MAX_VALUE)
			System.out.println(start + "과 " + i +" 사이에 경로 없음.");			
		else
			//System.out.println("[0, " + i + "] = " +distance[i]);
			System.out.println("[" + start + "," + i + "] = " +distance[i]);
		}
	}
	
	System.out.printf("\n정점 " + start + "으로부터 " + end + "로의 최단 경로\n");
	
		System.out.print(end);//가장 최근 방문정점
		//System.out.println("==> " + back +":"+ start);
		while (end!= start) {//start점에서 1개의 다른 정점까지 이전 방문정점 출력
			//start점 만나면 출력중지
			System.out.print("<-"+d.previous[end]);//그이전 방문정점
			end = d.previous[end];
		}
		System.out.println();
		*/
	} 

}

