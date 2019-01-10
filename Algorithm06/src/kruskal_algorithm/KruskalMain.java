package kruskal_algorithm;

import java.util.ArrayList;
import java.util.List;

public class KruskalMain {
public static void main(String args[]){
	//인접행렬
	int [][] weight = 
		{{0, 9, 10, 0, 0, 0, 0 }, //0노드에서 0~6노드 가중치
		{9, 0, 0, 10, 5, 0, 3 }, //1노드에서 0~6노드 가중치
		{10, 0, 0, 9, 7, 2, 0 },
		{0, 10, 9, 0, 0, 4, 8 },
		{0, 5, 7, 0, 0, 0, 1 },
		{0, 0, 2, 4, 0, 0, 6 },
		{0, 3, 0, 8, 1, 6, 0 }
		};
	
	int N = weight.length;//정점 수.7개
	int M = 0;// 간선 수

	List<Edge> adjList [] = new List [N]; // 배열타입 : adjList
	for(int i = 0; i < N; i++ ){
		adjList[i] = new ArrayList<Edge>();
		for(int j = 0; j < N ; j++){
			if(weight[i][j] != 0){
			Edge e = new Edge(i, j,weight[i][j]);
			adjList[i].add(e);
			M++;
			}
		}
	}
	
	//초기 그래프 출력
	System.out.println("====초기그래프====");
	for(int i = 0; i < adjList.length; i++ ){
		for(int j = 0; j < adjList[i].size() ; j++){
			System.out.println
			("("+i+","+adjList[i].get(j).adjVertex+")="+adjList[i].get(j).weight); //인접점과 가중치 출력
		}
	}
	
	//크루스칼 알고리즘 호출
	KruskalMST kru = new KruskalMST(adjList, M);
	Edge[] result = kru.mst();
	//출력
	//최단경로 (1, 2)=6 (2,3)=7 
	//오름차순 
	int sum = 0;
	System.out.println("====최단경로====");
	for(int i = 0; i < result.length; i++){
		System.out.println
		("("+result[i].vertex+","
		+result[i].adjVertex+")="
		+result[i].weight);
		sum += result[i].weight;
	}
	//총합:
	System.out.println("최소신장트리경로합=" + sum);
	
}
}


/*	KruskalMST kru = new KruskalMST
			(adjList, N);
	Edge [] result = kru.mst();
	//출력
	int sum = 0;
	System.out.println("====최단경로====");
	for(int i = 0; i < result.length ; i++){
		System.out.println
		("("+result[i].vertex +","+result[i].adjVertex+")="
		+result[i].weight);
		sum += result[i].weight;
	}
	System.out.println("최단경로합"+sum);*/